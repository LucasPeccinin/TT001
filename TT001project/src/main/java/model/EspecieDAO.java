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
public class EspecieDAO extends DAO {
    private static EspecieDAO instance;
    
    private EspecieDAO(){
        getConnection();
        createTable();
    }
    
    public static EspecieDAO getInstance(){
        return (instance==null?(instance = new EspecieDAO()):instance);
    }
    
    //CRUD
    public Especie create(String nome){
        try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("INSERT INTO ESPECIE(NOME) VALUES (?)");
            stmt.setString(1, nome);
            executeUpdate(stmt);
        }    
        catch (SQLException err){
            Logger.getLogger(EspecieDAO.class.getName()).log(Level.SEVERE,null,err);
        }
        return this.retrieveById(lastId("especie","id"));
    }
    
    public List retrieve(String query){
        List<Especie> especies = new ArrayList();
        ResultSet rs = getResultSet(query);
        try {
            while (rs.next()) {
                especies.add(buildObject(rs));
            }
        }
        catch (SQLException e) {
            System.err.println("Erro: " + e.getMessage());
        }
        return especies;
    }
    
    private Especie buildObject(ResultSet rs){
        Especie especie = null;
        try{
            especie = new Especie(rs.getInt("ID"), rs.getString("NOME"));
        }
        catch (SQLException e) {
            System.err.println("Erro: " + e.getMessage());
        }
        return especie;
    }
    
    public List retrieveAll(){
        return this.retrieve("SELECT * FROM ESPECIE");
    }
        
    public Especie retrieveById(int id){
        List<Especie> especies = this.retrieve("SELECT * FROM ESPECIE WHERE ID = "+ id);
        return (especies.isEmpty()?null:especies.get(0));
    }
    
    public List retrieveBySimilarName(String nome){
        return this.retrieve("SELECT * FROM ESPECIE WHERE NOME LIKE '%"+nome+"%'");
    }
    
    public void update(Especie especie){
        try{
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("UPDATE ESPECIE SET NOME = ? WHERE ID = ?");
            stmt.setString(1, especie.getNome());
            stmt.setInt(6, especie.getId());
            executeUpdate(stmt);
        }
        catch (SQLException e){
            System.err.println("Erro: "+e.getMessage());
        }
    }
    
    public void delete(Especie especie){
        PreparedStatement stmt;
        try{
            stmt = DAO.getConnection().prepareStatement("DELETE * FROM ESPECIE WHERE ID = ?");
            stmt.setInt(1, especie.getId());
            executeUpdate(stmt);
        }
        catch (SQLException e){
            System.err.println("Erro: "+e.getMessage());
        }
    }
}
