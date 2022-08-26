package model;

/**
 *
 * @author Lucas Peccinin
 */
public class Animal {
    private int id;
    private String nome;
    private int idade;
    private int sexo; //0 - macho, 1 - Femea

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

    public int getSexo() {
        return sexo;
    }

    public void setSexo(int sexo) {
        this.sexo = sexo;
    }
    
    
}
