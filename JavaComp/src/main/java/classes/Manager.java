package classes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Manager {

    private static ArrayList<Producto> productos = UtilProducto.getProductos();

    /**
     *
     * Busqueda de productos haya o no palabras
     *
     * @param texto
     * @param categorias
     * @param tipoBusqueda
     * @return
     */
    public static ArrayList<Producto> BuscarProductos(String texto, List<String> categorias, String tipoBusqueda) {
        ArrayList productosAMostrar = new ArrayList<>();
        if (texto == null || texto.isBlank()) {
            if (categorias.size() >= 1) {
                for (int i = 0; i < categorias.size(); i++) {
                    for (Producto producto : productos) {
                        if (producto.getCategoria().equals(categorias.get(i).toString())) {
                            productosAMostrar.add(producto);
                        }
                    }
                }
            }

        } else ////////CUANDO SI QUE HAY PALABRAS
        {
            String[] palabras;
            palabras = texto.split(" ");

            if (categorias.size() >= 1) {
                for (int i = 0; i < palabras.length; i++) {
                    for (int j = 0; j < categorias.size(); j++) {
                        for (Producto producto : productos) {
                            if ((producto.getCategoria().equals(categorias.get(j).toString())) && producto.getTitulo().contains(palabras[i])) {
                                productosAMostrar.add(producto);
                            }
                        }
                    }
                }
            }

        }
        if (tipoBusqueda.equals("Por relevancia")) {
            productosAMostrar = ordenarProductosPorRelevancia(productosAMostrar);
        } else if (tipoBusqueda.equals("Por mayor precio")) {
            productosAMostrar = ordenarProductosPorPrecioMayor(productosAMostrar);
        } else if (tipoBusqueda.equals("Por menor precio")) {
            productosAMostrar = ordenarProductosPorPrecioMenor(productosAMostrar);
        }
        return productosAMostrar;

    }
    /**
     * Ordenación de los productos por relevancia
     * @param productosAOrdenar
     * @return 
     */
    public static ArrayList<Producto> ordenarProductosPorRelevancia(ArrayList<Producto> productosAOrdenar) {
        //Comparador para ordenar los clientes por su nombre
        Comparator NomCliComp = new Comparator() {

            @Override
            public int compare(Object o1, Object o2) {
                Producto p1 = (Producto) o1;
                Producto p2 = (Producto) o2;
                return Double.compare(p1.getOpinionMedia(), p2.getOpinionMedia());
            }
        };
        //Ordenamos el array

        Collections.sort(productosAOrdenar, NomCliComp);
        Collections.reverse(productosAOrdenar);
        return productosAOrdenar;
    }
    /**
     * Ordenación de los productos de mayor a menor precio
     * @param productosAOrdenar
     * @return 
     */
    public static ArrayList<Producto> ordenarProductosPorPrecioMayor(ArrayList<Producto> productosAOrdenar) {
        //Comparador para ordenar los clientes por su nombre
        Comparator NomCliComp = new Comparator() {

            @Override
            public int compare(Object o1, Object o2) {
                Producto p1 = (Producto) o1;
                Producto p2 = (Producto) o2;
                return Double.compare(p1.getPrecio(), p2.getPrecio());
            }
        };
        //Ordenamos el array
        Collections.sort(productosAOrdenar, NomCliComp);
        Collections.reverse(productosAOrdenar);
        return productosAOrdenar;
    }
    /**
     * Ordenación de los productos de menor a mayor precio
     * @param productosAOrdenar
     * @return 
     */
    public static ArrayList<Producto> ordenarProductosPorPrecioMenor(ArrayList<Producto> productosAOrdenar) {
        //Comparador para ordenar los clientes por su nombre
        Comparator NomCliComp = new Comparator() {

            @Override
            public int compare(Object o1, Object o2) {
                Producto p1 = (Producto) o1;
                Producto p2 = (Producto) o2;
                return Double.compare(p1.getPrecio(), p2.getPrecio());
            }
        };
        //Ordenamos el array
        Collections.reverseOrder(NomCliComp);

        Collections.sort(productosAOrdenar, NomCliComp);
        return productosAOrdenar;
    }

}
