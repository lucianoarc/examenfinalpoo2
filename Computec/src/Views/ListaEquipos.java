
package Views;

import Controllers.ComputeController;
import Models.*;
import java.util.*;
import java.util.stream.Collectors;
import javax.swing.table.DefaultTableModel;

public class ListaEquipos extends javax.swing.JFrame {
    private ComputeController computeController;

  
    public ListaEquipos(ComputeController computeController) {
        initComponents();
        this.computeController = computeController;
        
        // Obtener los equipos de la base de datos
        List<Equipo> equipos = computeController.getEquiposFromDB();

        // Poblar ambas tablas
        populateTableEscritorios(equipos);
        populateTableNotebooks(equipos);
    }
    
    private void populateTableEscritorios(List<Equipo> equipos) {
    String[] columnNames = {"Modelo", "CPU", "Disco Duro", "RAM", "Precio", "Placa Madre", "Fuente Poder"};
    List<Computador_Escritorio> escritorios = equipos.stream()
        .filter(e -> e instanceof Computador_Escritorio)
        .map(e -> (Computador_Escritorio) e)
        .collect(Collectors.toList());

    Object[][] data = new Object[escritorios.size()][columnNames.length];
    for (int i = 0; i < escritorios.size(); i++) {
        Computador_Escritorio escritorio = escritorios.get(i);
        data[i][0] = escritorio.getModelo();
        data[i][1] = escritorio.getCpu();
        data[i][2] = escritorio.getDisco_duro();
        data[i][3] = escritorio.getRam();
        data[i][4] = escritorio.getPrecio();
        data[i][5] = escritorio.getPlaca_madre();
        data[i][6] = escritorio.getFuente_poder();
    }

    // Configurar el modelo de la tabla
    DefaultTableModel model = new DefaultTableModel(data, columnNames);
    jTable1.setModel(model); // jTableEscritorios es la tabla donde mostrarás los escritorios
}

private void populateTableNotebooks(List<Equipo> equipos) {
    String[] columnNames = {"Modelo", "CPU", "Disco Duro", "RAM", "Precio", "Pantalla", "USB", "Touch"};
    List<Notebook> notebooks = equipos.stream()
        .filter(e -> e instanceof Notebook)
        .map(e -> (Notebook) e)
        .collect(Collectors.toList());

    Object[][] data = new Object[notebooks.size()][columnNames.length];
    for (int i = 0; i < notebooks.size(); i++) {
        Notebook notebook = notebooks.get(i);
        data[i][0] = notebook.getModelo();
        data[i][1] = notebook.getCpu();
        data[i][2] = notebook.getDisco_duro();
        data[i][3] = notebook.getRam();
        data[i][4] = notebook.getPrecio();
        data[i][5] = notebook.getPantalla();
        data[i][6] = notebook.getUsb();
        data[i][7] = notebook.isTouch();
    }

    // Configurar el modelo de la tabla
    DefaultTableModel model = new DefaultTableModel(data, columnNames);
    jTable2.setModel(model); // jTableNotebooks es la tabla donde mostrarás los notebooks
}


  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

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

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
