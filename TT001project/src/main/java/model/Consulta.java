package model;

import java.util.Calendar;
import java.util.Date;

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
    private String data;
    private int finalizado;
    //1 - finalizado 2 - não finalizado

    public Consulta(int id, int veterinario, int animal, int tratamento, String comentarios, int hora, String data, int finalizado) {
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

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getFinalizado() {
        return finalizado;
    }

    public void setFinalizado(int finalizado) {
        this.finalizado = finalizado;
    }
    
    @Override
    public String toString() {        
        return "Consulta{" + "id=" + id + ", vet=" + veterinario + ", animal=" + animal + ", cometarios=" + comentarios + ", hora=" + hora + ", data=" + data + ", finalizado=" + finalizado + '}';
    }
    
}
