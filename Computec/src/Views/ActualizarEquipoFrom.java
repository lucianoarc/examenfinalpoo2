
package Views;

import Controllers.ComputeController;
import Models.Computador_Escritorio;
import javax.swing.JOptionPane;
import java.sql.SQLException;

public class ActualizarEquipoFrom extends javax.swing.JFrame {

     private ComputeController computeController;
    
    public ActualizarEquipoFrom(ComputeController computeController) {
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
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtmodelo = new javax.swing.JTextField();
        txtcpu = new javax.swing.JTextField();
        txtplaca = new javax.swing.JTextField();
        txtram = new javax.swing.JTextField();
        txtdisco = new javax.swing.JTextField();
        txtfuente = new javax.swing.JTextField();
        txtprecio = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Computec");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Actualizar Equipo");

        jLabel3.setText("Modelo:");

        jLabel4.setText("Cpu:");

        jLabel5.setText("Placa_Madre:");

        jLabel6.setText("Ram:");

        jLabel7.setText("Disco_Duro:");

        jLabel8.setText("Fuente_Poder:");

        jLabel9.setText("Precio:");

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
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(50, 50, 50)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtdisco, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                                    .addComponent(txtmodelo)
                                    .addComponent(txtcpu)
                                    .addComponent(txtplaca)
                                    .addComponent(txtram)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton1)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtfuente)
                                        .addComponent(txtprecio, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtmodelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtcpu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtplaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                    .addComponent(jLabel8)
                    .addComponent(txtfuente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtprecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // Obtener datos de los campos de texto
    String modelo = txtmodelo.getText().trim();
    String cpu = txtcpu.getText().trim();
    String placa_madre = txtplaca.getText().trim();
    String ram = txtram.getText().trim();
    String disco_duro = txtdisco.getText().trim();
    String fuente = txtfuente.getText().trim();
    String preciotexto = txtprecio.getText().trim();
    
    // Validar campos obligatorios
    if (modelo.isEmpty() || cpu.isEmpty() || placa_madre.isEmpty() || ram.isEmpty() || disco_duro.isEmpty() || fuente.isEmpty()|| preciotexto.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    
    // Validar y convertir el número de teléfono a int
    int precio;
    try {
        precio = Integer.parseInt(preciotexto);
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "El precio debe ser un numero entero valido.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    
    // Crear el objeto Clientes con los datos ingresados
    Computador_Escritorio escritorio = new Computador_Escritorio();
    escritorio.setModelo(modelo);
    escritorio.setCpu(cpu);
    escritorio.setDisco_duro(disco_duro);
    escritorio.setPlaca_madre(placa_madre);
    escritorio.setRam(ram);
    escritorio.setFuente_poder(fuente);
    escritorio.setPrecio(precio);
    
    // Crear una instancia de ComputeController (si no lo has hecho antes)
    if (computeController == null) {
        computeController = new ComputeController(); // Asegúrate de tener acceso a ComputeController
    }
    
    // Llamar al método para actualizar el equipo dentro de un bloque try-catch
    boolean actualizado = false;
    try {
        actualizado = computeController.actualizarEquipo(escritorio); // Aquí puede lanzarse SQLException
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error al actualizar el equipo: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        return; // Salir del método en caso de excepción
    }
    
    // Mostrar mensaje según el resultado de la actualización
    if (actualizado) {
        JOptionPane.showMessageDialog(this, "Equipo actualizado con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        this.dispose(); // Cerrar la ventana después de la actualización
    } else {
        JOptionPane.showMessageDialog(this, "Error al actualizar el Equipo. Verifique el Modelo.", "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    }//GEN-LAST:event_jButton1ActionPerformed

  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JTextField txtfuente;
    private javax.swing.JTextField txtmodelo;
    private javax.swing.JTextField txtplaca;
    private javax.swing.JTextField txtprecio;
    private javax.swing.JTextField txtram;
    // End of variables declaration//GEN-END:variables
}
