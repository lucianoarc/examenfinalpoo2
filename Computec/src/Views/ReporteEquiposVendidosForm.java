
package Views;

import Controllers.ComputeController;
import Models.EquipoReport;
import Models.Tuple;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ReporteEquiposVendidosForm extends javax.swing.JFrame {
    
    private ComputeController computeController;

 
    public ReporteEquiposVendidosForm(ComputeController computeController) {
        initComponents();
        this.computeController = computeController;
         // Llama al método para generar el reporte y mostrarlo en la tabla
        List<EquipoReport> reportes = computeController.generarReporteEquiposVendidos("tipoEquipo"); // Cambia "tipoEquipo" según sea necesario
        mostrarReporte(reportes);
    }

    private void mostrarReporte(List<EquipoReport> reportes) {
        String[] columnas = {"Nombre Cliente", "Teléfono", "Correo", "Modelo Equipo", "Precio", "Fecha Venta"};
        Object[][] datos = new Object[reportes.size()][6];

        for (int i = 0; i < reportes.size(); i++) {
            EquipoReport equipo = reportes.get(i);
            datos[i][0] = equipo.getNombreCliente();
            datos[i][1] = equipo.getTelefono();
            datos[i][2] = equipo.getCorreo();
            datos[i][3] = equipo.getModeloEquipo();
            datos[i][4] = equipo.getPrecio();
            datos[i][5] = equipo.getFechaVenta();
        }

        // Configurar el modelo de la tabla
        DefaultTableModel model = new DefaultTableModel(datos, columnas);
        jTable1.setModel(model);
        jTable1.setAutoResizeMode(jTable1.AUTO_RESIZE_ALL_COLUMNS); // Ajustar las columnas automáticamente
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

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

        jButton1.setText("Venta Totales");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(19, 19, 19))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addGap(0, 10, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       Tuple<Integer, Double> ventasTotales = computeController.obtenerVentasTotales();
    int cantidadVentas = ventasTotales.getX();
    double montoTotal = ventasTotales.getY();

    // Mostrar resultados (puedes usar JOptionPane o actualizar componentes en tu formulario)
    JOptionPane.showMessageDialog(this,
            "Cantidad de Ventas: " + cantidadVentas + "\n" +
            "Monto Total Recaudado: " + montoTotal);
    }//GEN-LAST:event_jButton1ActionPerformed

 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
