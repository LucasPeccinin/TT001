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
    private String inicio;
    private String fim;
    private boolean finalizado;

    public Tratamento(int id, int animal, String nome, String inicio, String fim, boolean finalizado) {
        this.id = id;
        this.animal = animal;
        this.nome = nome;
        this.inicio = inicio;
        this.fim = fim;
        this.finalizado = finalizado;
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

    public String getInicio() {
        return inicio;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    public String getFim() {
        return fim;
    }

    public void setFim(String fim) {
        this.fim = fim;
    }

    public boolean isFinalizado() {
        return finalizado;
    }

    public void setFinalizado(boolean finalizado) {
        this.finalizado = finalizado;
    }

    
}
