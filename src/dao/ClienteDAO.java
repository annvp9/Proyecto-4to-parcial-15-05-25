package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import models.Cliente;
import utils.ConexionDB;
import utils.HashUtil;

public class ClienteDAO {


    public static boolean registrarCliente(Cliente cliente) throws Exception {

        String contraseñaHasheada = HashUtil.hashPassword(cliente.getContraseña());

        Connection conn = ConexionDB.getConexion();
        String sql = "INSERT INTO clientes (nombre, apellido, correo_electronico, telefono, direccion, contraseña) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);


        stmt.setString(1, cliente.getNombre());
        stmt.setString(2, cliente.getApellido());
        stmt.setString(3, cliente.getCorreoElectronico());
        stmt.setString(4, cliente.getTelefono());
        stmt.setString(5, cliente.getDireccion());
        stmt.setString(6, contraseñaHasheada);

        int rowsAffected = stmt.executeUpdate();

        stmt.close();
        conn.close();

        return rowsAffected > 0;
    }

    public static List<Cliente> obtenerTodos() throws Exception {
        List<Cliente> clientes = new ArrayList<>();
        Connection conn = ConexionDB.getConexion();
        String sql = "SELECT nombre, apellido, correo_electronico, telefono, direccion FROM clientes";
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Cliente c = new Cliente(
                    rs.getString("nombre"),
                    rs.getString("apellido"),
                    rs.getString("correo_electronico"),
                    rs.getString("telefono"),
                    rs.getString("direccion"),
                    ""
            );
            clientes.add(c);
        }

        rs.close();
        stmt.close();
        conn.close();

        return clientes;
    }
}


