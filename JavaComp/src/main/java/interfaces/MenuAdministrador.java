package interfaces;

import classes.Cliente;
import classes.ClienteEmpresa;
import classes.ClienteParticular;
import classes.Opinion;
import classes.Producto;
import classes.UtilProducto;
import classes.UtilRegistro;
import classes.Venta;
import com.formdev.flatlaf.FlatDarkLaf;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ListIterator;
import javax.swing.JOptionPane;

public class MenuAdministrador extends javax.swing.JFrame {

    //Inializamos el producto actual
    private Producto proc = null;
    private ArrayList<Producto> procaux; //Referencia al ArrayList de personas de la clase Utilproducto
    private ListIterator<Producto> li; //Iterador para recorrer el ArrayList en ambas direcciones
    private Producto objproc; //Referencia a un objeto de tipo persona del ArrayList

    private ArrayList<Cliente> peraux; //Referencia al ArrayList de clientes de la clase Utilregistro
    private ListIterator<Cliente> licliente; //Iterador para recorrer el ArrayList en ambas direcciones
    private Cliente objper; //Referencia a un objeto de tipo persona del ArrayList
    
      private ArrayList<Venta> ventaaux; //Referencia al ArrayList de clientes de la clase Utilregistro
    private ListIterator<Venta> liventa; //Iterador para recorrer el ArrayList en ambas direcciones
    private Venta objventa; //Referencia a un objeto de tipo persona del ArrayList

    /**
     * Creates new form MenuAdministrador
     */
    public MenuAdministrador() {
        initComponents();
        this.setLocationRelativeTo(null); //Esta linea se pone para que la ventana salga centrada.

        //CARGAR LOS DATOS
        UtilProducto.cargarDatos();
        UtilProducto.cargarDatosVentas();
        UtilRegistro.cargarDatos();
        System.out.println(UtilProducto.getProductos());
        ///CONSULTAR 

        //POR DEFECTO SE EMPIEZA CON USUARIOS SELECCIONADO
        Object tipoDeBusqueda;
        tipoDeBusqueda = "Usuarios";
        if (tipoDeBusqueda.equals("Usuarios")) {
            jPanelProductos.setVisible(false);
            jPanelUsuarios.setVisible(true);
            consultarClientes();
            System.out.println("Consultados");

            jPanelVentas.setVisible(false);
        } else if (tipoDeBusqueda.equals("Productos")) {
            jPanelProductos.setVisible(true);
            jPanelUsuarios.setVisible(false);
            jPanelVentas.setVisible(false);
            jPanelConsultaProductos.setVisible(true);
            jPanelNuevoProducto.setVisible(false);
            consultarTodo();
        } else if (tipoDeBusqueda.equals("Ventas")) {
            jPanelProductos.setVisible(false);
            jPanelUsuarios.setVisible(false);
            jPanelVentas.setVisible(true);
            consultarVentas();
        }

        //Para el tema oscuro///
        try {
            javax.swing.UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (Exception e) {
            System.err.println("Failed to initialize LaF");
        }

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                System.out.println(info.getName());
                if ("Flatlaf".equals(info.getName())) {
                    System.out.println("Flatlaf look and feel stablished");
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
    }

    /**
     * Consulta las personas del ArrayList ordenadas para su presentación
     */
    private void consultarTodo() {
        try {
            ///productoPanelAdmin1.consultarTodo();

            //referenciamos al ArrayList de UtilCenso
            procaux = UtilProducto.getProductos();

            //creamos el iterador sobre el ArrayList
            li = procaux.listIterator();

            //si no hay personas...
            if (procaux.size() < 1) {
                JOptionPane.showMessageDialog(this, "No hay productos1.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);

                jButtonModificarProducto.setEnabled(false);
                jButtonEliminarProducto.setEnabled(false);
                jButtonSiguienteProducto.setEnabled(false);
                jButtonAnteriorProducto.setEnabled(false);
                productoPanelAdmin1.setVisible(false);
                return;
            } else {
                jButtonModificarProducto.setEnabled(true);
                jButtonEliminarProducto.setEnabled(true);
                jButtonSiguienteProducto.setEnabled(true);
                jButtonAnteriorProducto.setEnabled(true);
            }

            //presentamos la primera persona
            if (li.hasNext()) {
                objproc = (Producto) li.next();

            }
            if (objproc != null) {
                presenta(objproc);
                UtilProducto.productoActual = objproc;
                productoPanelAdmin1.setOpinionIndex(0);
                productoPanelAdmin1.mostrarOpiniones(productoPanelAdmin1.getOpinionIndex());

            } else {
                JOptionPane.showMessageDialog(this, "No hay productos2.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Mensaje", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error: " + e.toString());
        }

    }//fin consultarTodo

    /**
     * Presenta los datos de una persona en el panel de datos
     */
    private void presenta(Producto proc) {
        productoPanelAdmin1.setjTextFieldNombreProducto(proc.getTitulo());
        productoPanelAdmin1.setjTextFieldDescripcion(proc.getDescripcion());
        productoPanelAdmin1.setjComboBoxCategoria(proc.getCategoria());
        productoPanelAdmin1.setjFormattedTextFieldPrecio(proc.getPrecio());
        productoPanelAdmin1.setjTextFieldFotoProducto(proc.getFotoProducto());
        productoPanelAdmin1.setFotoProducto(proc.getFotoProducto());
        productoPanelAdmin1.setjFormattedTextFieldStock(proc.getStock());
        productoPanelAdmin1.setjTextFieldFechaDeEntrada(proc.getFechaDeEntrada());
        productoPanelAdmin1.setPuntuacion(proc.getOpinionMedia());

        //productoPanelAdmin1.set
    }
    private void consultarVentas() {
        try {
            ///productoPanelAdmin1.consultarTodo();

            //referenciamos al ArrayList de UtilCenso
            ventaaux = UtilProducto.getVentas();

            //creamos el iterador sobre el ArrayList
            liventa = ventaaux.listIterator();

            //si no hay personas...
            if (ventaaux.size() < 1) {
                JOptionPane.showMessageDialog(this, "No hay ventas", "Mensaje", JOptionPane.INFORMATION_MESSAGE);

                jPanelConsultaProductos1.setVisible(false);
                ventaPanelAdmin1.setVisible(false);
                return;
            } else {
                jPanelConsultaProductos1.setVisible(true);
                ventaPanelAdmin1.setVisible(true);
            }

            //presentamos la primera persona
            if (liventa.hasNext()) {
                objventa = (Producto) li.next();

            }
            if (objproc != null) {
                presenta(objproc);
                UtilProducto.productoActual = objproc;
                productoPanelAdmin1.setOpinionIndex(0);
                productoPanelAdmin1.mostrarOpiniones(productoPanelAdmin1.getOpinionIndex());

            } else {
                JOptionPane.showMessageDialog(this, "No hay productos2.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Mensaje", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error: " + e.toString());
        }

    }//fin consultarTodo

    /**
     * Presenta los datos de una persona en el panel de datos
     */
    private void presentaVentas(Venta venta) {
        productoPanelAdmin1.setjTextFieldNombreProducto(proc.getTitulo());
        productoPanelAdmin1.setjTextFieldDescripcion(proc.getDescripcion());
        productoPanelAdmin1.setjComboBoxCategoria(proc.getCategoria());
        productoPanelAdmin1.setjFormattedTextFieldPrecio(proc.getPrecio());
        productoPanelAdmin1.setjTextFieldFotoProducto(proc.getFotoProducto());
        productoPanelAdmin1.setFotoProducto(proc.getFotoProducto());
        productoPanelAdmin1.setjFormattedTextFieldStock(proc.getStock());
        productoPanelAdmin1.setjTextFieldFechaDeEntrada(proc.getFechaDeEntrada());
        productoPanelAdmin1.setPuntuacion(proc.getOpinionMedia());

        //productoPanelAdmin1.set
    }

    private void consultarClientes() {
        try {
            //referenciamos al ArrayList de UtilCenso
            peraux = UtilRegistro.getClientes();
            //creamos el iterador sobre el ArrayList
            licliente = peraux.listIterator();
            //si no hay personas...
            if (peraux.size() < 1) {
                jPanelUsuarios.setVisible(false);
                return;
            } else {
                jPanelUsuarios.setVisible(true);
            }
            //presentamos la primera persona
            if (licliente.hasNext()) {
                objper = (Cliente) licliente.next();
            }
            if (objper != null) {
                presentaClientes(objper);
            } else {
                JOptionPane.showMessageDialog(this, "No hay clientes.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Mensaje", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error: " + e.toString());
        }
    }//fin consultarTodo

    /**
     * Presenta los datos de una persona en el panel de datos
     */
    private void presentaClientes(Cliente cliente) {
        usuarioPanel1.setjTextFieldNombre(cliente.getNombre());
        usuarioPanel1.setjTextFieldCorreoElectronico(cliente.getCorreo());
        usuarioPanel1.setjTextFieldContrasena("**************");
        usuarioPanel1.setjTextFieldCalle(cliente.getDireccion().getCalle());
        usuarioPanel1.setjFormattedTextFieldNumero(cliente.getDireccion().getNumero());
        usuarioPanel1.setjTextFieldExtra(cliente.getDireccion().getExtra());
        usuarioPanel1.setjFormattedTextFieldTelefono(cliente.getTelefono());
        usuarioPanel1.setjTextFieldCiudad(cliente.getDireccion().getCiudad());
        usuarioPanel1.setjFormattedTextFieldCodigoPostal(cliente.getDireccion().getCodigoPostal());

        if (cliente.getClass().getSimpleName().equals("ClienteEmpresa")) {
            ClienteEmpresa clienteempresa = (ClienteEmpresa) cliente;
            usuarioPanel1.setjTextFieldCIF(clienteempresa.getCIF());
            usuarioPanel1.setjTextFieldWeb(clienteempresa.getWeb());
            usuarioPanel1.setjComboBoxTipoUsuario("Empresa");
        } else {
            ClienteParticular clienteparticular = (ClienteParticular) cliente;
            usuarioPanel1.setjTextFieldDNI(clienteparticular.getDNI());
            usuarioPanel1.setjComboBoxTipoUsuario("Particular");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jPanelVentas = new javax.swing.JPanel();
        jPanelConsultaProductos1 = new javax.swing.JPanel();
        jButtonSiguienteVenta = new javax.swing.JButton();
        jButtonAnteriorVenta = new javax.swing.JButton();
        ventaPanelAdmin1 = new interfaces.VentaPanelAdmin();
        jPanelAdministrador = new javax.swing.JPanel();
        jLabelAdministrador = new javax.swing.JLabel();
        jPanelUsuarios = new javax.swing.JPanel();
        jPanelConsultaUsuarios = new javax.swing.JPanel();
        jButtonAnteriorUsuario = new javax.swing.JButton();
        jButtonSiguienteUsuario = new javax.swing.JButton();
        usuarioPanel1 = new interfaces.UsuarioPanel();
        jPanelConsultar = new javax.swing.JPanel();
        jComboBoxUsuariosProductosVentas = new javax.swing.JComboBox<>();
        jButtonConsultar = new javax.swing.JButton();
        jPanelProductos = new javax.swing.JPanel();
        jPanelNuevoProducto = new javax.swing.JPanel();
        jButtonBorrar = new javax.swing.JButton();
        jButtonConsultarExistentes = new javax.swing.JButton();
        jButtonAnadirProductos = new javax.swing.JButton();
        jPanelConsultaProductos = new javax.swing.JPanel();
        jButtonAnteriorProducto = new javax.swing.JButton();
        jButtonEliminarProducto = new javax.swing.JButton();
        jButtonModificarProducto = new javax.swing.JButton();
        jButtonSiguienteProducto = new javax.swing.JButton();
        jButtonNuevoProducto = new javax.swing.JButton();
        productoPanelAdmin1 = new interfaces.ProductoPanelAdmin();

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonSiguienteVenta.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonSiguienteVenta.setText("-->");
        jButtonSiguienteVenta.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButtonSiguienteVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSiguienteVentaActionPerformed(evt);
            }
        });

        jButtonAnteriorVenta.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonAnteriorVenta.setText("<--");
        jButtonAnteriorVenta.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButtonAnteriorVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAnteriorVentaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelConsultaProductos1Layout = new javax.swing.GroupLayout(jPanelConsultaProductos1);
        jPanelConsultaProductos1.setLayout(jPanelConsultaProductos1Layout);
        jPanelConsultaProductos1Layout.setHorizontalGroup(
            jPanelConsultaProductos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 653, Short.MAX_VALUE)
            .addGroup(jPanelConsultaProductos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelConsultaProductos1Layout.createSequentialGroup()
                    .addGap(218, 218, 218)
                    .addComponent(jButtonAnteriorVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(113, 113, 113)
                    .addComponent(jButtonSiguienteVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(218, Short.MAX_VALUE)))
        );
        jPanelConsultaProductos1Layout.setVerticalGroup(
            jPanelConsultaProductos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
            .addGroup(jPanelConsultaProductos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelConsultaProductos1Layout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addGroup(jPanelConsultaProductos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonAnteriorVenta)
                        .addComponent(jButtonSiguienteVenta))
                    .addContainerGap(17, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanelVentasLayout = new javax.swing.GroupLayout(jPanelVentas);
        jPanelVentas.setLayout(jPanelVentasLayout);
        jPanelVentasLayout.setHorizontalGroup(
            jPanelVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelVentasLayout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(jPanelVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ventaPanelAdmin1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelConsultaProductos1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(87, Short.MAX_VALUE))
        );
        jPanelVentasLayout.setVerticalGroup(
            jPanelVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelVentasLayout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jPanelConsultaProductos1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ventaPanelAdmin1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(79, Short.MAX_VALUE))
        );

        getContentPane().add(jPanelVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, -1, -1));

        jPanelAdministrador.setBackground(new java.awt.Color(51, 51, 51));

        jLabelAdministrador.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabelAdministrador.setForeground(new java.awt.Color(204, 204, 204));
        jLabelAdministrador.setText("ADMINISTRADOR");

        javax.swing.GroupLayout jPanelAdministradorLayout = new javax.swing.GroupLayout(jPanelAdministrador);
        jPanelAdministrador.setLayout(jPanelAdministradorLayout);
        jPanelAdministradorLayout.setHorizontalGroup(
            jPanelAdministradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelAdministradorLayout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(jLabelAdministrador)
                .addGap(16, 16, 16))
        );
        jPanelAdministradorLayout.setVerticalGroup(
            jPanelAdministradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelAdministradorLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelAdministrador, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jPanelAdministrador, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jButtonAnteriorUsuario.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonAnteriorUsuario.setText("<--");
        jButtonAnteriorUsuario.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButtonAnteriorUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAnteriorUsuarioActionPerformed(evt);
            }
        });

        jButtonSiguienteUsuario.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonSiguienteUsuario.setText("-->");
        jButtonSiguienteUsuario.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButtonSiguienteUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSiguienteUsuarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelConsultaUsuariosLayout = new javax.swing.GroupLayout(jPanelConsultaUsuarios);
        jPanelConsultaUsuarios.setLayout(jPanelConsultaUsuariosLayout);
        jPanelConsultaUsuariosLayout.setHorizontalGroup(
            jPanelConsultaUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelConsultaUsuariosLayout.createSequentialGroup()
                .addContainerGap(196, Short.MAX_VALUE)
                .addComponent(jButtonAnteriorUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(154, 154, 154)
                .addComponent(jButtonSiguienteUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(199, 199, 199))
        );
        jPanelConsultaUsuariosLayout.setVerticalGroup(
            jPanelConsultaUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelConsultaUsuariosLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanelConsultaUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAnteriorUsuario)
                    .addComponent(jButtonSiguienteUsuario))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelUsuariosLayout = new javax.swing.GroupLayout(jPanelUsuarios);
        jPanelUsuarios.setLayout(jPanelUsuariosLayout);
        jPanelUsuariosLayout.setHorizontalGroup(
            jPanelUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelUsuariosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanelConsultaUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72))
            .addGroup(jPanelUsuariosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(usuarioPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 757, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(53, Short.MAX_VALUE))
        );
        jPanelUsuariosLayout.setVerticalGroup(
            jPanelUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelUsuariosLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jPanelConsultaUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(usuarioPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(251, Short.MAX_VALUE))
        );

        getContentPane().add(jPanelUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, -1, -1));

        jPanelConsultar.setBackground(new java.awt.Color(51, 51, 51));

        jComboBoxUsuariosProductosVentas.setBackground(new java.awt.Color(204, 204, 204));
        jComboBoxUsuariosProductosVentas.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jComboBoxUsuariosProductosVentas.setForeground(new java.awt.Color(51, 51, 51));
        jComboBoxUsuariosProductosVentas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Usuarios", "Productos", "Ventas" }));
        jComboBoxUsuariosProductosVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxUsuariosProductosVentasActionPerformed(evt);
            }
        });

        jButtonConsultar.setText("Consultar");
        jButtonConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConsultarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelConsultarLayout = new javax.swing.GroupLayout(jPanelConsultar);
        jPanelConsultar.setLayout(jPanelConsultarLayout);
        jPanelConsultarLayout.setHorizontalGroup(
            jPanelConsultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelConsultarLayout.createSequentialGroup()
                .addGap(193, 193, 193)
                .addComponent(jComboBoxUsuariosProductosVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 157, Short.MAX_VALUE)
                .addComponent(jButtonConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(99, 99, 99))
        );
        jPanelConsultarLayout.setVerticalGroup(
            jPanelConsultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelConsultarLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanelConsultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonConsultar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBoxUsuariosProductosVentas))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanelConsultar, new org.netbeans.lib.awtextra.AbsoluteConstraints(248, 0, -1, 54));

        jButtonBorrar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonBorrar.setText("Borrar");
        jButtonBorrar.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButtonBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBorrarActionPerformed(evt);
            }
        });

        jButtonConsultarExistentes.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonConsultarExistentes.setText("Consultar existentes");
        jButtonConsultarExistentes.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButtonConsultarExistentes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConsultarExistentesActionPerformed(evt);
            }
        });

        jButtonAnadirProductos.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonAnadirProductos.setText("Añadir producto");
        jButtonAnadirProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAnadirProductosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelNuevoProductoLayout = new javax.swing.GroupLayout(jPanelNuevoProducto);
        jPanelNuevoProducto.setLayout(jPanelNuevoProductoLayout);
        jPanelNuevoProductoLayout.setHorizontalGroup(
            jPanelNuevoProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNuevoProductoLayout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addComponent(jButtonConsultarExistentes, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonAnadirProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56))
        );
        jPanelNuevoProductoLayout.setVerticalGroup(
            jPanelNuevoProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNuevoProductoLayout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(jPanelNuevoProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonBorrar)
                    .addComponent(jButtonAnadirProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonConsultarExistentes)))
        );

        jButtonAnteriorProducto.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonAnteriorProducto.setText("<--");
        jButtonAnteriorProducto.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButtonAnteriorProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAnteriorProductoActionPerformed(evt);
            }
        });

        jButtonEliminarProducto.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonEliminarProducto.setText("Eliminar");
        jButtonEliminarProducto.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButtonEliminarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarProductoActionPerformed(evt);
            }
        });

        jButtonModificarProducto.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonModificarProducto.setText("Modificar");
        jButtonModificarProducto.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButtonModificarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificarProductoActionPerformed(evt);
            }
        });

        jButtonSiguienteProducto.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonSiguienteProducto.setText("-->");
        jButtonSiguienteProducto.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButtonSiguienteProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSiguienteProductoActionPerformed(evt);
            }
        });

        jButtonNuevoProducto.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonNuevoProducto.setText("Nuevo producto");
        jButtonNuevoProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNuevoProductoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelConsultaProductosLayout = new javax.swing.GroupLayout(jPanelConsultaProductos);
        jPanelConsultaProductos.setLayout(jPanelConsultaProductosLayout);
        jPanelConsultaProductosLayout.setHorizontalGroup(
            jPanelConsultaProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelConsultaProductosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelConsultaProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelConsultaProductosLayout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(jButtonSiguienteProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(jButtonModificarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelConsultaProductosLayout.createSequentialGroup()
                        .addComponent(jButtonAnteriorProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(230, 230, 230)
                        .addComponent(jButtonEliminarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonNuevoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56))
        );
        jPanelConsultaProductosLayout.setVerticalGroup(
            jPanelConsultaProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelConsultaProductosLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanelConsultaProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelConsultaProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonSiguienteProducto)
                        .addComponent(jButtonModificarProducto))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelConsultaProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonAnteriorProducto)
                        .addComponent(jButtonEliminarProducto)
                        .addComponent(jButtonNuevoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        productoPanelAdmin1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanelProductosLayout = new javax.swing.GroupLayout(jPanelProductos);
        jPanelProductos.setLayout(jPanelProductosLayout);
        jPanelProductosLayout.setHorizontalGroup(
            jPanelProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelProductosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanelConsultaProductos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanelNuevoProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(productoPanelAdmin1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(83, Short.MAX_VALUE))
        );
        jPanelProductosLayout.setVerticalGroup(
            jPanelProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelProductosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanelConsultaProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelNuevoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(productoPanelAdmin1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jPanelProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxUsuariosProductosVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxUsuariosProductosVentasActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jComboBoxUsuariosProductosVentasActionPerformed

    private void jButtonConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConsultarActionPerformed
        // TODO add your handling code here:

        Object tipoDeBusqueda;
        tipoDeBusqueda = jComboBoxUsuariosProductosVentas.getSelectedItem();
        if (tipoDeBusqueda.equals("Usuarios")) {
            jPanelProductos.setVisible(false);
            jPanelUsuarios.setVisible(true);
            consultarClientes();
            //jPanelVentas.setVisible(false);
        } else if (tipoDeBusqueda.equals("Productos")) {
            jPanelProductos.setVisible(true);
            jPanelUsuarios.setVisible(false);
            //jPanelVentas.setVisible(false);
            jPanelConsultaProductos.setVisible(true);
            jPanelNuevoProducto.setVisible(false);
            consultarTodo();
        } else if (tipoDeBusqueda.equals("Ventas")) {
            jPanelProductos.setVisible(false);
            jPanelUsuarios.setVisible(false);
            //jPanelVentas.setVisible(true);
        }
    }//GEN-LAST:event_jButtonConsultarActionPerformed

    private void jButtonNuevoProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNuevoProductoActionPerformed
        // TODO add your handling code here:
        jPanelConsultaProductos.setVisible(false);
        jPanelNuevoProducto.setVisible(true);
        productoPanelAdmin1.setVisible(true);
        productoPanelAdmin1.setNuevoProducto();

    }//GEN-LAST:event_jButtonNuevoProductoActionPerformed

    private void jButtonSiguienteProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSiguienteProductoActionPerformed
        // TODO add your handling code here:
        //Comprobamos el rango del ArrayList...
        if (li.hasNext()) {
            objproc = li.next();
            if (objproc != null) {
                presenta(objproc);
                UtilProducto.productoActual = objproc;
                productoPanelAdmin1.setOpinionIndex(0);
                productoPanelAdmin1.mostrarOpiniones(productoPanelAdmin1.getOpinionIndex());

                System.out.println(UtilProducto.productoActual);

            } else {
                System.out.println("Wow");
                JOptionPane.showMessageDialog(this, "No hay más productos.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "No hay más productos.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        }

    }//GEN-LAST:event_jButtonSiguienteProductoActionPerformed
    /**
     * Modifica el producto seleccionado
     *
     * @param evt
     */
    private void jButtonModificarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificarProductoActionPerformed
        // TODO add your handling code here:
        //MODIFICA EL PRODUCTO ACTUAL
        try {
            String nombreProducto = productoPanelAdmin1.getjTextFieldNombreProducto();
            String descripcion = productoPanelAdmin1.getjTextFieldDescripcion();
            String categoria = productoPanelAdmin1.getjComboBoxCategoria();
            double precio = productoPanelAdmin1.getjFormattedTextFieldPrecio();
            String fotoProducto = productoPanelAdmin1.getjTextFieldFotoProducto();
            int stock = productoPanelAdmin1.getjFormattedTextFieldStock();
            //Establecemos el dia actual del alta como fecha entrada
            LocalDate fechaActual = LocalDate.now();
            LocalDate fechaDeEntrada = fechaActual;
            ArrayList<Opinion> opiniones = UtilProducto.getOpiniones();
            //ArrayList<Opinion> opiniones = null;

            //lo insertamos en el array
            if (UtilProducto.modificaProducto(objproc, nombreProducto, descripcion, categoria, precio, fotoProducto, stock, fechaDeEntrada, opiniones)) {
                JOptionPane.showMessageDialog(this, "El producto ha sido modificado correctamente", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Excepcion al modificar1. Inicia sesión.", "Mensaje", JOptionPane.ERROR_MESSAGE);
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Excepción al modificar2.", "Mensaje", JOptionPane.ERROR_MESSAGE);
        }
        UtilProducto.guardarDatos();

    }//GEN-LAST:event_jButtonModificarProductoActionPerformed
    /**
     * Se elimina el producto seleccionado de los datos
     *
     * @param evt
     */
    private void jButtonEliminarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarProductoActionPerformed
        // TODO add your handling code here:
        try {

            //lo insertamos en el array
            if (UtilProducto.bajaProducto(objproc)) {
                JOptionPane.showMessageDialog(this, "El producto ha sido eliminado correctamente", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Excepcion al eliminar. Inicia sesión.", "Mensaje", JOptionPane.ERROR_MESSAGE);
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Excepción al eliminar2.", "Mensaje", JOptionPane.ERROR_MESSAGE);
        }
        UtilProducto.guardarDatos();
        consultarTodo();

    }//GEN-LAST:event_jButtonEliminarProductoActionPerformed

    private void jButtonAnteriorProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAnteriorProductoActionPerformed
        // TODO add your handling code here:
        //Comprobamos el rango del ArrayList...
        if (li.hasPrevious()) {
            objproc = li.previous();
            if (objproc != null) {
                presenta(objproc);
                UtilProducto.productoActual = objproc;
                productoPanelAdmin1.setOpinionIndex(0);
                productoPanelAdmin1.mostrarOpiniones(productoPanelAdmin1.getOpinionIndex());

                System.out.println(UtilProducto.productoActual);
            } else {
                JOptionPane.showMessageDialog(this, "No hay más productos.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "No hay más productos.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        }

    }//GEN-LAST:event_jButtonAnteriorProductoActionPerformed

    private void jButtonConsultarExistentesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConsultarExistentesActionPerformed
        // TODO add your handling code here:
        jPanelConsultaProductos.setVisible(true);
        jPanelNuevoProducto.setVisible(false);
        productoPanelAdmin1.setModificarConsultarProducto();
        consultarTodo();
    }//GEN-LAST:event_jButtonConsultarExistentesActionPerformed

    private void jButtonBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBorrarActionPerformed
        // TODO add your handling code here:
        productoPanelAdmin1.clearAll();
    }//GEN-LAST:event_jButtonBorrarActionPerformed

    private void jButtonAnadirProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAnadirProductosActionPerformed
        // TODO add your handling code here:
        try {
            String nombreProducto = productoPanelAdmin1.getjTextFieldNombreProducto();
            String descripcion = productoPanelAdmin1.getjTextFieldDescripcion();
            String categoria = productoPanelAdmin1.getjComboBoxCategoria();
            double precio = productoPanelAdmin1.getjFormattedTextFieldPrecio();
            String fotoProducto = productoPanelAdmin1.getjTextFieldFotoProducto();
            int stock = productoPanelAdmin1.getjFormattedTextFieldStock();
            //Establecemos el dia actual del alta como fecha entrada
            LocalDate fechaActual = LocalDate.now();
            LocalDate fechaDeEntrada = fechaActual;
            ArrayList<Opinion> opiniones = new ArrayList<Opinion>();
            //ArrayList<Opinion> opiniones = null;

            proc = new Producto(nombreProducto, descripcion, categoria, precio, fotoProducto, stock, fechaDeEntrada, opiniones);
            //lo insertamos en el array
            if (UtilProducto.altaProducto(proc)) {
                JOptionPane.showMessageDialog(this, "El producto ha sido dado de alta correctamente", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                productoPanelAdmin1.clearAll();
            } else {
                JOptionPane.showMessageDialog(this, "El producto ya existe. Inicia sesión.", "Mensaje", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Excepción al registrarse.", "Mensaje", JOptionPane.ERROR_MESSAGE);
        }

        UtilProducto.guardarDatos();

    }//GEN-LAST:event_jButtonAnadirProductosActionPerformed

    private void jButtonSiguienteUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSiguienteUsuarioActionPerformed
        // TODO add your handling code here:
        //Comprobamos el rango del ArrayList...
        if (licliente.hasNext()) {
            objper = licliente.next();
            if (objper != null) {
                presentaClientes(objper);
            } else {
                JOptionPane.showMessageDialog(this, "No hay más clientes", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            }
        }

    }//GEN-LAST:event_jButtonSiguienteUsuarioActionPerformed

    private void jButtonAnteriorUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAnteriorUsuarioActionPerformed
        // TODO add your handling code here:

        //Comprobamos el rango del ArrayList...
        if (licliente.hasPrevious()) {
            objper = licliente.previous();
            if (objper != null) {
                presentaClientes(objper);
            } else {
                JOptionPane.showMessageDialog(this, "No hay más clientes.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_jButtonAnteriorUsuarioActionPerformed

    private void jButtonAnteriorVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAnteriorVentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonAnteriorVentaActionPerformed

    private void jButtonSiguienteVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSiguienteVentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonSiguienteVentaActionPerformed

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
            javax.swing.UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (Exception e) {
            System.err.println("Failed to initialize LaF");
        }

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                System.out.println(info.getName());
                if ("Flatlaf".equals(info.getName())) {
                    System.out.println("Flatlaf look and feel stablished");
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuAdministrador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAnadirProductos;
    private javax.swing.JButton jButtonAnteriorProducto;
    private javax.swing.JButton jButtonAnteriorUsuario;
    private javax.swing.JButton jButtonAnteriorVenta;
    private javax.swing.JButton jButtonBorrar;
    private javax.swing.JButton jButtonConsultar;
    private javax.swing.JButton jButtonConsultarExistentes;
    private javax.swing.JButton jButtonEliminarProducto;
    private javax.swing.JButton jButtonModificarProducto;
    private javax.swing.JButton jButtonNuevoProducto;
    private javax.swing.JButton jButtonSiguienteProducto;
    private javax.swing.JButton jButtonSiguienteUsuario;
    private javax.swing.JButton jButtonSiguienteVenta;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JComboBox<String> jComboBoxUsuariosProductosVentas;
    private javax.swing.JLabel jLabelAdministrador;
    private javax.swing.JPanel jPanelAdministrador;
    private javax.swing.JPanel jPanelConsultaProductos;
    private javax.swing.JPanel jPanelConsultaProductos1;
    private javax.swing.JPanel jPanelConsultaUsuarios;
    private javax.swing.JPanel jPanelConsultar;
    private javax.swing.JPanel jPanelNuevoProducto;
    private javax.swing.JPanel jPanelProductos;
    private javax.swing.JPanel jPanelUsuarios;
    private javax.swing.JPanel jPanelVentas;
    private interfaces.ProductoPanelAdmin productoPanelAdmin1;
    private interfaces.UsuarioPanel usuarioPanel1;
    private interfaces.VentaPanelAdmin ventaPanelAdmin1;
    // End of variables declaration//GEN-END:variables
}
