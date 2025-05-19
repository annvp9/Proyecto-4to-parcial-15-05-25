import util.ConexionBD;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
    public void registrarCliente(Cliente c) {
        String sql = "INSERT INTO clientes (nombre, apellido, correo_electronico, telefono, direccion) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = ConexionBD.getInstancia().prepareStatement(sql)) {
            stmt.setString(1, c.getNombre());
            stmt.setString(2, c.getApellido());
            stmt.setString(3, c.getCorreo());
            stmt.setString(4, c.getTelefono());
            stmt.setString(5, c.getDireccion());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Cliente> obtenerTodos() {
        List<Cliente> lista = new ArrayList<>();
        try (Statement stmt = ConexionBD.getInstancia().createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM clientes")) {
            while (rs.next()) {
                lista.add(new Cliente(
                        rs.getInt("id_cliente"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("correo_electronico"),
                        rs.getString("telefono"),
                        rs.getString("direccion")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}

