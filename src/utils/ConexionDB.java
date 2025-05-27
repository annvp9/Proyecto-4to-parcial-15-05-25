package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {
    private static final String URL = "jdbc:mysql://localhost:3306/estacionamiento?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String USER = "personal";
    private static final String PASSWORD = "admin123";

    private static Connection conexion;

    private ConexionDB() {
    }

    public static Connection getConexion() throws SQLException {
        if (conexion == null || conexion.isClosed()) {
            try {
                conexion = DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (SQLException e) {
                e.printStackTrace();
                throw new SQLException("No se pudo conectar a la base de datos", e);
            }
        }
        return conexion;
    }
}
