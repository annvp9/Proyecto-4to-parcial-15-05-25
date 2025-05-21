package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {
    private static Connection conexion;
    private static final String URL = "jdbc:mysql://localhost:3306/estacionamiento";
    private static final String USER = "root";
    private static final String PASSWORD = "salchichasfrias";

    private ConexionDB() {}

    public static Connection getConexion() throws SQLException {
        if (conexion == null || conexion.isClosed()) {
            conexion = DriverManager.getConnection(URL, USER, PASSWORD);
        }
        return conexion;
    }
}
