package classes;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Cliente implements Serializable {

    private String nombre;
    private String correo;
    private String clave;
    private Direccion direccion;
    private Tarjeta tarjeta;
    private int telefono;
    private ArrayList<Producto> carrito;

    public Cliente(String nombre, String correo, String clave, Direccion direccion, Tarjeta tarjeta, int telefono, ArrayList<Producto> carrito) {
        this.nombre = nombre;
        this.correo = correo;
        this.clave = clave;
        this.direccion = direccion;
        this.tarjeta = tarjeta;
        this.telefono = telefono;
        this.carrito = carrito;
    }

    @Override
    public String toString() {
        return "Cliente{" + "nombre=" + nombre + ", correo=" + correo + ", clave=" + clave + ", direccion=" + direccion + ", tarjeta=" + tarjeta + ", telefono=" + telefono + ", carrito=" + carrito + '}';
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public Tarjeta getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(Tarjeta tarjeta) {
        this.tarjeta = tarjeta;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public ArrayList<Producto> getCarrito() {
        return carrito;
    }

    public void setCarrito(ArrayList<Producto> carrito) {
        this.carrito = carrito;
    }
    /**
     * Este modulo permite añadir productos al carrito
     * @param producto
     * @return 
     */
    public boolean addToCarrito(Producto producto) {
        if (producto == null) {
            return false;
        } else {
            carrito.add(producto);
            return true;
        }

    }
    /**
     * Este modulo permite eliminar productos del carrito
     * @param producto
     * @return 
     */
    public boolean removeFromCarrito(Producto producto) {
        if (producto == null) {
            return false;
        } else if (carrito.contains(producto)) {
            carrito.remove(producto);
            return true;
        } else {
            return false;
        }
    }
    /**
     * Este modulo permite eliminar todos los productos del carrito
     */
    public void clearCarrito() {
        carrito.clear();
    }

}
