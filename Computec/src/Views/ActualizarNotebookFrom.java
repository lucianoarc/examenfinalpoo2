
package Views;

import Controllers.ComputeController;
import Models.Notebook;
import javax.swing.JOptionPane;
import java.sql.SQLException;

public class ActualizarNotebookFrom extends javax.swing.JFrame {
    
    private ComputeController computeController;

    public ActualizarNotebookFrom(ComputeController computeController) {
        initComponents();
        this.computeController = computeController;
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtmodelo = new javax.swing.JTextField();
        txtcpu = new javax.swing.JTextField();
        txtram = new javax.swing.JTextField();
        txtdisco = new javax.swing.JTextField();
        txtpantalla = new javax.swing.JTextField();
        txtusb = new javax.swing.JTextField();
        cbTouch = new javax.swing.JCheckBox();
        txtprecio = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Computec");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Actualizar Equipo");

        jLabel3.setText("Modelo:");

        jLabel4.setText("Cpu:");

        jLabel6.setText("Ram:");

        jLabel7.setText("Disco_Duro:");

        jLabel5.setText("Pantalla:");

        jLabel8.setText("Usb:");

        jLabel10.setText("Touch:");

        jLabel9.setText("Precio:");

        cbTouch.setText("SI");

        jButton1.setText("Actualizar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(cbTouch, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtdisco)
                                .addComponent(txtmodelo)
                                .addComponent(txtcpu)
                                .addComponent(txtram)
                                .addComponent(txtpantalla)
                                .addComponent(txtusb)
                                .addComponent(txtprecio, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtmodelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtcpu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtram, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtdisco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtpantalla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtusb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(cbTouch))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtprecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // Obtener datos de los campos de texto
String modelo = txtmodelo.getText().trim();
String cpu = txtcpu.getText().trim();
String pantalla = txtpantalla.getText().trim();
String ram = txtram.getText().trim();
String disco_duro = txtdisco.getText().trim();
String usb = txtusb.getText().trim();
String preciotexto = txtprecio.getText().trim();
boolean touch = cbTouch.isSelected(); 

// Validar campos obligatorios
if (modelo.isEmpty() || cpu.isEmpty() || pantalla.isEmpty() || ram.isEmpty() || disco_duro.isEmpty() || usb.isEmpty() || preciotexto.isEmpty()) {
    JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
    return;
}

// Validar y convertir el precio a int
int precio;
try {
    precio = Integer.parseInt(preciotexto);
} catch (NumberFormatException e) {
    JOptionPane.showMessageDialog(this, "El precio debe ser un numero entero valido.", "Error", JOptionPane.ERROR_MESSAGE);
    return;
}

// Crear el objeto Notebook con los datos ingresados
Notebook notebook = new Notebook();
notebook.setModelo(modelo);
notebook.setCpu(cpu);
notebook.setDisco_duro(disco_duro);
notebook.setPantalla(pantalla);
notebook.setRam(ram);
notebook.setUsb(usb);
notebook.setTouch(touch);
notebook.setPrecio(precio);

// Crear una instancia de ComputeController (si no lo has hecho antes)
if (computeController == null) {
    computeController = new ComputeController(); // Asegúrate de tener acceso a ComputeController
}

// Llamar al método para actualizar el equipo dentro de un bloque try-catch
boolean actualizado = false;
try {
    actualizado = computeController.actualizarEquipo(notebook); // Aquí puede lanzarse SQLException
} catch (SQLException e) {
    JOptionPane.showMessageDialog(this, "Error al actualizar el equipo: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    return; // Salir del método en caso de excepción
}

// Mostrar mensaje según el resultado de la actualización
if (actualizado) {
    JOptionPane.showMessageDialog(this, "Equipo actualizado con exito.", "Exito", JOptionPane.INFORMATION_MESSAGE);
    this.dispose(); // Cerrar la ventana después de la actualización
} else {
    JOptionPane.showMessageDialog(this, "Error al actualizar el equipo. Verifique el modelo.", "Error", JOptionPane.ERROR_MESSAGE);
}
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox cbTouch;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txtcpu;
    private javax.swing.JTextField txtdisco;
    private javax.swing.JTextField txtmodelo;
    private javax.swing.JTextField txtpantalla;
    private javax.swing.JTextField txtprecio;
    private javax.swing.JTextField txtram;
    private javax.swing.JTextField txtusb;
    // End of variables declaration//GEN-END:variables
}
