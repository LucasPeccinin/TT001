package model;

/**
 *
 * @author Lucas Peccinin
 */
public class Veterinario {
    private int id;
    private String nome;
    private String email;
    private String telefone;
    private String cep;

    public Veterinario(int id, String nome, String email, String telefone, String cep) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.cep = cep;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    @Override
    public String toString() {        
        return "Veterinario{" + "id=" + id + ", nome=" + nome + ", email=" + email + ", telefone=" + telefone + ", cep=" + cep + '}';
    }
}
