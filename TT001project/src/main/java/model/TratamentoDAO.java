package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
public class TratamentoDAO extends DAO {
    private static TratamentoDAO instance;
    
    private TratamentoDAO(){
        getConnection();
        createTable();
    }
    
    public static TratamentoDAO getInstance(){
        return (instance==null?(instance = new TratamentoDAO()):instance);
    }
    
    //CRUD
    public Tratamento create(int animal, String nome, String inicio, String fim, boolean finalizado){
        try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("INSERT INTO TRATAMENTO(ANIMAL, NOME, INICIO, FIM, FINALIZADO) VALUES (?,?,?,?,?)");
            stmt.setInt(1, animal);
            stmt.setString(2, nome);
            stmt.setString(3, inicio);
            stmt.setString(4, fim);
            stmt.setBoolean(5, finalizado);
            executeUpdate(stmt);
        }    
        catch (SQLException err){
            Logger.getLogger(TratamentoDAO.class.getName()).log(Level.SEVERE,null,err);
        }
        return this.retrieveById(lastId("tratamento","id"));
    }
    
    public List retrieve(String query){
        List<Tratamento> tratamentos = new ArrayList();
        ResultSet rs = getResultSet(query);
        try {
            while (rs.next()) {
                tratamentos.add(buildObject(rs));
            }
        }
        catch (SQLException e) {
            System.err.println("Erro: " + e.getMessage());
        }
        return tratamentos;
    }
    
    private Tratamento buildObject(ResultSet rs){
        Tratamento tratamento = null;
        try{
            tratamento = new Tratamento(rs.getInt("ID"), rs.getInt("ANIMAL"), rs.getString("NOME"), rs.getString("INICIO"), rs.getString("FIM"), rs.getBoolean("FINALIZADO"));
        }
        catch (SQLException e) {
            System.err.println("Erro: " + e.getMessage());
        }
        return tratamento;
    }
    
    public List retrieveAll(){
        return this.retrieve("SELECT * FROM TRATAMENTO");
    }
    
    public List retriveLast(){
        return this.retrieve("SELECT * FROM TRATAMENTO WHERE ID = " + lastId("tratamento", "id"));
    }
    
    public Tratamento retrieveById(int id){
        List<Tratamento> tratamentos = this.retrieve("SELECT * FROM TRATAMENTO WHERE ID = "+ id);
        return (tratamentos.isEmpty()?null:tratamentos.get(0));
    }
    
    public List retrieveBySimilarName(String nome){
        return this.retrieve("SELECT * FROM TRATAMENTO WHERE NOME LIKE '%"+nome+"%'");
    }
    
    public boolean isLastEmpty(){
        Tratamento lastTratamento = this.retrieveById(lastId("tratamento", "id"));
        if (lastTratamento != null){
            return lastTratamento.getNome().isBlank();
        }
        return false;
    }
    
    public void update(Tratamento tratamento){
        try{
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("UPDATE TRATAMENTO SET NOME = ?, INICIO = ?, FIM = ?, FINALIZADO = ? WHERE ID = ?");
            stmt.setString(1, tratamento.getNome());
            stmt.setString(2, tratamento.getInicio());
            stmt.setString(3, tratamento.getFim());
            stmt.setBoolean(4, tratamento.isFinalizado());
            stmt.setInt(6, tratamento.getId());
            executeUpdate(stmt);
        }
        catch (SQLException e){
            System.err.println("Erro: "+e.getMessage());
        }
    }
    
    public void delete(Tratamento tratamento){
        PreparedStatement stmt;
        try{
            stmt = DAO.getConnection().prepareStatement("DELETE * FROM TRATAMENTO WHERE ID = ?");
            stmt.setInt(1, tratamento.getId());
            executeUpdate(stmt);
        }
        catch (SQLException e){
            System.err.println("Erro: "+e.getMessage());
        }
    }
}
