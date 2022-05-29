package classes;

import interfaces.Login;
import java.io.*;
import java.util.*;

public class UtilRegistro {

    private static ArrayList<Cliente> clientes = new ArrayList<Cliente>();

    /**
     * Establece el ArrayList de clientes
     *
     * @param p
     */
    public static void setClientes(ArrayList<Cliente> p) {
        clientes = p;
    }

    /**
     * @return Devuelve el ArrayList de clientes
     */
    public static ArrayList<Cliente> getClientes() {
        //Comparador para ordenar los clientes por su nombre
        Comparator NomCliComp = new Comparator() {

            @Override
            public int compare(Object o1, Object o2) {
                Cliente p1 = (Cliente) o1;
                Cliente p2 = (Cliente) o2;
                return p1.getNombre().compareTo(p2.getNombre());
            }
        };
        //Ordenamos el array
        Collections.sort(clientes, NomCliComp);
        return clientes;
    }

    /**
     * Da de alta un cliente
     *
     * @param objcli
     * @return boolean
     */
    public static boolean registroCliente(Cliente objcli) {
        if (!clientes.contains(objcli)) {
            clientes.add(objcli);
            return true;
        } else {
            return false;
        }

    }

    /**
     * Devuelve una persona por la posición dentro del ArrayList
     *
     * @param indice
     * @return objcli
     */
    public static Cliente consultaCliente(int indice) {
        return clientes.get(indice);
    }

    /**
     * Modifica los datos de un cliente
     *
     * @param cli
     * @param cli_nombre
     * @param cli_correo
     * @param cli_clave
     * @param cli_direccion
     * @param cli_telefono
     * @param cli_dni
     * @param cli_cif
     * @param cli_web
     * @return boolean
     */
    public static boolean modificaCliente(Cliente cli, String cli_nombre, String cli_correo, String cli_clave, Direccion cli_direccion, int cli_telefono, String cli_dni, String cli_cif, String cli_web, ArrayList<Producto> cli_carrito) {
        if (cli == null || !clientes.contains(cli)) {
            return false;
        } else {
            cli.setNombre(cli_nombre);
            cli.setCorreo(cli_correo);
            cli.setClave(cli_clave);
            cli.setDireccion(cli_direccion);
            cli.setTelefono(cli_telefono);
            cli.setCarrito(cli_carrito);
            String tipo = cli.getClass().getSimpleName();
            if (tipo.equals("ClienteEmpresa")) {
                ClienteEmpresa emp = (ClienteEmpresa) cli;
                emp.setCIF(cli_cif);
                emp.setWeb(cli_web);
            } else {
                ClienteParticular part = (ClienteParticular) cli;
                part.setDNI(cli_dni);
            }
            return true;
        }
    }

    /**
     * Carga los datos de personas del fichero
     */
    public static void cargarDatos() {
        try {
            //Lectura de los objetos de tipo persona
            FileInputStream istreamCli = new FileInputStream("copiasegCli.dat");
            ObjectInputStream oisCli = new ObjectInputStream(istreamCli);
            clientes = (ArrayList) oisCli.readObject();
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
            if (!clientes.isEmpty()) {
                /**
                 * **** Serialización de los objetos *****
                 */
                //Serialización de las personas
                FileOutputStream ostreamCli = new FileOutputStream("copiasegCli.dat");
                ObjectOutputStream oosCli = new ObjectOutputStream(ostreamCli);
                //guardamos el array de personas
                oosCli.writeObject(clientes);
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
