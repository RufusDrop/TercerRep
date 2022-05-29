package classes;

import java.io.Serializable;
import java.util.ArrayList;

public class ClienteParticular extends Cliente implements Serializable {

    private String DNI;

    public ClienteParticular(String nombre, String correo, String clave, Direccion direccion, Tarjeta tarjeta, int telefono, String DNI, ArrayList<Producto> carrito) {
        super(nombre, correo, clave, direccion, tarjeta, telefono, carrito);
        this.DNI = DNI;
    }

    @Override
    public String toString() {
        return super.toString() + "ClienteParticular{" + "DNI=" + DNI + '}';
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

}
