
package Views;

import Controllers.ComputeController;
import Models.Clientes;
import Models.Equipo;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;


public class VentasFrom extends javax.swing.JFrame {

     private ComputeController computeController;
     


   
    public VentasFrom(ComputeController computeController) {
         initComponents();
         this.computeController = computeController;
         loadEquipos(); // Cargar los equipos al inicializar el JFrame
            }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtrut = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtnombre = new javax.swing.JTextPane();
        jLabel4 = new javax.swing.JLabel();
        BtnGenerarVenta = new javax.swing.JButton();
        comEquipos = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Computec");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Ventas");

        jLabel3.setText("Rut:");

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(txtnombre);

        jLabel4.setText("Selecionar Equipo:");

        BtnGenerarVenta.setText("Generar Venta");
        BtnGenerarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnGenerarVentaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(txtrut, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jButton1))
                            .addComponent(comEquipos, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 26, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BtnGenerarVenta)
                .addGap(145, 145, 145))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtrut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(comEquipos, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(BtnGenerarVenta)
                .addGap(17, 17, 17))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

   
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      String rut = txtrut.getText().trim();
      
     // Verificar que el rut no esté vacío
    if (rut.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Ingrese un rut");
        return;
    }
      try {
    // Llamar al método para buscar el cliente por RUT
    Clientes cliente = computeController.buscarClientePorRut(rut); // Cambia el método de búsqueda

    if (cliente != null) {
        // Mostrar todos los detalles del cliente
        txtnombre.setText(cliente.getNombre()); // Asegúrate de tener un método getNombre() en tu modelo
        
    } else {
        // Si no se encuentra el cliente
        JOptionPane.showMessageDialog(null, "Cliente no encontrado.");
        txtnombre.setText(""); // Limpiar el campo de nombre
        
    }
} catch (Exception e) {
    // Manejo de errores (puedes personalizar el mensaje)
    JOptionPane.showMessageDialog(null, "Ocurrio un error al buscar el cliente: " + e.getMessage());
}
    }//GEN-LAST:event_jButton1ActionPerformed

    private void BtnGenerarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnGenerarVentaActionPerformed
       // Obtener el RUT y el modelo del equipo del formulario
        String rut = txtrut.getText(); // Asegúrate de que tienes un campo de texto para RUT
        Equipo equipoSeleccionado = (Equipo) comEquipos.getSelectedItem(); // Obtener el equipo seleccionado

        String modelo = equipoSeleccionado != null ? equipoSeleccionado.getModelo() : null;

        if (rut.isEmpty() || modelo == null) {
            JOptionPane.showMessageDialog(this, "Por favor, completa todos los campos necesarios.");
            return;
        }

        // Llamar al método en ComputeController para registrar la venta
        boolean exito = computeController.registrarVenta(rut, modelo);

        if (exito) {
            JOptionPane.showMessageDialog(this, "Venta registrada exitosamente.");
        } else {
            JOptionPane.showMessageDialog(this, "Error al registrar la venta. Intenta de nuevo.");
        }
    }//GEN-LAST:event_BtnGenerarVentaActionPerformed

     // Método para cargar los equipos en el JComboBox
    private void loadEquipos() {
        List<Equipo> equipos = computeController.getEquiposFromDB(); // Obtener la lista de equipos
        DefaultComboBoxModel<Equipo> model = new DefaultComboBoxModel<>();

        // Agregar cada equipo al modelo del JComboBox
        for (Equipo equipo : equipos) {
            model.addElement(equipo); // Agregar el objeto equipo directamente
        }

        comEquipos.setModel(model); // Asignar el modelo al JComboBox
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnGenerarVenta;
    private javax.swing.JComboBox<Equipo> comEquipos;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane txtnombre;
    private javax.swing.JTextField txtrut;
    // End of variables declaration//GEN-END:variables
}
