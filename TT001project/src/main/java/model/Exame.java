package model;

/**
 *
 * @author Lucas Peccinin
 */
public class Exame {
    private int id;
    private String nome;
    private int consulta;

    public Exame(int id, String nome, int consulta) {
        this.id = id;
        this.nome = nome;
        this.consulta = consulta;
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

    public int getConsulta() {
        return consulta;
    }

    public void setConsulta(int consulta) {
        this.consulta = consulta;
    }
    
    @Override
    public String toString(){
        return nome;
    }
    
    
}
