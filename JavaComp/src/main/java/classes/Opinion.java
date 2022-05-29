package classes;

import java.io.Serializable;
import java.time.LocalDate;

public class Opinion implements Serializable {

    private int calificacion; //Del 1 al 5
    private String comentario;
    private LocalDate fechaRealizacion;

    public Opinion(int calificacion, String comentario, LocalDate fechaRealizacion) {
        this.calificacion = calificacion;
        this.comentario = comentario;
        this.fechaRealizacion = fechaRealizacion;
    }

    @Override
    public String toString() {
        return "Opinion{" + "calificacion=" + calificacion + ", comentario=" + comentario + ", fechaRealizacion=" + fechaRealizacion + '}';
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public LocalDate getFechaRealizacion() {
        return fechaRealizacion;
    }

    public void setFechaRealizacion(LocalDate fechaRealizacion) {
        this.fechaRealizacion = fechaRealizacion;
    }

}
