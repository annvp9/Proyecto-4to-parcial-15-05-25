package dao;

import models.Cliente;
import utils.ConexionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ClienteDAO {
    public static void insertarCliente(Cliente cliente) throws Exception {
        Connection conn = ConexionDB.getConexion();
        String sql = "INSERT INTO clientes(nombre, apellido, correo_electronico, telefono, direccion) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, cliente.getNombre());
        stmt.setString(2, cliente.getApellido());
        stmt.setString(3, cliente.getCorreo());
        stmt.setString(4, cliente.getTelefono());
        stmt.setString(5, cliente.getDireccion());
        stmt.executeUpdate();
    }
}