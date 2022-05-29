package interfaces;

import classes.Opinion;
import classes.Producto;
import classes.UtilProducto;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ProductoPanelAdmin extends javax.swing.JPanel {

    public ArrayList<Opinion> opinionesaux = new ArrayList<Opinion>();
    private Opinion objopinion;
    private int opinionIndex;
    public MenuAdministrador Parent;

    /**
     * Creates new form ProductoPanelAdmin
     */
    public ProductoPanelAdmin() {
        initComponents();
    }

    public void setParent(MenuAdministrador Parent) {
        this.Parent = Parent;
    }

    public void setOpinionIndex(int i) {
        opinionIndex = i;
    }

    public int getOpinionIndex() {
        return opinionIndex;
    }

    public void mostrarOpiniones(int index) throws java.lang.IndexOutOfBoundsException {
        //try{
        opinionesaux = UtilProducto.getOpiniones();
        if (opinionesaux.size() < 1) {
            // JOptionPane.showMessageDialog(this, "No hay opiniones", "Mensaje", JOptionPane.INFORMATION_MESSAGE);

            jButtonEliminar.setEnabled(false);
            opinionPanel1.setVisible(false);
            return;
        } else {
            jButtonEliminar.setEnabled(true);
            opinionPanel1.setVisible(true);
        }
        opinionIndex = index;
        objopinion = UtilProducto.consultaOpinion(opinionIndex);
        presenta(objopinion);
        //}
        //catch(Exception e){
        //JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Mensaje", JOptionPane.ERROR_MESSAGE);
        //System.out.println("Error: " + e.toString());
        //}

    }

    /**
     * Presenta los datos de una persona en el panel de datos
     */
    private void presenta(Opinion opi) {

        opinionPanel1.setjLabelOpinion(opi.getComentario());
        opinionPanel1.setPuntuacion(opi.getCalificacion());
        opinionPanel1.setjLabelFecha(opi.getFechaRealizacion().toString());
        //productoPanelAdmin1.set

    }

    public String getjTextFieldNombreProducto() {
        return jTextFieldNombreProducto.getText();
    }

    public void setjTextFieldNombreProducto(String txt) {
        jTextFieldNombreProducto.setText(txt);
    }

    public String getjTextFieldDescripcion() {
        return jTextFieldDescripcion.getText();
    }

    public void setjTextFieldDescripcion(String txt) {
        jTextFieldDescripcion.setText(txt);
    }

    public String getjComboBoxCategoria() {
        return String.valueOf(jComboBoxCategoria.getSelectedItem());
    }

    public void setjComboBoxCategoria(String txt) {
        jComboBoxCategoria.setSelectedItem(txt);
    }

    public Double getjFormattedTextFieldPrecio() {
        String str = String.valueOf(jFormattedTextFieldPrecio.getValue());
        return Double.parseDouble(str);
    }

    public void setjFormattedTextFieldPrecio(double num) {
        jFormattedTextFieldPrecio.setValue(num);
    }

    public String getjTextFieldFotoProducto() {
        return jTextFieldFotoProducto.getText();
    }

    public void setjTextFieldFotoProducto(String txt) {
        jTextFieldFotoProducto.setText(txt);
    }

    public int getjFormattedTextFieldStock() {
        return Integer.parseInt(jFormattedTextFieldStock.getText());
    }

    public void setjFormattedTextFieldStock(int num) {
        jFormattedTextFieldStock.setText(String.valueOf(num));
    }

    public void setjLabelFotoProducto(String URL) {
        jLabelFotoProducto.setIcon(new ImageIcon(getClass().getResource(URL)));
    }

    public String getjTextFieldFechaDeEntrada() {
        return jTextFieldFechaDeEntrada.getText();
    }

    public void setjTextFieldFechaDeEntrada(LocalDate date) {
        jTextFieldFechaDeEntrada.setText(date.toString());
    }

    public void setNuevoProducto() {
        jPanelOpiniones.setVisible(false);
        jLabelFechaDeEntrada.setVisible(false);
        jTextFieldFechaDeEntrada.setVisible(false);
        clearAll();

    }

    public void setModificarConsultarProducto() {
        jPanelOpiniones.setVisible(true);
        jLabelFechaDeEntrada.setVisible(true);
        jTextFieldFechaDeEntrada.setVisible(true);

    }

    public void setFotoProducto(String URL) {
        jLabelFotoProducto.setIcon(new ImageIcon(getClass().getResource("/images/" + URL)));
    }

    public void clearAll() {
        jTextFieldNombreProducto.setText(null);
        jTextFieldDescripcion.setText(null);
        jComboBoxCategoria.setSelectedIndex(0);
        jFormattedTextFieldPrecio.setText(null);
        jTextFieldFotoProducto.setText(null);
        jFormattedTextFieldStock.setText(null);
        jLabelFotoProducto.setIcon(null);
    }

    public void setBarraValue(double value) {
        int valueInt = ((int) (value + 0.5)) * 100;
        jProgressBarPuntuacion.setValue(valueInt);
    }

    public void setPuntuacion(double puntuacion) {
        jLabelStockTextoPuntuacionMediaValor.setText(String.valueOf(puntuacion));
        setBarraValue(puntuacion);
    }

    public void clearNuevaOpinion() {
        jTextFieldTextoOpinion.setText(null);
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
        jTextFieldNombreProducto = new javax.swing.JTextField();
        jTextFieldDescripcion = new javax.swing.JTextField();
        jLabelStockCategoria = new javax.swing.JLabel();
        jComboBoxCategoria = new javax.swing.JComboBox<>();
        jLabelStockFotoPRoducto = new javax.swing.JLabel();
        jTextFieldFotoProducto = new javax.swing.JTextField();
        jFormattedTextFieldPrecio = new javax.swing.JFormattedTextField();
        jFormattedTextFieldStock = new javax.swing.JFormattedTextField();
        jLabelFechaDeEntrada = new javax.swing.JLabel();
        jPanelOpiniones = new javax.swing.JPanel();
        jLabelStockOpiniones = new javax.swing.JLabel();
        opinionPanel1 = new interfaces.OpinionPanel();
        jButtonAnteriorOpinion = new javax.swing.JButton();
        jButtonSiguienteOpinion = new javax.swing.JButton();
        jLabelStockTextoPuntuacionMedia = new javax.swing.JLabel();
        jLabelStockTextoPuntuacionMediaValor = new javax.swing.JLabel();
        jProgressBarPuntuacion = new javax.swing.JProgressBar();
        jButtonEliminar = new javax.swing.JButton();
        jLabelStockNuevaOpinion = new javax.swing.JLabel();
        jTextFieldTextoOpinion = new javax.swing.JTextField();
        jLabelStockTextoOpinion = new javax.swing.JLabel();
        jButtonAñadirOpinion = new javax.swing.JButton();
        jTextFieldFechaDeEntrada = new javax.swing.JTextField();

        jLabelNombreProducto.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelNombreProducto.setText("Nombre");

        jLabelFotoProducto.setBackground(new java.awt.Color(51, 51, 51));

        jLabelDescripcion.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelDescripcion.setText("Descripción:");

        jLabelPrecio.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelPrecio.setText("Precio: ");

        jLabelStock.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelStock.setText("Stock: ");

        jTextFieldNombreProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNombreProductoActionPerformed(evt);
            }
        });

        jLabelStockCategoria.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelStockCategoria.setText("Categoria");

        jComboBoxCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Componentes", "Ordenadores", "Móviles y telefonía", "TV, audio y foto", "Consolas y videojuegos" }));
        jComboBoxCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxCategoriaActionPerformed(evt);
            }
        });

        jLabelStockFotoPRoducto.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelStockFotoPRoducto.setText("FotoURL");

        jTextFieldFotoProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldFotoProductoActionPerformed(evt);
            }
        });

        jFormattedTextFieldPrecio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        jFormattedTextFieldPrecio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jFormattedTextFieldPrecioMouseClicked(evt);
            }
        });
        jFormattedTextFieldPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextFieldPrecioActionPerformed(evt);
            }
        });

        jFormattedTextFieldStock.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

        jLabelFechaDeEntrada.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelFechaDeEntrada.setText("FechaDeEntrada");

        jLabelStockOpiniones.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelStockOpiniones.setText("Opiniones:");

        opinionPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButtonAnteriorOpinion.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonAnteriorOpinion.setText("<--");
        jButtonAnteriorOpinion.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButtonAnteriorOpinion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAnteriorOpinionActionPerformed(evt);
            }
        });

        jButtonSiguienteOpinion.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonSiguienteOpinion.setText("-->");
        jButtonSiguienteOpinion.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButtonSiguienteOpinion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSiguienteOpinionActionPerformed(evt);
            }
        });

        jLabelStockTextoPuntuacionMedia.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelStockTextoPuntuacionMedia.setText("Puntuacion media:");

        jLabelStockTextoPuntuacionMediaValor.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelStockTextoPuntuacionMediaValor.setText("4,5");

        jProgressBarPuntuacion.setBackground(new java.awt.Color(204, 204, 204));
        jProgressBarPuntuacion.setForeground(new java.awt.Color(255, 204, 0));
        jProgressBarPuntuacion.setMaximum(500);
        jProgressBarPuntuacion.setValue(200);

        jButtonEliminar.setText("Eliminar");
        jButtonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarActionPerformed(evt);
            }
        });

        jLabelStockNuevaOpinion.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelStockNuevaOpinion.setText("NuevaOpinion");

        jLabelStockTextoOpinion.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelStockTextoOpinion.setText("TextoOpinion:");

        jButtonAñadirOpinion.setText("Añadir opinion");
        jButtonAñadirOpinion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAñadirOpinionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelOpinionesLayout = new javax.swing.GroupLayout(jPanelOpiniones);
        jPanelOpiniones.setLayout(jPanelOpinionesLayout);
        jPanelOpinionesLayout.setHorizontalGroup(
            jPanelOpinionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelOpinionesLayout.createSequentialGroup()
                .addGroup(jPanelOpinionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelOpinionesLayout.createSequentialGroup()
                        .addGroup(jPanelOpinionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelOpinionesLayout.createSequentialGroup()
                                .addGap(97, 97, 97)
                                .addComponent(jLabelStockTextoPuntuacionMedia, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabelStockTextoPuntuacionMediaValor, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(jProgressBarPuntuacion, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelOpinionesLayout.createSequentialGroup()
                                .addGap(208, 208, 208)
                                .addComponent(jButtonAnteriorOpinion, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonSiguienteOpinion, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 190, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelOpinionesLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(97, 97, 97))
                    .addComponent(jLabelStockOpiniones, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanelOpinionesLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanelOpinionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelOpinionesLayout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addComponent(jLabelStockNuevaOpinion))
                    .addGroup(jPanelOpinionesLayout.createSequentialGroup()
                        .addComponent(jLabelStockTextoOpinion, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldTextoOpinion, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jButtonAñadirOpinion)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanelOpinionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelOpinionesLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(opinionPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(186, Short.MAX_VALUE)))
        );
        jPanelOpinionesLayout.setVerticalGroup(
            jPanelOpinionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelOpinionesLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanelOpinionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAnteriorOpinion)
                    .addComponent(jButtonSiguienteOpinion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelStockOpiniones)
                .addGap(29, 29, 29)
                .addComponent(jButtonEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addGroup(jPanelOpinionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelOpinionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelStockTextoPuntuacionMedia)
                        .addComponent(jLabelStockTextoPuntuacionMediaValor))
                    .addComponent(jProgressBarPuntuacion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jLabelStockNuevaOpinion)
                .addGap(18, 18, 18)
                .addGroup(jPanelOpinionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelStockTextoOpinion, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelOpinionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldTextoOpinion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonAñadirOpinion, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(121, 121, 121))
            .addGroup(jPanelOpinionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelOpinionesLayout.createSequentialGroup()
                    .addGap(87, 87, 87)
                    .addComponent(opinionPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(269, Short.MAX_VALUE)))
        );

        jTextFieldFechaDeEntrada.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabelFotoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabelNombreProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelStock, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelDescripcion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelPrecio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelStockCategoria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelStockFotoPRoducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelFechaDeEntrada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldDescripcion, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jComboBoxCategoria, 0, 354, Short.MAX_VALUE)
                            .addComponent(jTextFieldFotoProducto)
                            .addComponent(jTextFieldNombreProducto, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jFormattedTextFieldPrecio, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jFormattedTextFieldStock)
                            .addComponent(jTextFieldFechaDeEntrada))
                        .addGap(9, 9, 9))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanelOpiniones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelNombreProducto)
                            .addComponent(jTextFieldNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelStockCategoria)
                            .addComponent(jComboBoxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelPrecio)
                            .addComponent(jFormattedTextFieldPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelStockFotoPRoducto)
                            .addComponent(jTextFieldFotoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelStock)
                            .addComponent(jFormattedTextFieldStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelFechaDeEntrada)
                            .addComponent(jTextFieldFechaDeEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabelFotoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanelOpiniones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxCategoriaActionPerformed

    private void jTextFieldNombreProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNombreProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNombreProductoActionPerformed

    private void jTextFieldFotoProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldFotoProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldFotoProductoActionPerformed

    private void jButtonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonEliminarActionPerformed

    private void jButtonAñadirOpinionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAñadirOpinionActionPerformed
        // TODO add your handling code here:

        try {
            String comentario = "@ADMIN:" + jTextFieldTextoOpinion.getText();
            int puntuacion = -1;
            //Establecemos el dia actual del alta como fecha entrada
            LocalDate fechaActual = LocalDate.now();
            LocalDate fechaDeEntrada = fechaActual;
            //ArrayList<Opinion> opiniones = null;
            Opinion opinion = new Opinion(puntuacion, comentario, fechaDeEntrada);
            //lo insertamos en el array
            if (UtilProducto.altaOpinion(opinion)) {
                JOptionPane.showMessageDialog(this, "La opinion se ha publicado correctamente", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                clearNuevaOpinion();
                UtilProducto.guardarDatos();
                setOpinionIndex(0);
                mostrarOpiniones(getOpinionIndex());

            } else {
                JOptionPane.showMessageDialog(this, "La opinion ya existia", "Mensaje", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Excepción al opinar", "Mensaje", JOptionPane.ERROR_MESSAGE);
        }

        //Parent.conectarOpiniones();
        // System.out.println(UtilProducto.getProductos().toString());
    }//GEN-LAST:event_jButtonAñadirOpinionActionPerformed

    private void jFormattedTextFieldPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextFieldPrecioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFormattedTextFieldPrecioActionPerformed

    private void jFormattedTextFieldPrecioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jFormattedTextFieldPrecioMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jFormattedTextFieldPrecioMouseClicked

    private void jButtonSiguienteOpinionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSiguienteOpinionActionPerformed
        // TODO add your handling code here:
        try {
            opinionIndex += 1;
            mostrarOpiniones(opinionIndex);
        } catch (java.lang.IndexOutOfBoundsException e) {
            opinionIndex -= 1;
            JOptionPane.showMessageDialog(this, "No hay más opiniones", "Mensaje", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jButtonSiguienteOpinionActionPerformed

    private void jButtonAnteriorOpinionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAnteriorOpinionActionPerformed
        // TODO add your handling code here:
        try {
            opinionIndex -= 1;
            mostrarOpiniones(opinionIndex);
        } catch (java.lang.IndexOutOfBoundsException e) {
            opinionIndex += 1;
            JOptionPane.showMessageDialog(this, "No hay más opiniones", "Mensaje", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonAnteriorOpinionActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAnteriorOpinion;
    private javax.swing.JButton jButtonAñadirOpinion;
    private javax.swing.JButton jButtonEliminar;
    private javax.swing.JButton jButtonSiguienteOpinion;
    private javax.swing.JComboBox<String> jComboBoxCategoria;
    private javax.swing.JFormattedTextField jFormattedTextFieldPrecio;
    private javax.swing.JFormattedTextField jFormattedTextFieldStock;
    private javax.swing.JLabel jLabelDescripcion;
    private javax.swing.JLabel jLabelFechaDeEntrada;
    private javax.swing.JLabel jLabelFotoProducto;
    private javax.swing.JLabel jLabelNombreProducto;
    private javax.swing.JLabel jLabelPrecio;
    private javax.swing.JLabel jLabelStock;
    private javax.swing.JLabel jLabelStockCategoria;
    private javax.swing.JLabel jLabelStockFotoPRoducto;
    private javax.swing.JLabel jLabelStockNuevaOpinion;
    private javax.swing.JLabel jLabelStockOpiniones;
    private javax.swing.JLabel jLabelStockTextoOpinion;
    private javax.swing.JLabel jLabelStockTextoPuntuacionMedia;
    private javax.swing.JLabel jLabelStockTextoPuntuacionMediaValor;
    private javax.swing.JPanel jPanelOpiniones;
    private javax.swing.JProgressBar jProgressBarPuntuacion;
    private javax.swing.JTextField jTextFieldDescripcion;
    private javax.swing.JTextField jTextFieldFechaDeEntrada;
    private javax.swing.JTextField jTextFieldFotoProducto;
    private javax.swing.JTextField jTextFieldNombreProducto;
    private javax.swing.JTextField jTextFieldTextoOpinion;
    private interfaces.OpinionPanel opinionPanel1;
    // End of variables declaration//GEN-END:variables
}
