package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionBD {
    private static Connection conn;

    public static Connection getInstancia() {
        if (conn == null) {
            try {
                conn = DriverManager.getConnection("b");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return conn;
    }
}
