package model;

/**
 *
 * @author Lucas Peccinin
 */
public class Especie {
    private int id;
    private String nome;

    public Especie(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
    
    @Override
    public String toString() {
        return "Especie{" + "id=" + id + ", nome=" + nome +'}';
    }

}
