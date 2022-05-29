package interfaces;

import classes.Cliente;
import classes.UtilProducto;
import classes.UtilRegistro;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.ListIterator;

public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    private ArrayList<Cliente> cliaux; //Referencia al ArrayList de personas de la clase UtilCenso
    private ListIterator<Cliente> li; //Iterador para recorrer el ArrayList en ambas direcciones
    public static Cliente objcli; //Referencia a un objeto de tipo persona del ArrayList

    private void verificacion() {
        try {
            //referenciamos al ArrayList de UtilCenso
            cliaux = UtilRegistro.getClientes();
            //creamos el iterador sobre el ArrayList
            li = cliaux.listIterator();
            //si no hay personas...
            if (cliaux.size() < 1) {
                JOptionPane.showMessageDialog(this, "No está registrado.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            //presentamos la primera persona
            objcli = (Cliente) li.next();
            int i = 0;
            while (i <= cliaux.size()) {
                if (todoCorrecto(objcli) == 1) {
                    new MainMenu().setVisible(true);
                    this.setVisible(false);
                    break;
                } else if (todoCorrecto(objcli) == 2) {
                    new MenuAdministrador().setVisible(true);
                    this.setVisible(false);
                    break;
                } else {
                    objcli = (Cliente) li.next();
                    i += 1;
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: Correo o contraseña incorrectos", "Mensaje", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error: " + e.toString());
        }
    }//fin consultarTodo

    private int todoCorrecto(Cliente cli) {
        String correoIntroducido = jTextFieldCorreoElectronico.getText();
        String claveIntroducida = String.valueOf(jPasswordFieldContrasena.getPassword());
        String correo = cli.getCorreo();
        String clave = cli.getClave();
        if (correoIntroducido.equals(correo) && claveIntroducida.equals(clave)) {
            return 1;
        } else if (correoIntroducido.equals("admin@javacomp.com") && claveIntroducida.equals("admin")) {
            return 2;
        } else {
            return 0;
        }
    }

    public Login() {
        initComponents();
        this.setLocationRelativeTo(null); //Esta linea se pone para que la ventana salga centrada.
        //CARGAMOS LOS DATOS
        UtilRegistro.cargarDatos();
        UtilProducto.cargarDatos();
        UtilProducto.cargarDatosVentas();

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

        jPasswordFieldContrasena = new javax.swing.JPasswordField();
        jTextFieldCorreoElectronico = new javax.swing.JTextField();
        jButtonRegistrarse = new javax.swing.JButton();
        jLabelCorreoElectronico = new javax.swing.JLabel();
        jLabelContrasena = new javax.swing.JLabel();
        jLabelRegistradoPregunta = new javax.swing.JLabel();
        jLabelLogIn = new javax.swing.JLabel();
        jToggleButtonIniciarSesion = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(203, 203, 203));

        jPasswordFieldContrasena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordFieldContrasenaActionPerformed(evt);
            }
        });

        jTextFieldCorreoElectronico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCorreoElectronicoActionPerformed(evt);
            }
        });

        jButtonRegistrarse.setText("Registrarse");
        jButtonRegistrarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegistrarseActionPerformed(evt);
            }
        });

        jLabelCorreoElectronico.setText("Correo electrónico");

        jLabelContrasena.setText("Contraseña");

        jLabelRegistradoPregunta.setForeground(new java.awt.Color(50, 150, 180));
        jLabelRegistradoPregunta.setText("¿Aún no estás registrado?");

        jLabelLogIn.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabelLogIn.setForeground(new java.awt.Color(44, 160, 201));
        jLabelLogIn.setText("LOG IN");
        jLabelLogIn.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jToggleButtonIniciarSesion.setText("Iniciar sesión");
        jToggleButtonIniciarSesion.setToolTipText("Pulse aqui para iniciar sesión");
        jToggleButtonIniciarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButtonIniciarSesionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(172, 172, 172)
                        .addComponent(jLabelLogIn))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(162, 162, 162)
                        .addComponent(jToggleButtonIniciarSesion))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(59, 59, 59)
                            .addComponent(jLabelRegistradoPregunta)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                            .addComponent(jButtonRegistrarse, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(72, 72, 72)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabelCorreoElectronico)
                                .addComponent(jLabelContrasena))
                            .addGap(88, 88, 88)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jPasswordFieldContrasena, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                                .addComponent(jTextFieldCorreoElectronico)))))
                .addContainerGap(73, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabelLogIn)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCorreoElectronico)
                    .addComponent(jTextFieldCorreoElectronico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPasswordFieldContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addComponent(jToggleButtonIniciarSesion)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelRegistradoPregunta, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonRegistrarse))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPasswordFieldContrasenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordFieldContrasenaActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jPasswordFieldContrasenaActionPerformed

    private void jTextFieldCorreoElectronicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCorreoElectronicoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCorreoElectronicoActionPerformed

    private void jButtonRegistrarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegistrarseActionPerformed
        new Registro(this, true).setVisible(true);
        //this.setVisible(false);
    }//GEN-LAST:event_jButtonRegistrarseActionPerformed

    private void jToggleButtonIniciarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButtonIniciarSesionActionPerformed
        // TODO add your handling code here:
        /**
         *
         * El for comprueba que la contraseña no tenga espacios en ella
         */
        boolean ContrasenaConEspacios = false;
        for (int i = 0; i < jPasswordFieldContrasena.getPassword().length; i++) {
            System.out.println(jPasswordFieldContrasena.getPassword()[i]);
            if (jPasswordFieldContrasena.getPassword()[i] == ' ') {
                ContrasenaConEspacios = true;
            }
        }
        if (jPasswordFieldContrasena.getPassword().length == 0 || jTextFieldCorreoElectronico.getText().isBlank()) {  //Se comprueba que los campos esten rellenos
            JOptionPane.showMessageDialog(this, "Rellena todos los campos", "Error", JOptionPane.WARNING_MESSAGE);
        } else if (jTextFieldCorreoElectronico.getText().contains(" ")) {
            JOptionPane.showMessageDialog(this, "El correo no puede tener espacios", "Error", JOptionPane.WARNING_MESSAGE); //Luego se comprueba que el correo sea correcto
        } else if (ContrasenaConEspacios) {
            JOptionPane.showMessageDialog(this, "La contraseña no puede tener espacios", "Error", JOptionPane.WARNING_MESSAGE); //Luego se comprueba la contraseña con la booleana anterior
        }

        verificacion();
        System.out.println(UtilRegistro.getClientes().toString());

    }//GEN-LAST:event_jToggleButtonIniciarSesionActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */


        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */ try {
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
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonRegistrarse;
    private javax.swing.JLabel jLabelContrasena;
    private javax.swing.JLabel jLabelCorreoElectronico;
    private javax.swing.JLabel jLabelLogIn;
    private javax.swing.JLabel jLabelRegistradoPregunta;
    private javax.swing.JPasswordField jPasswordFieldContrasena;
    private javax.swing.JTextField jTextFieldCorreoElectronico;
    private javax.swing.JToggleButton jToggleButtonIniciarSesion;
    // End of variables declaration//GEN-END:variables
}
