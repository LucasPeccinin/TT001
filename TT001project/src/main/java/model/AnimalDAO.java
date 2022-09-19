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
public class AnimalDAO extends DAO {
    private static AnimalDAO instance;
    
    private AnimalDAO(){
        getConnection();
        createTable();
    }
    
    public static AnimalDAO getInstance(){
        return (instance==null?(instance = new AnimalDAO()):instance);
    }
    
    //CRUD
    public Animal create(String nome, int idade, String sexo, int cliente, int especie){
        try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("INSERT INTO ANIMAL(NOME, IDADE, SEXO, CLIENTE, ESPECIE) VALUES (?,?,?,?,?)");
            stmt.setString(1, nome);
            stmt.setInt(2, idade);
            stmt.setString(3, sexo);
            stmt.setInt(4, cliente);
            stmt.setInt(5, especie);
            executeUpdate(stmt);
        }    
        catch (SQLException err){
            Logger.getLogger(AnimalDAO.class.getName()).log(Level.SEVERE,null,err);
        }
        return this.retrieveById(lastId("animal","id"));
    }
    
    public List retrieve(String query){
        List<Animal> animais = new ArrayList();
        ResultSet rs = getResultSet(query);
        try {
            while (rs.next()) {
                animais.add(buildObject(rs));
            }
        }
        catch (SQLException e) {
            System.err.println("Erro: " + e.getMessage());
        }
        return animais;
    }
    
    private Animal buildObject(ResultSet rs){
        Animal animal = null;
        try{
            animal = new Animal(rs.getInt("ID"), rs.getString("NOME"), rs.getInt("IDADE"), rs.getString("SEXO"), rs.getInt("CLIENTE"), rs.getInt("ESPECIE"));
        }
        catch (SQLException e) {
            System.err.println("Erro: " + e.getMessage());
        }
        return animal;
    }
    
    public List retrieveAll(){
        return this.retrieve("SELECT * FROM ANIMAL");
    }
    
    public List retriveLast(){
        return this.retrieve("SELECT * FROM ANIMAL WHERE ID = " + lastId("animal", "id"));
    }
    
    public Animal retrieveById(int id){
        List<Animal> animais = this.retrieve("SELECT * FROM ANIMAL WHERE ID = "+ id);
        return (animais.isEmpty()?null:animais.get(0));
    }
    
    public List retrieveByIdCliente(int cliente){
        return this.retrieve("SELECT * FROM ANIMAL WHERE CLIENTE = " + cliente);
    }
    
    public List retrieveByIdEspecie(int especie){
        return this.retrieve("SELECT * FROM ANIMAL WHERE ESPECIE = " + especie );
    }
    
    public List retrieveBySimilarName(String nome){
        return this.retrieve("SELECT * FROM ANIMAL WHERE NOME LIKE '%"+nome+"%'");
    }
    
    public boolean isLastEmpty(){
        Animal lastAnimal = this.retrieveById(lastId("animal", "id"));
        if (lastAnimal != null){
            return lastAnimal.getNome().isBlank();
        }
        return false;
    }
    
    public void update(Animal animal){
        try{
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("UPDATE ANIMAL SET NOME = ?, IDADE = ?, SEXO = ?, CLIENTE = ?, ESPECIE = ? WHERE ID = ?");
            stmt.setString(1, animal.getNome());
            stmt.setInt(2, animal.getIdade());
            stmt.setString(3, animal.getSexo());
            stmt.setInt(4, animal.getCliente());
            stmt.setInt(5, animal.getEspecie());
            stmt.setInt(6, animal.getId());
            executeUpdate(stmt);
        }
        catch (SQLException e){
            System.err.println("Erro: "+e.getMessage());
        }
    }
    
    public void delete(Animal animal){
        PreparedStatement stmt;
        try{
            stmt = DAO.getConnection().prepareStatement("DELETE * FROM ANIMAL WHERE ID = ?");
            stmt.setInt(1, animal.getId());
            executeUpdate(stmt);
        }
        catch (SQLException e){
            System.err.println("Erro: "+e.getMessage());
        }
    }
}
            