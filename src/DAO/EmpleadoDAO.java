package DAO;

import Models.Empleado;
import util.ConexionBD;
import util.SHA1Util;

import java.sql.*;

public class EmpleadoDAO {
    public Empleado validarLogin(String correo, String password) {
        String sql = "SELECT * FROM empleados WHERE correo_electronico = ? AND password = ?";
        try (PreparedStatement stmt = ConexionBD.getInstancia().prepareStatement(sql)) {
            stmt.setString(1, correo);
            stmt.setString(2, SHA1Util.encrypt(password));
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Empleado(
                        rs.getInt("id_empleado"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("correo_electronico"),
                        rs.getString("cargo"),
                        rs.getString("telefono")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

