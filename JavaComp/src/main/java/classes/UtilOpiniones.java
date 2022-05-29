package classes;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class UtilOpiniones {

    private static ArrayList<Opinion> opiniones = new ArrayList<Opinion>();
    private static Opinion opicli;

    /**
     * Establece el ArrayList de productos
     *
     * @param p
     */
    public static void setOpiniones(ArrayList<Opinion> o) {
        opiniones = o;
    }

    /**
     * @return Devuelve el ArrayList de productos
     */
    public static ArrayList<Opinion> getOpiniones() {
        //Comparador para ordenar los clientes por su nombre
        Comparator NomCliComp = new Comparator() {

            @Override
            public int compare(Object o1, Object o2) {
                Opinion p1 = (Opinion) o1;
                Opinion p2 = (Opinion) o2;
                return p1.getFechaRealizacion().compareTo(p2.getFechaRealizacion());
            }
        };
        //Ordenamos el array
        Collections.sort(opiniones, NomCliComp);
        return opiniones;
    }

    /**
     * Da de alta un producto
     *
     * @param objcli
     * @return boolean
     */
    public static boolean altaOpinion(Opinion opicli) {
        if (!opiniones.contains(opicli)) {
            opiniones.add(opicli);
            return true;
        } else {
            return false;
        }

    }

    /**
     * Devuelve una producto por la posición dentro del ArrayList
     *
     * @param indice
     * @return objcli
     */
    public static Opinion consultaOpinion(int indice) {
        opicli = opiniones.get(indice);
        return opicli;
    }

    /**
     * Modifica los datos de una persona
     *
     * @param cli
     * @param cli_titulo
     * @param cli_descripcion
     * @param cli_categoria
     * @param cli_precio
     * @param cli_fotoProducto
     * @param cli_stock
     * @param cli_fechaDeEntrada
     * @param opiniones
     * @return boolean
     */
    /**
     * Carga los datos de productos del fichero
     */
    public static void cargarDatos() {
        try {
            //Lectura de los objetos de tipo persona
            FileInputStream istreamCli = new FileInputStream("copiasegCli.dat");
            ObjectInputStream oisCli = new ObjectInputStream(istreamCli);
            opiniones = (ArrayList) oisCli.readObject();
            istreamCli.close();
        } catch (IOException ioe) {
            System.out.println("Error de IO: " + ioe.getMessage());
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Error de clase no encontrada: " + cnfe.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }//fin cargarDatos

    /**
     * Guarda los datos de personas en el fichero
     */
    public static void guardarDatos() {
        try {
            //Si hay datos los guardamos...
            if (!opiniones.isEmpty()) {
                /**
                 * **** Serialización de los objetos *****
                 */
                //Serialización de las personas
                FileOutputStream ostreamCli = new FileOutputStream("copiasegCli.dat");
                ObjectOutputStream oosCli = new ObjectOutputStream(ostreamCli);
                //guardamos el array de personas
                oosCli.writeObject(opiniones);
                ostreamCli.close();
            } else {
                System.out.println("Error: No hay datos...");
            }

        } catch (IOException ioe) {
            System.out.println("Error de IO: " + ioe.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }//fin guardarDatos
}
