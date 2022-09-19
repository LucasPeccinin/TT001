package model;

/**
 *
 * @author Lucas Peccinin
 */
public class Animal {
    private int id;
    private String nome;
    private int idade;
    private String sexo; 
    private int cliente;
    private int especie;

    public Animal(int id, String nome, int idade, String sexo, int cliente, int especie) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
        this.cliente = cliente;
        this.especie = especie;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getCliente() {
        return cliente;
    }

    public void setCliente(int cliente) {
        this.cliente = cliente;
    }

    public int getEspecie() {
        return especie;
    }

    public void setEspecie(int especie) {
        this.especie = especie;
    }
    
    @Override
    public String toString() {
        return "Animal{" + "nome= " + nome + ", idade= " + idade +'}';
    }
    
}
