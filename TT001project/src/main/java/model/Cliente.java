package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lucas Peccinin
 */
public class Cliente {
    private int id;
    private String nome;
    private String cpf;
    private String cep;
    private String email;
    
    private List<Animal> animais;

    public Cliente(int id, String nome, String cpf, String cep, String email) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.cep = cep;
        this.email = email;
        this.animais = new ArrayList<Animal>();
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) { //CPF NÃO PODERÁ SER NULO
        if(!cpf.equals("")){
            this.cpf = cpf;
        }
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public void addAnimal(Animal animal){
        if(animal.getNome().isBlank()){
            animais.add(animal);
        }
    }
}
