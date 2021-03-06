
package interfaces;

import classes.Tarjeta;
import classes.UtilRegistro;
import javax.swing.JOptionPane;
import static interfaces.Login.objcli;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;


public class InterfazTarjeta extends javax.swing.JDialog {

    /**
     * Creates new form Tarjeta
     */
    public InterfazTarjeta(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null); //Esta linea se pone para que la ventana salga centrada.
        Tarjeta tarj = objcli.getTarjeta();
        if(tarj!=null){
            setjTextFieldTitularCuenta(tarj.getNombreTitular());
            setjFormattedTextFieldNumero(tarj.getNumero());
            setjFormattedTextFieldFechacaducidad(tarj.getFecha().toString());            
        }
    }

    private InterfazTarjeta(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    public String getjTextFieldTitularCuenta(){
        return jTextFieldTitularDeLaCuenta.getText();
    }
    public long getjFormattedTextFieldNumero(){
        return Long.parseLong(jFormattedTextFieldNumeroDeTarjeta.getText());
    }
    public Date getjFormattedTextFieldFechaCaducidad(){
        return (Date) jFormattedTextFieldFechaDeCaducidad.getValue();
    }
    public void setjTextFieldTitularCuenta(String txt){
        jTextFieldTitularDeLaCuenta.setText(txt);
    }
    public void setjFormattedTextFieldNumero(long num){
        jFormattedTextFieldNumeroDeTarjeta.setValue(num);
    }
    public void setjFormattedTextFieldFechacaducidad(String txt){
        jFormattedTextFieldFechaDeCaducidad.setText(txt);
    }
    //Convierte un Date a Localdate
    public LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
    return dateToConvert.toInstant()
      .atZone(ZoneId.systemDefault())
      .toLocalDate();
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelDatosBancarios = new javax.swing.JLabel();
        jLabelTitularDeLaCuenta = new javax.swing.JLabel();
        jLabelNumeroTarjetaDeCredito = new javax.swing.JLabel();
        jLabelFechaDeCaducidad = new javax.swing.JLabel();
        jTextFieldTitularDeLaCuenta = new javax.swing.JTextField();
        jFormattedTextFieldNumeroDeTarjeta = new javax.swing.JFormattedTextField();
        jFormattedTextFieldFechaDeCaducidad = new javax.swing.JFormattedTextField();
        jButtonVolver = new javax.swing.JButton();
        jButtonValidar = new javax.swing.JButton();
        jLabelLogo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabelDatosBancarios.setFont(new java.awt.Font("Microsoft YaHei", 1, 24)); // NOI18N
        jLabelDatosBancarios.setForeground(new java.awt.Color(44, 160, 201));
        jLabelDatosBancarios.setText("DATOS BANCARIOS");

        jLabelTitularDeLaCuenta.setText("Titular de la cuenta:");

        jLabelNumeroTarjetaDeCredito.setText("N??mero de tarjeta de cr??dito:");

        jLabelFechaDeCaducidad.setText("Fecha de caducidad:");

        jTextFieldTitularDeLaCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTitularDeLaCuentaActionPerformed(evt);
            }
        });

        jFormattedTextFieldNumeroDeTarjeta.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        jFormattedTextFieldNumeroDeTarjeta.setToolTipText("Recuerda no usar espacios");

        jFormattedTextFieldFechaDeCaducidad.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT))));
        jFormattedTextFieldFechaDeCaducidad.setToolTipText("Introducir DD/M/AA");

        jButtonVolver.setText("Volver");
        jButtonVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVolverActionPerformed(evt);
            }
        });

        jButtonValidar.setText("VALIDAR");
        jButtonValidar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonValidarActionPerformed(evt);
            }
        });

        jLabelLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logoMedio.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelLogo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelNumeroTarjetaDeCredito, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelFechaDeCaducidad, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelTitularDeLaCuenta, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jFormattedTextFieldNumeroDeTarjeta)
                            .addComponent(jTextFieldTitularDeLaCuenta)
                            .addComponent(jFormattedTextFieldFechaDeCaducidad, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(57, 57, 57))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabelDatosBancarios)
                        .addGap(75, 75, 75)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addComponent(jButtonVolver)
                .addGap(166, 166, 166)
                .addComponent(jButtonValidar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabelDatosBancarios)
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelTitularDeLaCuenta)
                            .addComponent(jTextFieldTitularDeLaCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelNumeroTarjetaDeCredito)
                            .addComponent(jFormattedTextFieldNumeroDeTarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelFechaDeCaducidad)
                            .addComponent(jFormattedTextFieldFechaDeCaducidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                        .addComponent(jButtonVolver)
                        .addGap(50, 50, 50))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jButtonValidar)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldTitularDeLaCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTitularDeLaCuentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldTitularDeLaCuentaActionPerformed

    private void jButtonVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVolverActionPerformed
            super.setVisible(true);
            this.setVisible(false);
    }//GEN-LAST:event_jButtonVolverActionPerformed

    private void jButtonValidarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonValidarActionPerformed
        // Verificamos que los parametros introducidos son correctos
        //Verificamos que se hayan rellenado todos los parametros
        if(jTextFieldTitularDeLaCuenta.getText().isBlank()||
            jFormattedTextFieldNumeroDeTarjeta.getText().isBlank()||
            jFormattedTextFieldFechaDeCaducidad.getText().isBlank()){
            JOptionPane.showMessageDialog(this, "Rellena todos los campos", "Error", JOptionPane.WARNING_MESSAGE);
        }
        else
        if(jFormattedTextFieldNumeroDeTarjeta.getText().contains(" ")){//Comprobamos que el Numero de la tarjeta no contenga espacios.
            JOptionPane.showMessageDialog(this, "Introduce el n??mero de la tarjeta sin espacios", "Error", JOptionPane.WARNING_MESSAGE);
        }
        if(jFormattedTextFieldNumeroDeTarjeta.getText().length()!=16){//Comprobamos que el Numero de la tarjeta contiene 16 numeros
            JOptionPane.showMessageDialog(this, "El numero de tarjeta debe contener 16 caracteres", "Error", JOptionPane.WARNING_MESSAGE);
        }
        else
        if(jFormattedTextFieldFechaDeCaducidad.getText().contains(" ")){//Comprobamos que la fecha de caducidad no contiene espacios
            JOptionPane.showMessageDialog(this, "Introduce el n??mero de la tarjeta sin espacios", "Error", JOptionPane.WARNING_MESSAGE);
        }
        else
        if(convertToLocalDateViaInstant((Date) jFormattedTextFieldFechaDeCaducidad.getValue()).isBefore(LocalDate.now())){//Comprobamos que la tarjeta no ha caducado
            JOptionPane.showMessageDialog(this, "Su tarjeta est?? caducada", "Error", JOptionPane.WARNING_MESSAGE);
        }
        else{
        Tarjeta tarj = objcli.getTarjeta();
        if(tarj==null){
            classes.Tarjeta tar=new classes.Tarjeta(getjTextFieldTitularCuenta(),getjFormattedTextFieldNumero(),getjFormattedTextFieldFechaCaducidad());
            tarj=tar;
            JOptionPane.showMessageDialog(this, "Su tarjeta ha sido guardada con ??xito.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        }else{
        tarj.modificaTarjeta(tarj,getjTextFieldTitularCuenta(),getjFormattedTextFieldNumero(),getjFormattedTextFieldFechaCaducidad());
        JOptionPane.showMessageDialog(this, "Su tarjeta ha sido guardada con ??xito.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        }
        objcli.setTarjeta(tarj);
        UtilRegistro.guardarDatos();
        }  
    }//GEN-LAST:event_jButtonValidarActionPerformed

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
            java.util.logging.Logger.getLogger(InterfazTarjeta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfazTarjeta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfazTarjeta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfazTarjeta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                InterfazTarjeta dialog = new InterfazTarjeta(new javax.swing.JDialog(), true);
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
    private javax.swing.JButton jButtonValidar;
    private javax.swing.JButton jButtonVolver;
    private javax.swing.JFormattedTextField jFormattedTextFieldFechaDeCaducidad;
    private javax.swing.JFormattedTextField jFormattedTextFieldNumeroDeTarjeta;
    private javax.swing.JLabel jLabelDatosBancarios;
    private javax.swing.JLabel jLabelFechaDeCaducidad;
    private javax.swing.JLabel jLabelLogo;
    private javax.swing.JLabel jLabelNumeroTarjetaDeCredito;
    private javax.swing.JLabel jLabelTitularDeLaCuenta;
    private javax.swing.JTextField jTextFieldTitularDeLaCuenta;
    // End of variables declaration//GEN-END:variables
}
