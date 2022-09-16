package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static model.DAO.getConnection;

/**
 *
 * @author Lucas Peccinin
 */
public class ExameDAO extends DAO{
    private static ExameDAO instance;
    
    private ExameDAO(){
        getConnection();
        createTable();
    }
    
    public static ExameDAO getInstance(){
        return (instance==null?(instance = new ExameDAO()):instance);
    }
    
    //CRUD
    public Exame create(String nome, int consulta){
        try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("INSERT INTO EXAME(NOME, CONSULTA) VALUES (?,?)");
            stmt.setString(1, nome);
            stmt.setInt(2, consulta);
            executeUpdate(stmt);
        }    
        catch (SQLException err){
            Logger.getLogger(ExameDAO.class.getName()).log(Level.SEVERE,null,err);
        }
        return this.retrieveById(lastId("exame","id"));
    }
    
    public List retrieve(String query){
        List<Exame> exames = new ArrayList();
        ResultSet rs = getResultSet(query);
        try {
            while (rs.next()) {
                exames.add(buildObject(rs));
            }
        }
        catch (SQLException e) {
            System.err.println("Erro: " + e.getMessage());
        }
        return exames;
    }
    
    private Exame buildObject(ResultSet rs){
        Exame exame = null;
        try{
            exame = new Exame(rs.getInt("ID"), rs.getString("NOME"), rs.getInt("CONSULTA"));
        }
        catch (SQLException e) {
            System.err.println("Erro: " + e.getMessage());
        }
        return exame;
    }
    
    public List retrieveAll(){
        return this.retrieve("SELECT * FROM EXAME");
    }
    
    public List retriveLast(){
        return this.retrieve("SELECT * FROM EXAME WHERE ID = " + lastId("exame", "id"));
    }
    
    public Exame retrieveById(int id){
        List<Exame> exames = this.retrieve("SELECT * FROM EXAME WHERE ID = "+ id);
        return (exames.isEmpty()?null:exames.get(0));
    }
    
    public List retrieveBySimilarName(String nome){
        return this.retrieve("SELECT * FROM EXAME WHERE NOME LIKE '%"+nome+"%'");
    }
    
    public boolean isLastEmpty(){
        Exame lasExame = this.retrieveById(lastId("exame", "id"));
        if (lasExame != null){
            return lasExame.getNome().isBlank();
        }
        return false;
    }
    
    public void update(Exame exame){
        try{
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("UPDATE EXAME SET NOME = ? WHERE ID = ?");
            stmt.setString(1, exame.getNome());
            stmt.setInt(2, exame.getId());
            executeUpdate(stmt);
        }
        catch (SQLException e){
            System.err.println("Erro: "+e.getMessage());
        }
    }
    
    public void delete(Exame exame){
        PreparedStatement stmt;
        try{
            stmt = DAO.getConnection().prepareStatement("DELETE * FROM EXAME WHERE ID = ?");
            stmt.setInt(1, exame.getId());
            executeUpdate(stmt);
        }
        catch (SQLException e){
            System.err.println("Erro: "+e.getMessage());
        }
    }
}
