package model;

import java.util.Calendar;

/**
 *
 * @author Lucas Peccinin
 */
public class Consulta {
    private int id;
    private int veterinario;
    private int animal;
    private int tratamento;
    private String comentarios;
    private int hora;
    private Calendar data;
    private boolean finalizado;

    public Consulta(int id, int veterinario, int animal, int tratamento, String comentarios, int hora, Calendar data, boolean finalizado) {
        this.id = id;
        this.veterinario = veterinario;
        this.animal = animal;
        this.tratamento = tratamento;
        this.comentarios = comentarios;
        this.hora = hora;
        this.data = data;
        this.finalizado = finalizado;
    }

    public int getId() {
        return id;
    }


    public int getVeterinario() {
        return veterinario;
    }

    public int getAnimal() {
        return animal;
    }

    public int getTratamento() {
        return tratamento;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public boolean isFinalizado() {
        return finalizado;
    }

    public void setFinalizado(boolean finalizado) {
        this.finalizado = finalizado;
    }
    
    
}
