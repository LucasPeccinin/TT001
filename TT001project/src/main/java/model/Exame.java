package model;

/**
 *
 * @author Lucas Peccinin
 */
public class Exame {
    private int id;
    private String descricao;
    private int consulta;

    public Exame(int id, String descricao, int consulta) {
        this.id = id;
        this.descricao = descricao;
        this.consulta = consulta;
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getConsulta() {
        return consulta;
    }
}
