
package Views;

import Controllers.ComputeController;
import javax.swing.JOptionPane;
import java.sql.SQLException;

public class EliminarEquipos extends javax.swing.JFrame {
       private ComputeController computeController;

   
    public EliminarEquipos(ComputeController computeController) {
        initComponents();
        this.computeController = computeController;
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtmodelo = new javax.swing.JTextField();
        BtnEliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Computec");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Eliminar Equipos");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Modelo:");

        BtnEliminar.setText("Elimianr Equipo");
        BtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BtnEliminar)
                    .addComponent(txtmodelo, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addGap(76, 76, 76)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtmodelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(BtnEliminar)
                .addContainerGap(87, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEliminarActionPerformed
       // Obtener el modelo del campo de texto
    String modelo = txtmodelo.getText().trim();
    
    // Validar que el campo de modelo no esté vacío
    if (modelo.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Por favor, ingrese el modelo del equipo.", "Error", JOptionPane.ERROR_MESSAGE);
        return; // Salir si el campo está vacío
    }
    
    // Llamar al método para eliminar el equipo
    boolean eliminado = false;
    try {
        eliminado = computeController.eliminarEquipo(modelo); // Asegúrate de que esta línea está presente
    } catch (SQLException e) {
        // Manejar la SQLException
        JOptionPane.showMessageDialog(this, "Error al eliminar el equipo: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        return; // Salir del método en caso de excepción
    }
    
    // Mostrar mensaje según el resultado de la eliminación
    if (eliminado) {
        JOptionPane.showMessageDialog(this, "Equipo eliminado con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        this.dispose(); // Cerrar la ventana después de la eliminación
    } else {
        JOptionPane.showMessageDialog(this, "Error al eliminar el equipo. Verifique el modelo.", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_BtnEliminarActionPerformed

 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnEliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txtmodelo;
    // End of variables declaration//GEN-END:variables
}
