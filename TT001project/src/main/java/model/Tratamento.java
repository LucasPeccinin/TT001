package model;

import java.util.Calendar;

/**
 *
 * @author Lucas Peccinin
 */
public class Tratamento {
    private int id;
    private int animal;
    private String nome;
    private Calendar dtInicio;
    private Calendar dtFim;
    private int idAnimal;
    private boolean terminou;

    public Tratamento(int id, int animal, String nome, Calendar dtInicio, Calendar dtFim, int idAnimal, boolean terminou) {
        this.id = id;
        this.animal = animal;
        this.nome = nome;
        this.dtInicio = dtInicio;
        this.dtFim = dtFim;
        this.idAnimal = idAnimal;
        this.terminou = terminou;
    }

    public int getId() {
        return id;
    }

    public int getAnimal() {
        return animal;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Calendar getDtInicio() {
        return dtInicio;
    }

    public void setDtInicio(Calendar dtInicio) {
        this.dtInicio = dtInicio;
    }

    public Calendar getDtFim() {
        return dtFim;
    }

    public void setDtFim(Calendar dtFim) {
        this.dtFim = dtFim;
    }

    public int getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(int idAnimal) {
        this.idAnimal = idAnimal;
    }

    public boolean isTerminou() {
        return terminou;
    }

    public void setTerminou(boolean terminou) {
        this.terminou = terminou;
    }

    
}
