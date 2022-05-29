
package classes;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Venta implements Serializable {
    private ArrayList<String> compra;
    private double precio;
    private Cliente comprador;
    private LocalDate fechaCompra;

    public Venta(ArrayList<String> compra, double precio, Cliente comprador,LocalDate fechaCompra) {
        this.compra = compra;
        this.precio = precio;
        this.comprador = comprador;
        this.fechaCompra = fechaCompra;
    }

    public Venta() {
    }

    @Override
    public String toString() {
        return "Venta{" + "compra=" + compra + ", precio=" + precio + ", comprador=" + comprador + ", fechaCompra=" + fechaCompra + '}';
    }
    
            
            

    public LocalDate getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(LocalDate fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    
    

    public ArrayList<String> getCompra() {
        return compra;
    }

    public void setCompra(ArrayList<String> compra) {
        this.compra = compra;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Cliente getComprador() {
        return comprador;
    }

    public void setComprador(Cliente comprador) {
        this.comprador = comprador;
    }
    
}
