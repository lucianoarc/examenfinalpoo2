
package Controllers;

import Models.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

public class ComputeController {
    private List<Clientes> clientes;
    private DatabaseConnection databaseConnection;

    public ComputeController() {
        clientes = new ArrayList<>();
        databaseConnection = new DatabaseConnection();
    }
    
    // Obtener todos los clientes de la base de datos
    public List<Clientes> getClientesFromDB() {
        List<Clientes> clientes = new ArrayList<>();
        String query = "SELECT * FROM clientes";
        
        try (Connection connection = databaseConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                String rut = resultSet.getString("rut");
                String nombre = resultSet.getString("nombre");
                String direccion = resultSet.getString("direccion");
                String comuna = resultSet.getString("comuna");
                String correo = resultSet.getString("correo");
                int telefono = resultSet.getInt("telefono");
                Clientes cliente = new Clientes(rut, nombre, direccion, comuna, correo, telefono);
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al obtener los clientes de la base de datos: " + e.getMessage());
        }
        return clientes;
    }
    
    public Clientes buscarClientePorRut(String rut) {
    Clientes cliente = null;
    String query = "SELECT * FROM clientes WHERE rut = ?";
    
    try (Connection connection = databaseConnection.getConnection();
         PreparedStatement preparedStatement = connection.prepareStatement(query)) {
         
        preparedStatement.setString(1, rut);
        
        try (ResultSet resultSet = preparedStatement.executeQuery()) {
            if (resultSet.next()) {
                String nombre = resultSet.getString("nombre");
                String direccion = resultSet.getString("direccion");
                String comuna = resultSet.getString("comuna");
                String correo = resultSet.getString("correo");
                int telefono = resultSet.getInt("telefono");
                cliente = new Clientes(rut, nombre, direccion, comuna, correo, telefono);
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("Error al buscar el cliente: " + e.getMessage());
    }
    return cliente;
}

    // Agregar un nuevo cliente a la base de datos
    public void addCliente(Clientes cliente) throws SQLException {
        String sql = "INSERT INTO clientes (rut, nombre, direccion, comuna, correo, telefono) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            connection.setAutoCommit(false); // Iniciar transacción

            pstmt.setString(1, cliente.getRut());
            pstmt.setString(2, cliente.getNombre());
            pstmt.setString(3, cliente.getDireccion());
            pstmt.setString(4, cliente.getComuna());
            pstmt.setString(5, cliente.getCorreo());
            pstmt.setInt(6, cliente.getTelefono());
            pstmt.executeUpdate();
            
            databaseConnection.commit(); // Confirmar transacción 
            System.out.println("Cliente agregado con exito.");
    }    catch (SQLException e) {
            databaseConnection.rollback(); // Revertir transacción en caso de error
            e.printStackTrace();
            System.out.println("Error al insertar el cliente en la base de datos: " + e.getMessage());
         }
    }
    
    
     // Actualizar un cliente existente
    public boolean actualizarCliente(Clientes cliente) {
    String sql = "UPDATE clientes SET nombre = ?, direccion = ?, comuna = ?, correo = ?, telefono = ? WHERE rut = ?";
    boolean updated = false;
    Connection connection = null; // Declaramos la conexión aquí para el manejo en finally

    try {
        connection = databaseConnection.getConnection();
        connection.setAutoCommit(false); // Iniciar transacción

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, cliente.getNombre());
            statement.setString(2, cliente.getDireccion());
            statement.setString(3, cliente.getComuna());
            statement.setString(4, cliente.getCorreo());
            statement.setInt(5, cliente.getTelefono());
            statement.setString(6, cliente.getRut());

            int rowsAffected = statement.executeUpdate();
            updated = (rowsAffected > 0); // Retorna true si se actualizó al menos una fila

            if (updated) {
                connection.commit(); // Confirmar transacción solo si hubo éxito
                System.out.println("Cliente actualizado con exito.");
            } else {
                connection.rollback(); // Revierte la transacción si no se encontró el cliente
                System.out.println("No se encontro el cliente con RUT: " + cliente.getRut());
            }
        } catch (SQLException e) {
            connection.rollback(); // Revertir transacción en caso de error
            System.err.println("Error al actualizar al cliente: " + e.getMessage());
        }
    } catch (SQLException e) {
        System.err.println("Error al establecer la conexion: " + e.getMessage());
    } finally {
        if (connection != null) {
            try {
                connection.close(); // Asegúrate de cerrar la conexión
            } catch (SQLException closeEx) {
                System.err.println("Error al cerrar la conexion: " + closeEx.getMessage());
            }
        }
    }

    return updated; // Retorna el estado de la operación
    }
    
     // Eliminar un cliente
    public boolean eliminarCliente(String rut) {
        String sql = "DELETE FROM clientes WHERE rut = ?";
        Connection connection = null; // Declaramos la conexión aquí para el manejo en finally
    try {
        connection = databaseConnection.getConnection();
        connection.setAutoCommit(false); // Iniciar transacción

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, rut);
            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                connection.commit(); // Confirmar transacción solo si hubo éxito
                System.out.println("Cliente eliminado con exito.");
                return true;
            } else {
                connection.rollback(); // Revierte la transacción si no se encontró la película
                System.out.println("No se encontro el cliente con este rut.");
                return false;
            }
        }
    } catch (SQLException e) {
        if (connection != null) {
            try {
                connection.rollback(); // Revertir transacción en caso de error
            } catch (SQLException rollbackEx) {
                System.err.println("Error al revertir la transaccion: " + rollbackEx.getMessage());
            }
        }
        System.err.println("Error al eliminar al cliente de la base de datos: " + e.getMessage());
    } finally {
        if (connection != null) {
            try {
                connection.close(); // Asegúrate de cerrar la conexión
            } catch (SQLException closeEx) {
                System.err.println("Error al cerrar la conexion: " + closeEx.getMessage());
            }
        }
    }
    return false; // Retorna false si hubo un error o si no se eliminó la película
        
    }
    
     public boolean registrarVenta(String rut, String modelo) {
    Connection connection = null;
    PreparedStatement psCheck = null;
    PreparedStatement psInsert = null;
    
    try {
        connection = databaseConnection.getConnection();
        connection.setAutoCommit(false); // Inicia la transacción
        
        // Verificar si el equipo ya ha sido vendido
        String sqlCheck = "SELECT COUNT(*) FROM ventas WHERE modelo = ?";
        psCheck = connection.prepareStatement(sqlCheck);
        psCheck.setString(1, modelo);
        ResultSet rs = psCheck.executeQuery();

        if (rs.next() && rs.getInt(1) > 0) {
            JOptionPane.showMessageDialog(null, "El producto ya está vendido.");
            return false;
        }

        // Inserción de la venta
        String sqlInsert = "INSERT INTO ventas (rut, modelo, fecha) VALUES (?, ?, ?)";
        psInsert = connection.prepareStatement(sqlInsert);
        psInsert.setString(1, rut);
        psInsert.setString(2, modelo);
        psInsert.setDate(3, new java.sql.Date(System.currentTimeMillis())); // Fecha actual

        int filasAfectadas = psInsert.executeUpdate();

        if (filasAfectadas > 0) {
            connection.commit(); // Confirmar transacción
            return true; // Venta registrada exitosamente
        } else {
            connection.rollback(); // Revierte la transacción
            return false; // No se registró la venta
        }
    } catch (SQLException e) {
        e.printStackTrace(); // Para depuración
        if (connection != null) {
            try {
                connection.rollback(); // Revertir en caso de error
            } catch (SQLException rollbackEx) {
                rollbackEx.printStackTrace();
            }
        }
        return false; // Error al registrar la venta
    } finally {
        try {
            if (psCheck != null) psCheck.close(); // Cerrar PreparedStatement
            if (psInsert != null) psInsert.close(); // Cerrar PreparedStatement
            if (connection != null) {
                connection.setAutoCommit(true); // Restaura el modo de auto-commit
                connection.close(); // Cierra la conexión
            }
        } catch (SQLException closeEx) {
            closeEx.printStackTrace(); // Maneja el error al cerrar
        }
    }
}
     // Registrar un equipo 
    public void agregarEquipo(Equipo equipo) throws SQLException {
    String sql;

    if (equipo instanceof Computador_Escritorio) {
        sql = "INSERT INTO computador_escritorio (modelo, cpu, disco_duro, ram, precio, placa_madre, fuente_poder) VALUES (?, ?, ?, ?, ?, ?, ?)";
    } else if (equipo instanceof Notebook) {
        sql = "INSERT INTO notebook (modelo, cpu, disco_duro, ram, precio, pantalla, usb, touch) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    } else {
        throw new IllegalArgumentException("Tipo de equipo no soportado");
    }

    Connection connection = null; // Declaramos la conexión aquí para el manejo en finally
    try {
        connection = databaseConnection.getConnection();
        connection.setAutoCommit(false); // Iniciar transacción

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, equipo.getModelo());
            pstmt.setString(2, equipo.getCpu());
            pstmt.setString(3, equipo.getDisco_duro());
            pstmt.setString(4, equipo.getRam());
            pstmt.setDouble(5, equipo.getPrecio());

            if (equipo instanceof Computador_Escritorio) {
                Computador_Escritorio escritorio = (Computador_Escritorio) equipo;
                pstmt.setString(6, escritorio.getPlaca_madre());
                pstmt.setString(7, escritorio.getFuente_poder());
            } else if (equipo instanceof Notebook) {
                Notebook notebook = (Notebook) equipo;
                pstmt.setString(6, notebook.getPantalla());
                pstmt.setString(7, notebook.getUsb());
                pstmt.setBoolean(8, notebook.isTouch());
            }

            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                connection.commit(); // Confirmar transacción solo si hubo éxito
                System.out.println("Equipo agregado con exito.");
            } else {
                connection.rollback(); // Revierte la transacción si no se insertó el equipo
                System.out.println("No se pudo agregar el equipo.");
            }
        }
    } catch (SQLException e) {
        if (connection != null) {
            try {
                connection.rollback(); // Revertir transacción en caso de error
            } catch (SQLException rollbackEx) {
                System.err.println("Error al revertir la transaccion: " + rollbackEx.getMessage());
            }
        }
        System.err.println("Error al agregar el equipo a la base de datos: " + e.getMessage());
    } finally {
        if (connection != null) {
            try {
                connection.close(); // Asegúrate de cerrar la conexión
            } catch (SQLException closeEx) {
                System.err.println("Error al cerrar la conexion: " + closeEx.getMessage());
            }
        }
    }
}
     //Actualizar un equipo existente
    public boolean actualizarEquipo(Equipo equipo) throws SQLException {
     String sql;

    if (equipo instanceof Computador_Escritorio) {
        sql = "UPDATE computador_escritorio SET cpu = ?, disco_duro = ?, ram = ?, precio = ?, placa_madre = ?, fuente_poder = ? WHERE modelo = ?";
    } else if (equipo instanceof Notebook) {
        sql = "UPDATE notebook SET cpu = ?, disco_duro = ?, ram = ?, precio = ?, pantalla = ?, usb = ?, touch = ? WHERE modelo = ?";
    } else {
        throw new IllegalArgumentException("Tipo de equipo no soportado");
    }

    Connection connection = null; // Declaramos la conexión aquí para el manejo en finally
    try {
        connection = databaseConnection.getConnection();
        connection.setAutoCommit(false); // Iniciar transacción

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, equipo.getCpu());
            pstmt.setString(2, equipo.getDisco_duro());
            pstmt.setString(3, equipo.getRam());
            pstmt.setDouble(4, equipo.getPrecio());

            if (equipo instanceof Computador_Escritorio) {
                Computador_Escritorio escritorio = (Computador_Escritorio) equipo;
                pstmt.setString(5, escritorio.getPlaca_madre());
                pstmt.setString(6, escritorio.getFuente_poder());
                pstmt.setString(7, equipo.getModelo());
            } else if (equipo instanceof Notebook) {
                Notebook notebook = (Notebook) equipo;
                pstmt.setString(5, notebook.getPantalla());
                pstmt.setString(6, notebook.getUsb());
                pstmt.setBoolean(7, notebook.isTouch());
                pstmt.setString(8, equipo.getModelo());
            }

            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                connection.commit(); // Confirmar transacción solo si hubo éxito
                System.out.println("Equipo actualizado con éxito.");
                return true; // Retorna true si se actualizó
            } else {
                connection.rollback(); // Revierte la transacción si no se actualizó el equipo
                System.out.println("No se pudo actualizar el equipo.");
                return false;
            }
        }
    } catch (SQLException e) {
        if (connection != null) {
            try {
                connection.rollback(); // Revertir transacción en caso de error
            } catch (SQLException rollbackEx) {
                System.err.println("Error al revertir la transacción: " + rollbackEx.getMessage());
            }
        }
        System.err.println("Error al actualizar el equipo en la base de datos: " + e.getMessage());
        return false;
    } finally {
        if (connection != null) {
            try {
                connection.close(); // Asegúrate de cerrar la conexión
            } catch (SQLException closeEx) {
                System.err.println("Error al cerrar la conexión: " + closeEx.getMessage());
            }
        }
    }
}
   // Eliminar un equipo
    public boolean eliminarEquipo(String modelo) throws SQLException {
        String sqlDeleteComputador = "DELETE FROM computador_escritorio WHERE modelo = ?";
    String sqlDeleteNotebook = "DELETE FROM notebook WHERE modelo = ?";

    Connection connection = null; // Declaramos la conexión aquí para el manejo en finally
    try {
        connection = databaseConnection.getConnection();
        connection.setAutoCommit(false); // Iniciar transacción

        // Ejecutar la primera eliminación
        try (PreparedStatement pstmt1 = connection.prepareStatement(sqlDeleteComputador)) {
            pstmt1.setString(1, modelo);
            pstmt1.executeUpdate();
        }

        // Ejecutar la segunda eliminación
        try (PreparedStatement pstmt2 = connection.prepareStatement(sqlDeleteNotebook)) {
            pstmt2.setString(1, modelo);
            pstmt2.executeUpdate();
        }

        connection.commit(); // Confirmar transacción solo si ambos DELETEs fueron exitosos
        System.out.println("Equipo eliminado con exito.");
        return true; // Retorna true si se eliminó
    } catch (SQLException e) {
        if (connection != null) {
            try {
                connection.rollback(); // Revertir transacción en caso de error
            } catch (SQLException rollbackEx) {
                System.err.println("Error al revertir la transaccion: " + rollbackEx.getMessage());
            }
        }
        System.err.println("Error al eliminar el equipo de la base de datos: " + e.getMessage());
        return false; // Retorna false en caso de error
    } finally {
        if (connection != null) {
            try {
                connection.close(); // Asegúrate de cerrar la conexión
            } catch (SQLException closeEx) {
                System.err.println("Error al cerrar la conexion: " + closeEx.getMessage());
                }
            }
        }
    }
    
    public List<Equipo> getEquiposFromDB() {
    List<Equipo> equipos = new ArrayList<>();

    // Consultas SQL para obtener los datos de ambas tablas
    String queryEscritorio = "SELECT * FROM computador_escritorio";
    String queryNotebook = "SELECT * FROM notebook";
    
    try (Connection connection = databaseConnection.getConnection();
         Statement statement1 = connection.createStatement();
         Statement statement2 = connection.createStatement();
         ResultSet resultSet1 = statement1.executeQuery(queryEscritorio);
         ResultSet resultSet2 = statement2.executeQuery(queryNotebook)) {

        // Obtener los equipos tipo Computador_Escritorio
        while (resultSet1.next()) {
            String modelo = resultSet1.getString("modelo");
            String cpu = resultSet1.getString("cpu");
            String discoDuro = resultSet1.getString("disco_duro");
            String ram = resultSet1.getString("ram");
            int precio = resultSet1.getInt("precio");
            String placaMadre = resultSet1.getString("placa_madre");
            String fuentePoder = resultSet1.getString("fuente_poder");

            Computador_Escritorio escritorio = new Computador_Escritorio(placaMadre, fuentePoder, modelo, cpu, discoDuro, ram, precio);
            equipos.add(escritorio);
        }

        // Obtener los equipos tipo Notebook
        while (resultSet2.next()) {
            String modelo = resultSet2.getString("modelo");
            String cpu = resultSet2.getString("cpu");
            String discoDuro = resultSet2.getString("disco_duro");
            String ram = resultSet2.getString("ram");
            int precio = resultSet2.getInt("precio");
            String pantalla = resultSet2.getString("pantalla");
            String usb = resultSet2.getString("usb");
            boolean touch = resultSet2.getBoolean("touch");

            Notebook notebook = new Notebook(pantalla, usb, touch, modelo, cpu, discoDuro, ram, precio);
            equipos.add(notebook);
        }
        
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("Error al obtener los equipos de la base de datos: " + e.getMessage());
    }

    return equipos; // Devuelve la lista de equipos
}
    
    public List<EquipoReport> generarReporteEquiposVendidos(String tipoEquipo) {
    List<EquipoReport> reportes = new ArrayList<>();
    String sql = "SELECT " +
                 "    c.nombre AS nombre_cliente, " +
                 "    c.telefono, " +
                 "    c.correo, " +
                 "    COALESCE(ce.modelo, n.modelo) AS modelo_equipo, " +
                 "    COALESCE(ce.precio, n.precio) AS precio, " +
                 "    v.fecha AS fecha_venta " +
                 "FROM " +
                 "    ventas v " +
                 "JOIN " +
                 "    clientes c ON v.rut = c.rut " +
                 "LEFT JOIN " +
                 "    computador_escritorio ce ON v.modelo = ce.modelo " +
                 "LEFT JOIN " +
                 "    notebook n ON v.modelo = n.modelo " +
                 "WHERE " +
                 "    ce.modelo IS NOT NULL OR n.modelo IS NOT NULL";

    try (Connection connection = databaseConnection.getConnection()) {
        // Deshabilitar autocommit
        connection.setAutoCommit(false);
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String nombreCliente = resultSet.getString("nombre_cliente");
                String telefono = resultSet.getString("telefono");
                String correo = resultSet.getString("correo");
                String modeloEquipo = resultSet.getString("modelo_equipo");
                double precio = resultSet.getDouble("precio");
                Date fechaVenta = resultSet.getDate("fecha_venta");

                // Imprime los datos para depuración
                System.out.println("Nombre Cliente: " + nombreCliente);
                System.out.println("Teléfono: " + telefono);
                System.out.println("Correo: " + correo);
                System.out.println("Modelo Equipo: " + modeloEquipo);
                System.out.println("Precio: " + precio);
                System.out.println("Fecha Venta: " + fechaVenta);

                reportes.add(new EquipoReport(nombreCliente, telefono, correo, modeloEquipo, precio, fechaVenta));
            }
            
            // Confirmar transacción
            connection.commit();
        } catch (SQLException e) {
            // Revertir transacción en caso de error
            connection.rollback();
            e.printStackTrace();
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return reportes;
}
    
    public Tuple<Integer, Double> obtenerVentasTotales() {
        int cantidadVentas = 0;
        double montoTotal = 0.0;

        String sql = "SELECT COUNT(*) AS cantidad_ventas, SUM(COALESCE(ce.precio, n.precio)) AS monto_total " +
                     "FROM ventas v " +
                     "JOIN clientes c ON v.rut = c.rut " +
                     "LEFT JOIN computador_escritorio ce ON v.modelo = ce.modelo " +
                     "LEFT JOIN notebook n ON v.modelo = n.modelo";

        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            if (resultSet.next()) {
                cantidadVentas = resultSet.getInt("cantidad_ventas");
                montoTotal = resultSet.getDouble("monto_total");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return new Tuple<>(cantidadVentas, montoTotal);
    }
    
}
