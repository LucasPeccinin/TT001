package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lucas Peccinin
 */
public class ClienteDAO extends DAO {
    private static ClienteDAO instance;
    
    private ClienteDAO(){
        getConnection();
        createTable();
    }
    
    public static ClienteDAO getInstance(){
        return (instance==null?(instance = new ClienteDAO()):instance);
    }
    
    //CRUD
    public Cliente create(String nome, String cpf, String cep, String email, String telefone){
        try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("INSERT INTO CLIENTE(NOME, CPF, CEP ,EMAIL, TELEFONE) VALUES (?,?,?,?,?)");
            stmt.setString(1, nome);
            stmt.setString(2, cpf);
            stmt.setString(3, cep);
            stmt.setString(4, email);
            stmt.setString(5, telefone);
            executeUpdate(stmt);
        }    
        catch (SQLException err){
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE,null,err);
        }
        return this.retrieveById(lastId("cliente","id"));
    }
    
    public List retrieve(String query){
        List<Cliente> clientes = new ArrayList();
        ResultSet rs = getResultSet(query);
        try {
            while (rs.next()) {
                clientes.add(buildObject(rs));
            }
        }
        catch (SQLException e) {
            System.err.println("Erro: " + e.getMessage());
        }
        return clientes;
    }
    
    private Cliente buildObject(ResultSet rs){
        Cliente cliente = null;
        try{
            cliente = new Cliente(rs.getInt("id"), rs.getString("nome"), rs.getString("cpf"), rs.getString("cep"), rs.getString("email"), rs.getString("telefone"));
        }
        catch (SQLException e) {
            System.err.println("Erro: " + e.getMessage());
        }
        return cliente;
    }
    
    public List retrieveAll(){
        return this.retrieve("SELECT * FROM CLIENTE");
    }
    
    public List retriveLast(){
        return this.retrieve("SELECT * FROM CLIENTE WHERE ID = " + lastId("cliente", "id"));
    }
    
    public Cliente retrieveById(int id){
        List<Cliente> clientes = this.retrieve("SELECT * FROM CLIENTE WHERE ID = "+ id);
        return (clientes.isEmpty()?null:clientes.get(0));
    }
    
    public List retrieveBySimilarName(String nome){
        return this.retrieve("SELECT * FROM CLIENTE WHERE NOME LIKE '%"+nome+"%'");
    }
    
    public boolean isLastEmpty(){
        Cliente lastCliente = this.retrieveById(lastId("cliente", "id"));
        if (lastCliente != null){
            return lastCliente.getNome().isBlank();
        }
        return false;
    }
    
    public void update(Cliente cliente){
        try{
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("UPDATE CLIENTE SET NOME = ?, CPF = ?, CEP = ?, EMAIL = ?, TELEFONE = ? WHERE ID = ?");
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());
            stmt.setString(3, cliente.getCep());
            stmt.setString(4, cliente.getEmail());
            stmt.setString(5, cliente.getTelefone());
            stmt.setInt(6, cliente.getId());
            executeUpdate(stmt);
        }
        catch (SQLException e){
            System.err.println("Erro: "+e.getMessage());
        }
    }
    
    public void delete(Cliente cliente){
        PreparedStatement stmt;
        try{
            stmt = DAO.getConnection().prepareStatement("DELETE * FROM CLIENTE WHERE ID = ?");
            stmt.setInt(1, cliente.getId());
            executeUpdate(stmt);
        }
        catch (SQLException e){
            System.err.println("Erro: "+e.getMessage());
        }
    }
}
            