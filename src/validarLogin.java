import util.ConexionBD;
import util.SHA1Util;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public boolean validarLogin(String usuario, String passwordIngresada) {
    String sql = "SELECT * FROM empleados WHERE correo_electronico = ?";
    try (PreparedStatement stmt = ConexionBD.getInstancia().prepareStatement(sql)) {
        stmt.setString(1, usuario);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            String passGuardada = ((ResultSet) rs).getString("password");
            return passGuardada.equals(SHA1Util.encrypt(passwordIngresada));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return false;
}
