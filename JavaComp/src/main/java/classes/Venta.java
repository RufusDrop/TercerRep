
package classes;

import java.util.ArrayList;

public class Venta {
    private ArrayList<Producto> compra;
    private double precio;
    private Cliente comprador;

    public Venta(ArrayList<Producto> compra, double precio, Cliente comprador) {
        this.compra = compra;
        this.precio = precio;
        this.comprador = comprador;
    }

    @Override
    public String toString() {
        return "Venta{" + "compra=" + compra + ", precio=" + precio + ", comprador=" + comprador + '}';
    }
    

    public ArrayList<Producto> getCompra() {
        return compra;
    }

    public void setCompra(ArrayList<Producto> compra) {
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
