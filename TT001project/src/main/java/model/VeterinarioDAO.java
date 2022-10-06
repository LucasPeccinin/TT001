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
public class VeterinarioDAO extends DAO{
    private static VeterinarioDAO instance;
    
    private VeterinarioDAO(){
        getConnection();
        createTable();
    }
    
    public static VeterinarioDAO getInstance(){
        return (instance==null?(instance = new VeterinarioDAO()):instance);
    }
    
    //CRUD
    public Veterinario create(String nome, String email, String telefone, String cep){
        try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("INSERT INTO VETERINARIO(NOME, EMAIL, TELEFONE ,CEP) VALUES (?,?,?,?)");
            stmt.setString(1, nome);
            stmt.setString(2, email);
            stmt.setString(3, telefone);
            stmt.setString(4, cep);
            executeUpdate(stmt);
        }    
        catch (SQLException err){
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE,null,err);
        }
        return this.retrieveById(lastId("veterinario","id"));
    }
    
    public List retrieve(String query){
        List<Veterinario> veterinarios = new ArrayList();
        ResultSet rs = getResultSet(query);
        try {
            while (rs.next()) {
                veterinarios.add(buildObject(rs));
            }
        }
        catch (SQLException e) {
            System.err.println("Erro: " + e.getMessage());
        }
        return veterinarios;
    }
    
    private Veterinario buildObject(ResultSet rs){
        Veterinario veterinario = null;
        try{
            veterinario = new Veterinario(rs.getInt("ID"), rs.getString("NOME"), rs.getString("CEP"), rs.getString("EMAIL"), rs.getString("TELEFONE"));
        }
        catch (SQLException e) {
            System.err.println("Erro: " + e.getMessage());
        }
        return veterinario;
    }
    
    public List retrieveAll(){
        return this.retrieve("SELECT * FROM VETERINARIO");
    }
    
    public Veterinario retrieveById(int id){
        List<Veterinario> veterinarios = this.retrieve("SELECT * FROM VETERINARIO WHERE ID = "+ id);
        return (veterinarios.isEmpty()?null:veterinarios.get(0));
    }
    
    public List retrieveBySimilarName(String nome){
        return this.retrieve("SELECT * FROM VETERINARIO WHERE NOME LIKE '%"+nome+"%'");
    }
    
    public void update(Veterinario veterinario){
        try{
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("UPDATE VETERINARIO SET NOME = ?, CEP = ?, EMAIL = ?, TELEFONE = ? WHERE ID = ?");
            stmt.setString(1, veterinario.getNome());
            stmt.setString(2, veterinario.getCep());
            stmt.setString(3, veterinario.getEmail());
            stmt.setString(4, veterinario.getTelefone());
            stmt.setInt(5, veterinario.getId());
            executeUpdate(stmt);
        }
        catch (SQLException e){
            System.err.println("Erro: " + e.getMessage());
        }
    }
    
    public void delete(Veterinario veterinario){
        PreparedStatement stmt;
        try{
            stmt = DAO.getConnection().prepareStatement("DELETE FROM VETERINARIO WHERE ID = ?");
            stmt.setInt(1, veterinario.getId());
            executeUpdate(stmt);
        }
        catch (SQLException e){
            System.err.println("Erro: " + e.getMessage());
        }
    }
}
