package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import models.Cliente;
import utils.ConexionDB;

public class ClienteDAO {



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
                    rs.getString("direccion")
            );
            clientes.add(c);
        }

        rs.close();
        stmt.close();
        conn.close();

        return clientes;
    }
}

