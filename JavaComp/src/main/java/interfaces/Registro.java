
package interfaces;

import classes.Cliente;
import classes.ClienteEmpresa;
import classes.ClienteParticular;
import classes.Direccion;
import classes.Producto;
import classes.UtilRegistro;
import com.formdev.flatlaf.FlatDarkLaf;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class Registro extends javax.swing.JDialog {
    
    //Inializamos el cliente
    private Cliente cli = null;
    private Direccion dir = null;
    
    /**
     * Creates new form Registro
     */
    public Registro(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null); //Esta linea se pone para que la ventana salga centrada.
        
        
        
        /**
         * Asegura que todas las cajas empiecen con la visibilidad esperada
         */
        Object tipoDeUsuario;
        tipoDeUsuario = jComboBoxEmpresaParticular.getSelectedItem();
        if(tipoDeUsuario=="Empresa"){
            jLabelDNI.setVisible(false);
            jTextFieldDNI.setVisible(false);
            jLabelCIF.setVisible(true);
            jTextFieldCIF.setVisible(true);
            jLabelWeb.setVisible(true);
            jTextFieldWeb.setVisible(true);
        }
        else if(tipoDeUsuario == "Particular"){
            jLabelDNI.setVisible(true);
            jTextFieldDNI.setVisible(true);
            jLabelCIF.setVisible(false);
            jTextFieldCIF.setVisible(false);
            jLabelWeb.setVisible(false);
            jTextFieldWeb.setVisible(false);
        }
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
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelRegistro = new javax.swing.JLabel();
        jLabelDNI = new javax.swing.JLabel();
        jTextFieldCiudad = new javax.swing.JTextField();
        jLabelNombre = new javax.swing.JLabel();
        jLabelCorreoElectronico = new javax.swing.JLabel();
        jLabelContrasena = new javax.swing.JLabel();
        jLabelCalle = new javax.swing.JLabel();
        jLabelTelefono = new javax.swing.JLabel();
        jTextFieldDNI = new javax.swing.JTextField();
        jTextFieldNombre = new javax.swing.JTextField();
        jTextFieldCorreoElectronico = new javax.swing.JTextField();
        jTextFieldContrasena = new javax.swing.JTextField();
        jTextFieldCalle = new javax.swing.JTextField();
        jToggleButtonGuardar = new javax.swing.JToggleButton();
        jLabelTieneCuentaPregunta = new javax.swing.JLabel();
        jButtonLogIn = new javax.swing.JButton();
        jComboBoxEmpresaParticular = new javax.swing.JComboBox<>();
        jLabelTipoDeUsuario = new javax.swing.JLabel();
        jLabelWeb = new javax.swing.JLabel();
        jTextFieldWeb = new javax.swing.JTextField();
        jLabelCIF = new javax.swing.JLabel();
        jTextFieldCIF = new javax.swing.JTextField();
        jFormattedTextFieldTelefono = new javax.swing.JFormattedTextField();
        jLabelCiudad = new javax.swing.JLabel();
        jLabelCodigoPostal = new javax.swing.JLabel();
        jFormattedTextFieldCodigoPostal = new javax.swing.JFormattedTextField();
        jLabelNumero = new javax.swing.JLabel();
        jTextFieldExtra = new javax.swing.JTextField();
        jLabelExtra = new javax.swing.JLabel();
        jFormattedTextFieldNumero = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabelRegistro.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabelRegistro.setForeground(new java.awt.Color(51, 153, 255));
        jLabelRegistro.setText("REGISTRO");

        jLabelDNI.setText("DNI:");

        jLabelNombre.setText("Nombre:");

        jLabelCorreoElectronico.setText("Correo electrónico:");

        jLabelContrasena.setText("Contraseña:");

        jLabelCalle.setText("Calle:");
        jLabelCalle.setToolTipText("Introducir tipo de vía, nombre de la vía, número, puerta, letra... ");

        jLabelTelefono.setText("Teléfono:");

        jTextFieldDNI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldDNIActionPerformed(evt);
            }
        });

        jTextFieldCorreoElectronico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCorreoElectronicoActionPerformed(evt);
            }
        });

        jTextFieldContrasena.setToolTipText("Por seguridad usar 8 caracteres como mínimo con letras, numeros y caracteres especiales.");

        jTextFieldCalle.setToolTipText("Introducir tipo de vía, nombre de la vía, número, puerta, letra...\n");

        jToggleButtonGuardar.setText("GUARDAR");
        jToggleButtonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButtonGuardarActionPerformed(evt);
            }
        });

        jLabelTieneCuentaPregunta.setForeground(new java.awt.Color(50, 150, 180));
        jLabelTieneCuentaPregunta.setText("¿Ya tiene una cuenta?");

        jButtonLogIn.setText("Log In");
        jButtonLogIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLogInActionPerformed(evt);
            }
        });

        jComboBoxEmpresaParticular.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Empresa", "Particular" }));
        jComboBoxEmpresaParticular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxEmpresaParticularActionPerformed(evt);
            }
        });

        jLabelTipoDeUsuario.setText("Tipo de usuario");

        jLabelWeb.setText("Web:");

        jLabelCIF.setText("CIF:");

        jTextFieldCIF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCIFActionPerformed(evt);
            }
        });

        jFormattedTextFieldTelefono.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        jFormattedTextFieldTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextFieldTelefonoActionPerformed(evt);
            }
        });

        jLabelCiudad.setText("Ciudad:");

        jLabelCodigoPostal.setText("Código Postal:");

        jFormattedTextFieldCodigoPostal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

        jLabelNumero.setText("Número:");

        jLabelExtra.setText("Letra, piso, puerta...");

        jFormattedTextFieldNumero.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        jFormattedTextFieldNumero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextFieldNumeroActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logoMini.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addComponent(jLabelRegistro))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(jToggleButtonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelCorreoElectronico)
                            .addComponent(jLabelContrasena)
                            .addComponent(jLabelCalle)
                            .addComponent(jLabelTelefono)
                            .addComponent(jLabelNombre)
                            .addComponent(jLabelCodigoPostal)
                            .addComponent(jLabelCiudad)
                            .addComponent(jLabelWeb)
                            .addComponent(jLabelTieneCuentaPregunta)
                            .addComponent(jLabelNumero)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelCIF)
                                    .addComponent(jLabelTipoDeUsuario)
                                    .addComponent(jLabelDNI)))
                            .addComponent(jLabelExtra))
                        .addGap(95, 95, 95)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldDNI, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                            .addComponent(jButtonLogIn, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                            .addComponent(jTextFieldWeb, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                            .addComponent(jComboBoxEmpresaParticular, 0, 130, Short.MAX_VALUE)
                            .addComponent(jTextFieldCIF)
                            .addComponent(jTextFieldNombre)
                            .addComponent(jTextFieldCorreoElectronico)
                            .addComponent(jTextFieldContrasena)
                            .addComponent(jTextFieldCalle)
                            .addComponent(jFormattedTextFieldTelefono)
                            .addComponent(jTextFieldCiudad)
                            .addComponent(jFormattedTextFieldCodigoPostal)
                            .addComponent(jTextFieldExtra)
                            .addComponent(jFormattedTextFieldNumero))))
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelRegistro)
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTipoDeUsuario)
                    .addComponent(jComboBoxEmpresaParticular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCIF, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldCIF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDNI)
                    .addComponent(jTextFieldDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNombre)
                    .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCorreoElectronico)
                    .addComponent(jTextFieldCorreoElectronico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelContrasena)
                    .addComponent(jTextFieldContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTelefono)
                    .addComponent(jFormattedTextFieldTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCalle)
                    .addComponent(jTextFieldCalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNumero)
                    .addComponent(jFormattedTextFieldNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelExtra)
                    .addComponent(jTextFieldExtra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCiudad)
                    .addComponent(jTextFieldCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCodigoPostal)
                    .addComponent(jFormattedTextFieldCodigoPostal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelWeb)
                    .addComponent(jTextFieldWeb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jToggleButtonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTieneCuentaPregunta, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonLogIn))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jToggleButtonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButtonGuardarActionPerformed
        // TODO add your handling code here:
        /**
         * 
         * Se comprueba que el numero de telefono sean numeros
         */
        boolean numInvalido = false;
        try{
            for (int i = 0; i < jFormattedTextFieldTelefono.getText().length(); i++) {
                int telefonoInt = Integer.parseInt(jFormattedTextFieldTelefono.getText());
        }
        } catch(NumberFormatException e){
            numInvalido = true;
        }
        Object tipoDeUsuario;
        tipoDeUsuario = jComboBoxEmpresaParticular.getSelectedItem();
        /**
         * Se comprueba que todos los datos se introduzcan y sean validos
         */
        if( 
                
                (tipoDeUsuario=="Empresa" && (jTextFieldCIF.getText().isBlank()||jTextFieldWeb.getText().isBlank()))  
                || (tipoDeUsuario=="Particular" && (jTextFieldDNI.getText().isBlank()))){
            JOptionPane.showMessageDialog(this, "Rellena todos los campos", "Error", JOptionPane.WARNING_MESSAGE);
        }
        else
            //Se verifica que todos los valores esten rellenos
        if(    
                 jTextFieldNombre.getText().isBlank()||
                 jTextFieldCorreoElectronico.getText().isBlank() ||
                 jTextFieldContrasena.getText().isBlank()|| 
                 jTextFieldCalle.getText().isBlank()||
                 jFormattedTextFieldTelefono.getText().isBlank()||
                 jFormattedTextFieldCodigoPostal.getText().isBlank()||
                 jTextFieldCiudad.getText().isBlank()||
                 jFormattedTextFieldNumero.getText().isBlank()){
        
                 JOptionPane.showMessageDialog(this, "Rellene todos los campos.", "Error", JOptionPane.WARNING_MESSAGE);
          }
        //Se verifica que no haya errores a la hora de introducir los datos en el registro
        else
        if(tipoDeUsuario=="Particular" && jTextFieldDNI.getText().contains(" ")){  //Se comprueba que el DNI no contiene espacios
                JOptionPane.showMessageDialog(this, "El DNI no puede tener espacios.", "Error", JOptionPane.WARNING_MESSAGE);
        }
        else
        if(tipoDeUsuario=="Particular" && jTextFieldDNI.getText().length()<9){  //Se comprueba que el DNI contenga 9 caracteres
                JOptionPane.showMessageDialog(this, "El DNI debe contener 8 numeros y una letra.", "Error", JOptionPane.WARNING_MESSAGE);
        }
        else
        if(tipoDeUsuario=="Empresa" &&jTextFieldCIF.getText().contains(" ")){  //Se comprueba que el CIF no contenga espacios
                JOptionPane.showMessageDialog(this, "El CIF no puede tener espacios.", "Error", JOptionPane.WARNING_MESSAGE);
        }
        else
        if(tipoDeUsuario=="Empresa" &&jTextFieldCIF.getText().length()<9){  ////Se comprueba que el CIF contenga 9 cifras.
                JOptionPane.showMessageDialog(this, "El CIF debe contener una letra y 8 cifras.", "Error", JOptionPane.WARNING_MESSAGE);
        }
        else
        if(tipoDeUsuario=="Empresa" &&jTextFieldWeb.getText().contains(" ")){  //Luego se comprueba que la web no contenga espacios.
                JOptionPane.showMessageDialog(this, "La web no puede tener espacios.", "Error", JOptionPane.WARNING_MESSAGE);
        }
        else
        if(jTextFieldCorreoElectronico.getText().contains(" ")){  ////Se comprueba que el correo electrónico no contenga espacios.
                JOptionPane.showMessageDialog(this, "El correo no puede tener espacios", "Error", JOptionPane.WARNING_MESSAGE);
        }
        else
        if(!jTextFieldCorreoElectronico.getText().contains("@")||!jTextFieldCorreoElectronico.getText().contains(".")){  ////Se comprueba que el correo electrónico sea adecuado es decir que contenga una @ y un . como mínimo.
                JOptionPane.showMessageDialog(this, "Introduzca un correo electrónico correcto.", "Error", JOptionPane.WARNING_MESSAGE);
        }
        else
        if(jTextFieldContrasena.getText().contains(" ")){  ////Se comprueba que la contraseña no tenga espacios.
                JOptionPane.showMessageDialog(this, "La contraseña no puede tener espacios", "Error", JOptionPane.WARNING_MESSAGE);
        }
        else
            if(jTextFieldContrasena.getText().length()<8){  ////Se comprueba que la contraseña no tenga espacios.
                JOptionPane.showMessageDialog(this, "La contraseña no es segura, introduzca 8 caracteres como mínimo. Recomendable que use letras, numero y caracteres", "Error", JOptionPane.WARNING_MESSAGE);
        }
        else
        if(jFormattedTextFieldTelefono.getText().contains(" ")){  //Se comprueba que el telefono no contenga espacios
                JOptionPane.showMessageDialog(this, "El teléfono no puede tener espacios.", "Error", JOptionPane.WARNING_MESSAGE);
        }
        else
        if(numInvalido || jFormattedTextFieldTelefono.getText().length()!=9){//Se comprueba que el telefono contiene como minimo 9 digitos.
            JOptionPane.showMessageDialog(this, "El teléfono debe ser valido. Nueve numeros enteros seguidos.", "Error", JOptionPane.WARNING_MESSAGE);
        }
        else
        if(jFormattedTextFieldCodigoPostal.getText().contains(" ")){//Se comprueba que el codigo postal no contenga espacios  
                JOptionPane.showMessageDialog(this, "El código postal no puede tener espacios.", "Error", JOptionPane.WARNING_MESSAGE);
        }
        else
        if(jFormattedTextFieldCodigoPostal.getText().length()!=5||Integer.parseInt(jFormattedTextFieldCodigoPostal.getText())<=0){//Se comprueba que el codigo postal sea correcto, positivo y que tenga 4 cifras.  
                JOptionPane.showMessageDialog(this, "Introduzca un codigo postal correcto.", "Error", JOptionPane.WARNING_MESSAGE);
        }
        else
        if(jFormattedTextFieldNumero.getText().contains(" ")){//Se comprueba que el numero de la calle no contenga espacios  
                JOptionPane.showMessageDialog(this, "El número de domicilio no puede tener espacios.", "Error", JOptionPane.WARNING_MESSAGE);
        }
        else
        if(Integer.parseInt(jFormattedTextFieldNumero.getText())<=0){//Se comprueba que el numero de la calle no sea negativo  
                JOptionPane.showMessageDialog(this, "El numero no puede ser negativo", "Error", JOptionPane.WARNING_MESSAGE);
        }
        else{
        /**
         * Se atribuyen variables a la informacion introducida por el usuario
         */
        try {
            String calle = jTextFieldCalle.getText();
            String ciudad = jTextFieldCiudad.getText();
            int codigoPostal =  Integer.parseInt(jFormattedTextFieldCodigoPostal.getText());
            int numero= Integer.parseInt(jFormattedTextFieldNumero.getText());
            String extra = jTextFieldExtra.getText();
            String nombre = jTextFieldNombre.getText();
            String correo = jTextFieldCorreoElectronico.getText();
            String clave = jTextFieldContrasena.getText();
            int telefono = Integer.parseInt(jFormattedTextFieldTelefono.getText());
            
            dir = new Direccion(calle,numero,extra,codigoPostal,ciudad);
            ArrayList<Producto> carrito = new ArrayList<Producto>();
            if (tipoDeUsuario.equals("Empresa")) {
                String cif = jTextFieldCIF.getText();
                String web = jTextFieldWeb.getText();
                cli = new ClienteEmpresa(nombre , correo , clave , dir , null , telefono , cif , web,carrito);
        } else {
                String dni = jTextFieldDNI.getText();
            cli = new ClienteParticular(nombre , correo , clave , dir , null , telefono , dni,carrito);
        }           
        //lo insertamos en el array
        if (UtilRegistro.registroCliente(cli)) {
            JOptionPane.showMessageDialog(this, "Ha sido registrado correctamente", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            super.setVisible(true);
            this.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(this, "Ya estás registrado. Inicia sesión.", "Mensaje", JOptionPane.ERROR_MESSAGE);
        }
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Excepción al registrarse.", "Mensaje", JOptionPane.ERROR_MESSAGE);        
        }
        
        UtilRegistro.guardarDatos();
        }
    }//GEN-LAST:event_jToggleButtonGuardarActionPerformed

    private void jButtonLogInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLogInActionPerformed
        // TODO add your handling code here:
        super.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButtonLogInActionPerformed

    private void jTextFieldDNIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDNIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldDNIActionPerformed

    private void jComboBoxEmpresaParticularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxEmpresaParticularActionPerformed
        // TODO add your handling code here:
        /**
         * Asegura que dependiendo del tipo se activen las debidas cajas.
         */
        Object tipoDeUsuario;
        tipoDeUsuario = jComboBoxEmpresaParticular.getSelectedItem();
        if(tipoDeUsuario=="Empresa"){
            jLabelDNI.setVisible(false);
            jTextFieldDNI.setVisible(false);
            jLabelCIF.setVisible(true);
            jTextFieldCIF.setVisible(true);
            jLabelWeb.setVisible(true);
            jTextFieldWeb.setVisible(true);
        }
        else if(tipoDeUsuario == "Particular"){
            jLabelDNI.setVisible(true);
            jTextFieldDNI.setVisible(true);
            jLabelCIF.setVisible(false);
            jTextFieldCIF.setVisible(false);
            jLabelWeb.setVisible(false);
            jTextFieldWeb.setVisible(false); 
        }
    }//GEN-LAST:event_jComboBoxEmpresaParticularActionPerformed

    private void jTextFieldCIFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCIFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCIFActionPerformed

    private void jTextFieldCorreoElectronicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCorreoElectronicoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCorreoElectronicoActionPerformed

    private void jFormattedTextFieldTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextFieldTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFormattedTextFieldTelefonoActionPerformed

    private void jFormattedTextFieldNumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextFieldNumeroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFormattedTextFieldNumeroActionPerformed

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

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Registro dialog = new Registro(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jButtonLogIn;
    private javax.swing.JComboBox<String> jComboBoxEmpresaParticular;
    private javax.swing.JFormattedTextField jFormattedTextFieldCodigoPostal;
    private javax.swing.JFormattedTextField jFormattedTextFieldNumero;
    private javax.swing.JFormattedTextField jFormattedTextFieldTelefono;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelCIF;
    private javax.swing.JLabel jLabelCalle;
    private javax.swing.JLabel jLabelCiudad;
    private javax.swing.JLabel jLabelCodigoPostal;
    private javax.swing.JLabel jLabelContrasena;
    private javax.swing.JLabel jLabelCorreoElectronico;
    private javax.swing.JLabel jLabelDNI;
    private javax.swing.JLabel jLabelExtra;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JLabel jLabelNumero;
    private javax.swing.JLabel jLabelRegistro;
    private javax.swing.JLabel jLabelTelefono;
    private javax.swing.JLabel jLabelTieneCuentaPregunta;
    private javax.swing.JLabel jLabelTipoDeUsuario;
    private javax.swing.JLabel jLabelWeb;
    private javax.swing.JTextField jTextFieldCIF;
    private javax.swing.JTextField jTextFieldCalle;
    private javax.swing.JTextField jTextFieldCiudad;
    private javax.swing.JTextField jTextFieldContrasena;
    private javax.swing.JTextField jTextFieldCorreoElectronico;
    private javax.swing.JTextField jTextFieldDNI;
    private javax.swing.JTextField jTextFieldExtra;
    private javax.swing.JTextField jTextFieldNombre;
    private javax.swing.JTextField jTextFieldWeb;
    private javax.swing.JToggleButton jToggleButtonGuardar;
    // End of variables declaration//GEN-END:variables
}
