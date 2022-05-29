package interfaces;

import classes.Producto;
import classes.UtilProducto;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.border.EtchedBorder;

public class ProductoPanel extends javax.swing.JPanel {

    private MainMenu Parent;
    private Producto productoBase;

    /**
     * Creates new form ProductoPanel
     */
    public ProductoPanel(Producto producto, MainMenu parent) {
        initComponents();
        mostrarProducto(producto);
        Parent = parent;
        productoBase = producto;

        //SE LE AÑADE UN BORDER
        this.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
    }

    private void mostrarProducto(Producto producto) {
        jLabelNombreProducto.setText(producto.getTitulo());
        jLabelDescripcion.setText("\"" + producto.getDescripcion() + "\"");
        jLabelPrecio.setText("Precio: " + String.valueOf(producto.getPrecio()));
        jLabelStock.setText("Stock: " + String.valueOf(producto.getStock()));
        jLabelPuntuacionMedia.setText("Puntuación: " + String.valueOf(producto.getOpinionMedia()));
        jLabelFotoProducto.setIcon(new ImageIcon(getClass().getResource("/images/" + producto.getFotoProducto())));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelNombreProducto = new javax.swing.JLabel();
        jLabelFotoProducto = new javax.swing.JLabel();
        jLabelDescripcion = new javax.swing.JLabel();
        jLabelPrecio = new javax.swing.JLabel();
        jLabelStock = new javax.swing.JLabel();
        jLabelPuntuacionMedia = new javax.swing.JLabel();

        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                formMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                formMouseExited(evt);
            }
        });
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelNombreProducto.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabelNombreProducto.setText("NombreProducto");
        add(jLabelNombreProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(229, 14, 1014, -1));

        jLabelFotoProducto.setBackground(new java.awt.Color(51, 51, 51));
        add(jLabelFotoProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 186, 179));

        jLabelDescripcion.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabelDescripcion.setText("Descripcion");
        add(jLabelDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(229, 73, 1014, 24));

        jLabelPrecio.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabelPrecio.setText("Precio: precio");
        add(jLabelPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(229, 117, 161, -1));

        jLabelStock.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabelStock.setText("Puntuacion media:");
        add(jLabelStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 120, 360, -1));

        jLabelPuntuacionMedia.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabelPuntuacionMedia.setText("Stock: stock");
        add(jLabelPuntuacionMedia, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 120, 161, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // TODO add your handling code here:
        Parent.mostrarProductoSeleccionado(productoBase);
        UtilProducto.productoActual = productoBase;
    }//GEN-LAST:event_formMouseClicked

    private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered
        // TODO add your handling code here:
        this.setBorder(BorderFactory.createLineBorder(Color.white));
    }//GEN-LAST:event_formMouseEntered

    private void formMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseExited
        // TODO add your handling code here:
        this.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
    }//GEN-LAST:event_formMouseExited

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelDescripcion;
    private javax.swing.JLabel jLabelFotoProducto;
    private javax.swing.JLabel jLabelNombreProducto;
    private javax.swing.JLabel jLabelPrecio;
    private javax.swing.JLabel jLabelPuntuacionMedia;
    private javax.swing.JLabel jLabelStock;
    // End of variables declaration//GEN-END:variables
}
