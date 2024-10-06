
package Views;

import Controllers.ComputeController;
import Models.Clientes;
import java.util.*;
import javax.swing.table.DefaultTableModel;

public class ListaClientesFrom extends javax.swing.JFrame {
    private ComputeController computeController;

    
    public ListaClientesFrom(ComputeController computeController) {
        initComponents();
        this.computeController = computeController;
        
         // Obtener la lista de clientes
           List<Clientes> clientes = computeController.getClientesFromDB();
           populateTable(clientes);
    }
    
    private void populateTable(List<Clientes> clientes) {
        String[] columnNames = {"Rut", "nombre", "direccion", "comuna", "correo", "telefono"};
        Object[][] data = new Object[clientes.size()][columnNames.length];

        for (int i = 0; i < clientes.size(); i++) {
            Clientes cliente = clientes.get(i);
            data[i][0] = cliente.getRut();
            data[i][1] = cliente.getNombre();
            data[i][2] = cliente.getDireccion();
            data[i][3] = cliente.getComuna();
            data[i][4] = cliente.getCorreo();
            data[i][5] = cliente.getTelefono();
        }

        // Configurar el modelo de la tabla
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        jTable1.setModel(model);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Computec");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 534, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
