
package Controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/computecbd";
    private static final String USER = "root";  
    private static final String PASSWORD = "";
    
    // Variable de conexión
    private Connection connection;
    
    // Instancia única de la clase (Singleton)
    private static DatabaseConnection instance;

    // Constructor: establece la conexión al instanciar la clase
    public DatabaseConnection() {
        conectar();
    }

    // Método para establecer la conexión
    private void conectar() {
        try {
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                connection.setAutoCommit(false);  // Desactiva autocommit por defecto
                System.out.println("Conexion establecida con exito.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al establecer la conexión con la base de datos: " + e.getMessage());
        }
    }

    // Método para obtener la conexión
    public Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                conectar();  // Reconectar automáticamente si la conexión está cerrada
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al verificar o restablecer la conexión: " + e.getMessage());
        }
        return connection;
    }

    // Método para cerrar la conexión
    public void desconectar() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Conexion cerrada con exito.");
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Error al cerrar la conexion: " + e.getMessage());
            }
        }
    }

    // Método para confirmar la transacción
    public void commit() {
        try {
            if (connection != null && !connection.getAutoCommit()) {
                connection.commit();
                System.out.println("Transaccion confirmada.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al confirmar la transaccion: " + e.getMessage());
        }
    }

    // Método para revertir la transacción
    public void rollback() {
        try {
            if (connection != null && !connection.getAutoCommit()) {
                connection.rollback();
                System.out.println("Transaccion revertida.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al revertir la transaccion: " + e.getMessage());
        }
    }
    
    // Método para obtener la instancia única de la clase
    public static DatabaseConnection getInstance() {
        if (instance == null) {
            synchronized (DatabaseConnection.class) {
                if (instance == null) {
                    instance = new DatabaseConnection();
                }
            }
        }
        return instance;
    }
    
}
