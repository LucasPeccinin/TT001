package model;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lucas Peccinin
 */
public abstract class DAO { //abstract - não será instanciada por ninguém. Serve para definir métodos úteis para as classes derivadas
    public static final String DBURL = "jdbc:sqlite:vet.db";
    private static Connection con;
    protected static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    
    //conexao com o sqlite
    
    public static Connection getConnection(){
        if(con == null){
            try {
                con = DriverManager.getConnection(DBURL);
                if(con == null){
                    DatabaseMetaData meta = con.getMetaData();
                }
            } catch (SQLException e){
                System.err.println("Error: "+e.getMessage());
            }
            
        }
        return con;
    }
    
    protected ResultSet getResultSet(String query){ //classe que permite consultar o retorno do banco de dados
        Statement st;
        ResultSet rs = null;
        try {
            st = (Statement) con.createStatement();
            rs = st.executeQuery(query);
        }
        catch(SQLException e){
            System.err.println("Error: " + e.getMessage());
        }
        return rs;
    }
    
    protected int executeUpdate(PreparedStatement queryStatement) throws SQLException{
        int update;
        update = queryStatement.executeUpdate();
        return update;
    }
    
    protected int lastId(String tableName, String primaryKey){
        Statement s;
        int lastId = -1;
        try {
            s = (Statement) con.createStatement();
            ResultSet rs = s.executeQuery("SELECT MAX("+ primaryKey +") AS ID FROM " + tableName);
            if(rs.next()){
                lastId = rs.getInt("id");
            }
        }
        catch(SQLException e){
            System.err.println("Error: " + e.getMessage());
        }
        return lastId;
    }
    
    public static void terminar(){
        try {
            (DAO.getConnection()).close();
        }
        catch (SQLException e) {
            System.err.println("Erro: " + e.getMessage());
        }
    }
    
    protected final boolean createTable(){
        try {
            PreparedStatement stmt;
            //TABELA CLIENTE
            stmt = DAO.getConnection().prepareStatement(
                        "CREATE TABLE IF NOT EXISTS CLIENTE(\n" +
                        "ID INTEGER PRIMARY KEY, \n" +
                        "NOME VARCHAR,\n" +
                        "CPF VARCHAR,\n" +
                        "CEP VARCHAR,\n" +
                        "EMAIL VARCHAR,\n" +
                        "TELEFONE VARCHAR);");
            executeUpdate(stmt);
            //TABELA ANIMAL
            stmt = DAO.getConnection().prepareStatement(
                        "CREATE TABLE IF NOT EXISTS ANIMAL(\n" +
                        "ID INTEGER PRIMARY KEY, \n" +
                        "NOME VARCHAR,\n" +
                        "IDADE INTEGER,\n" +
                        "SEXO VARCHAR,\n" +
                        "ESPECIE INTEGER,\n" +
                        "CLIENTE INTEGER);");
            executeUpdate(stmt);
            //TABELA ESPECIE
            stmt = DAO.getConnection().prepareStatement(
                        "CREATE TABLE IF NOT EXISTS ESPECIE(\n" +
                        "ID INTEGER PRIMARY KEY, \n" +
                        "NOME VARCHAR);");
            executeUpdate(stmt);
            //TABELA VETERINARIO
            stmt = DAO.getConnection().prepareStatement(
                        "CREATE TABLE IF NOT EXISTS VETERINARIO(\n" +
                        "ID INTEGER PRIMARY KEY, \n" +
                        "NOME VARCHAR,\n" +
                        "EMAIL VARCHAR,\n" +
                        "TELEFONE VARCHAR,\n" +
                        "CEP VARCHAR);"); 
            executeUpdate(stmt);
            //TABELA TRATAMENTO
            stmt = DAO.getConnection().prepareStatement(
                        "CREATE TABLE IF NOT EXISTS TRATAMENTO(\n" +
                        "ID INTEGER PRIMARY KEY, \n" +
                        "ANIMAL INTEGER,\n" +
                        "NOME VARCHAR,\n" +
                        "INICIO VARCHAR,\n" +
                        "FIM VARCHAR,\n" +
                        "FINALIZADO INTEGER);"); 
            executeUpdate(stmt);
            //TABELA CONSULTA
            stmt = DAO.getConnection().prepareStatement(
                        "CREATE TABLE IF NOT EXISTS CONSULTA(\n" +
                        "ID INTEGER PRIMARY KEY, \n" +
                        "ANIMAL INTEGER,\n" +
                        "VETERINARIO INTEGER,\n" +
                        "TRATAMENTO INTEGER,\n" +
                        "COMENTARIOS VARCHAR,\n" +
                        "HORA INT,\n" +
                        "DATA DATE,\n" +
                        "FINALIZADO INTEGER);"); 
            executeUpdate(stmt);
            //TABELA EXAME
            stmt = DAO.getConnection().prepareStatement(
                        "CREATE TABLE IF NOT EXISTS EXAME(\n" +
                        "ID INTEGER PRIMARY KEY, \n" +
                        "NOME VARCHAR,\n" +
                        "CONSULTA INTEGER);");
            executeUpdate(stmt);
            return true;
        }
        catch (SQLException err){
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, err);
        }
        return false;
    }
}
