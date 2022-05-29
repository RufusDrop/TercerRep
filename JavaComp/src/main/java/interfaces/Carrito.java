package interfaces;

import classes.Cliente;
import classes.Producto;
import classes.UtilProducto;
import classes.UtilRegistro;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.ListModel;

public class Carrito extends javax.swing.JDialog {

    private Cliente clienteActual;
    private java.awt.Frame Parent;
    /**
     * Creates new form Carrito
     */
    public Carrito(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        clienteActual = Login.objcli;
        mostrarProductos();
        Parent = parent;
    }

    public void mostrarProductos() {
        DefaultListModel listModel = new DefaultListModel();
        double suma = 0;
        if (clienteActual.getCarrito().size() > 0) {
            jButtonComprarTodo.setEnabled(true);
            for (int i = 0; i < clienteActual.getCarrito().size(); i++) {
                String[] separacion = clienteActual.getCarrito().get(i).getTitulo().split("x");
                int unidades = Integer.parseInt(separacion[1]);
                String nombre = separacion[0];
                suma += clienteActual.getCarrito().get(i).getPrecio() * unidades;

                String productoAMostrar = clienteActual.getCarrito().get(i).getTitulo() + " (" + clienteActual.getCarrito().get(i).getPrecio() * unidades + "€)";
                listModel.addElement(productoAMostrar);
            }
        } else {
            jButtonComprarTodo.setEnabled(false);

        }
        jListProductos.setModel(listModel);
        jLabelPrecioTotalValor.setText(String.valueOf(suma) + "€");

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonComprarTodo = new javax.swing.JButton();
        jButtonVaciarCarrito = new javax.swing.JButton();
        jButtonEliminarSeleccion = new javax.swing.JButton();
        jLabelPrecioTotal = new javax.swing.JLabel();
        jLabelPrecioTotalValor = new javax.swing.JLabel();
        jScrollPaneProductos = new javax.swing.JScrollPane();
        jListProductos = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jButtonComprarTodo.setBackground(new java.awt.Color(51, 70, 127));
        jButtonComprarTodo.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButtonComprarTodo.setForeground(new java.awt.Color(119, 224, 224));
        jButtonComprarTodo.setText("COMPRAR TODO");
        jButtonComprarTodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonComprarTodoActionPerformed(evt);
            }
        });

        jButtonVaciarCarrito.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButtonVaciarCarrito.setText("Vaciar el carrito");
        jButtonVaciarCarrito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVaciarCarritoActionPerformed(evt);
            }
        });

        jButtonEliminarSeleccion.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButtonEliminarSeleccion.setText("Eliminar selección del carrito");
        jButtonEliminarSeleccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarSeleccionActionPerformed(evt);
            }
        });

        jLabelPrecioTotal.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabelPrecioTotal.setText("Precio total:");

        jLabelPrecioTotalValor.setFont(new java.awt.Font("Segoe UI", 2, 24)); // NOI18N
        jLabelPrecioTotalValor.setText("12123");

        jListProductos.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jListProductos.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jListProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListProductosMouseClicked(evt);
            }
        });
        jScrollPaneProductos.setViewportView(jListProductos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(85, Short.MAX_VALUE)
                .addComponent(jScrollPaneProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 860, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 79, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(158, 158, 158)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonEliminarSeleccion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonVaciarCarrito, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabelPrecioTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelPrecioTotalValor, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButtonComprarTodo, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(79, 79, 79))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jScrollPaneProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelPrecioTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelPrecioTotalValor, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jButtonEliminarSeleccion)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonVaciarCarrito)
                    .addComponent(jButtonComprarTodo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonEliminarSeleccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarSeleccionActionPerformed
        // TODO add your handling code here:
        int[] productosSeleccionados = jListProductos.getSelectedIndices();
        //JOptionPane.showMessageDialog(this, productosSeleccionados[0], "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        ArrayList<Producto> carrito = clienteActual.getCarrito();
        ArrayList<Producto> eliminables = new ArrayList<Producto>();
        for (int i = 0; i < productosSeleccionados.length; i++) {
            eliminables.add(carrito.get(productosSeleccionados[i]));
        }
        for (Producto producto : eliminables) {
            String[] separacion = producto.getTitulo().split("x");
            int unidades = Integer.parseInt(separacion[1]);
            String nombre = separacion[0];
            for (int i = 0; i < UtilProducto.getProductos().size(); i++) {
                if(UtilProducto.getProductos().get(i).getTitulo().equals(nombre)){
                    UtilProducto.getProductos().get(i).setStock(UtilProducto.getProductos().get(i).getStock()+unidades);
                }
            }
            clienteActual.removeFromCarrito(producto);
            
        }
        
        mostrarProductos();
        UtilRegistro.guardarDatos();
        ((MainMenu) Parent).reloadProductos();
    }//GEN-LAST:event_jButtonEliminarSeleccionActionPerformed

    private void jListProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListProductosMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jListProductosMouseClicked

    private void jButtonVaciarCarritoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVaciarCarritoActionPerformed
        // TODO add your handling code here:
         ArrayList<Producto> carrito = clienteActual.getCarrito();
         for (Producto producto : carrito) {
            String[] separacion = producto.getTitulo().split("x");
            int unidades = Integer.parseInt(separacion[1]);
            String nombre = separacion[0];
            for (int i = 0; i < UtilProducto.getProductos().size(); i++) {
                if(UtilProducto.getProductos().get(i).getTitulo().equals(nombre)){
                    UtilProducto.getProductos().get(i).setStock(UtilProducto.getProductos().get(i).getStock()+unidades);
                }
            }
        }
        carrito.clear();
        mostrarProductos();
        UtilRegistro.guardarDatos();
        ((MainMenu) Parent).reloadProductos();

    }//GEN-LAST:event_jButtonVaciarCarritoActionPerformed

    private void jButtonComprarTodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonComprarTodoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonComprarTodoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Carrito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Carrito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Carrito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Carrito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Carrito dialog = new Carrito(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonComprarTodo;
    private javax.swing.JButton jButtonEliminarSeleccion;
    private javax.swing.JButton jButtonVaciarCarrito;
    private javax.swing.JLabel jLabelPrecioTotal;
    private javax.swing.JLabel jLabelPrecioTotalValor;
    private javax.swing.JList<String> jListProductos;
    private javax.swing.JScrollPane jScrollPaneProductos;
    // End of variables declaration//GEN-END:variables
}
