package classes;

import java.io.Serializable;
import java.util.Date;

public class Tarjeta implements Serializable {

    private String nombreTitular;
    private long numero;
    private Date fecha;

    public Tarjeta(String nombreTitular, long numero, Date fecha) {
        this.nombreTitular = nombreTitular;
        this.numero = numero;
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Tarjeta{" + "nombreTitular=" + nombreTitular + ", numero=" + numero + ", fecha=" + fecha + '}';
    }

    public String getNombreTitular() {
        return nombreTitular;
    }

    public void setNombreTitular(String nombreTitular) {
        this.nombreTitular = nombreTitular;
    }

    public long getNumero() {
        return numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * Modifica los datos de una tarjeta
     *
     * @param tar
     * @param tar_titular
     * @param tar_numTarj
     * @param tar_fechaCad
     * @return boolean
     */
    public static boolean modificaTarjeta(Tarjeta tar, String tar_titular, long tar_numTarj, Date tar_fechaCad) {
        tar.setNombreTitular(tar_titular);
        tar.setNumero(tar_numTarj);
        tar.setFecha(tar_fechaCad);
        return true;
    }
}
