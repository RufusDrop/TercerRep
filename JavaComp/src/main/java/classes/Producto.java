package classes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.awt.Image;
import java.io.Serializable;

public class Producto implements Serializable {

    private String titulo;
    private String descripcion;
    private String categoria;
    private double precio;
    private String fotoProducto;
    private int stock;
    private LocalDate fechaDeEntrada;
    private ArrayList<Opinion> opiniones = new ArrayList<Opinion>();

    public Producto(String titulo, String descripcion, String categoria, double precio, String fotoProducto, int stock, LocalDate fechaDeEntrada, ArrayList<Opinion> opiniones) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.precio = precio;
        this.fotoProducto = fotoProducto;
        this.stock = stock;
        this.fechaDeEntrada = fechaDeEntrada;
        this.opiniones = opiniones;
    }

    @Override
    public String toString() {
        return "Producto{" + "titulo=" + titulo + ", caracteristicas=" + descripcion + ", categoria=" + categoria + ", precio=" + precio + ", fotoProducto=" + fotoProducto + ", stock=" + stock + ", fechaDeEntrada=" + fechaDeEntrada + ", opiniones=" + opiniones + '}';
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String caracteristicas) {
        this.descripcion = caracteristicas;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getFotoProducto() {
        return fotoProducto;
    }

    public void setFotoProducto(String fotoProducto) {
        this.fotoProducto = fotoProducto;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public LocalDate getFechaDeEntrada() {
        return fechaDeEntrada;
    }

    public void setFechaDeEntrada(LocalDate fechaDeEntrada) {
        this.fechaDeEntrada = fechaDeEntrada;
    }

    public ArrayList<Opinion> getOpiniones() {
        return opiniones;
    }

    public void setOpiniones(ArrayList<Opinion> opiniones) {
        this.opiniones = opiniones;
    }

    /**
     * Devuelve la media de las calificaciones de las opiniones
     * @return 
     */
    public double getOpinionMedia() {

        if (opiniones != null && opiniones.size() != 0) {
            double suma = 0;
            for (int i = 0; i < opiniones.size(); i++) {
                if ((opiniones.get(i).getCalificacion() != -1)) {
                    suma = suma + opiniones.get(i).getCalificacion();
                }
            }
            String sumaStr = String.valueOf(suma);
            return (Double.parseDouble(sumaStr) / opiniones.size());
        } else {
            return 0;
        }

    }

    /**
     * Se añade una opinion a la lista asegurandose de que no se repita
     * @param opinion 
     */
    public void addOpinion(Opinion opinion) {
        opiniones.add(opinion);
    }
    /**
     * Se elimina una opinión de la lista 
     * @param opinion 
     */
    public void removeOpinion(Opinion opinion) {
        opiniones.remove(opinion);
    }

}
