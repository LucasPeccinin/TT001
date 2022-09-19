package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static model.DAO.getConnection;

/**
 *
 * @author Lucas Peccinin
 */
public class ConsultaDAO extends DAO{
    private static ConsultaDAO instance;
    
    private ConsultaDAO(){
        getConnection();
        createTable();
    }
    
    public static ConsultaDAO getInstance(){
        return (instance==null?(instance = new ConsultaDAO()):instance);
    }
    
    //CRUD
    public Consulta create(int veterinario, int animal, int tratamento, String comentarios, int hora, Calendar data, boolean finalizado){
        try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("INSERT INTO CONSULTA(VETERINARIO, ANIMAL, TRATAMENTO, COMENTARIOS, HORA, DATA, FINALIZADO) VALUES (?,?,?,?,?,?,?)");
            stmt.setInt(1, veterinario);
            stmt.setInt(2, animal);
            stmt.setInt(3, tratamento);
            stmt.setString(4, comentarios);
            stmt.setInt(5, hora);
            stmt.setString(6, dateFormat.format(data.getTime()));
            stmt.setInt(7, (finalizado?"1":"0"));
            executeUpdate(stmt);
        }    
        catch (SQLException err){
            Logger.getLogger(ConsultaDAO.class.getName()).log(Level.SEVERE,null,err);
        }
        return this.retrieveById(lastId("consulta","id"));
    }
    
    public List retrieve(String query){
        List<Consulta> consultas = new ArrayList();
        ResultSet rs = getResultSet(query);
        try {
            while (rs.next()) {
                consultas.add(buildObject(rs));
            }
        }
        catch (SQLException e) {
            System.err.println("Erro: " + e.getMessage());
        }
        return consultas;
    }
    
    private Consulta buildObject(ResultSet rs){
        Consulta consulta = null;
        try{
            Calendar dt = Calendar.getInstance();
            dt.setTime(dateFormat.parse(rs.getString("data")));
            consulta = new Consulta(rs.getInt("ID"),rs.getInt("VETERINARIO"), rs.getInt("ANIMAL"), rs.getInt("TRATAMENTO"), rs.getString("COMENTARIOS"), rs.getInt("HORA"), dt, rs.getInt("FINALIZADO")==1);
        }
        catch (SQLException e) {
            System.err.println("Erro: " + e.getMessage());
        }
        catch (ParseException ex){
            Logger.getLogger(ConsultaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return consulta;
    }
    
    public List retrieveAll(){
        return this.retrieve("SELECT * FROM CONSULTA");
    }
    
    public List retriveLast(){
        return this.retrieve("SELECT * FROM CONSULTA WHERE ID = " + lastId("consulta", "id"));
    }
    
    public Consulta retrieveById(int id){
        List<Consulta> consultas = this.retrieve("SELECT * FROM CONSULTA WHERE ID = "+ id);
        return (consultas.isEmpty()?null:consultas.get(0));
    }

    public void update(Consulta consulta){
        try{
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("UPDATE CONSULTA SET COMENTARIOS = ?, HORA = ?, DATA = ?, FINALIZADO = ?, WHERE ID = ?");
            stmt.setString(1, consulta.getComentarios());
            stmt.setInt(2, consulta.getHora());
            stmt.setString(3, dateFormat.format(consulta.getData().getTime()));
            stmt.setInt(4, (consulta.isFinalizado()?1:0));
            stmt.setInt(6, consulta.getId());
            executeUpdate(stmt);
        }
        catch (SQLException e){
            System.err.println("Erro: "+e.getMessage());
        }
    }
    
    public void delete(Consulta consulta){
        PreparedStatement stmt;
        try{
            stmt = DAO.getConnection().prepareStatement("DELETE * FROM CONSULTA WHERE ID = ?");
            stmt.setInt(1, consulta.getId());
            executeUpdate(stmt);
        }
        catch (SQLException e){
            System.err.println("Erro: "+e.getMessage());
        }
    }
}
