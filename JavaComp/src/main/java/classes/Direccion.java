package classes;

import java.io.Serializable;

public class Direccion implements Serializable {

    private String direccion;
    private int codigoPostal;
    private String ciudad;
    private int numero;
    private String extra;

    public Direccion(String calle, int numero, String extra, int codigoPostal, String ciudad) {
        this.direccion = calle;
        this.numero = numero;
        this.codigoPostal = codigoPostal;
        this.ciudad = ciudad;
        this.extra = extra;
    }

    @Override
    public String toString() {
        return "Direccion{" + "calle=" + direccion + ", numero=" + numero + ", codigoPostal=" + codigoPostal + ", ciudad=" + ciudad + ", letra, piso, puerta=" + extra + '}';
    }

    public String getCalle() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

}
