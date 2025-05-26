package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import models.Vehiculo;
import utils.ConexionDB;

public class VehiculoDAO {

    // Método para obtener todos los vehículos
    public static List<Vehiculo> obtenerTodos() throws Exception {
        List<Vehiculo> vehiculos = new ArrayList<>();
        Connection conn = ConexionDB.getConexion();
        String sql = "SELECT * FROM vehiculos";
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Vehiculo v = new Vehiculo(
                    rs.getInt("id_cliente"),
                    rs.getString("placa"),
                    rs.getString("marca"),
                    rs.getString("modelo"),
                    rs.getString("color"),
                    rs.getString("tipo")
            );
            vehiculos.add(v);
        }

        rs.close();
        stmt.close();
        conn.close();

        return vehiculos;
    }

    // Método para insertar un vehículo
    public static boolean insertarVehiculo(Vehiculo v) throws Exception {
        Connection conn = ConexionDB.getConexion();
        String sql = "INSERT INTO vehiculos (id_cliente, placa, marca, modelo, color, tipo) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setInt(1, v.getIdCliente());
        stmt.setString(2, v.getPlaca());
        stmt.setString(3, v.getMarca());
        stmt.setString(4, v.getModelo());
        stmt.setString(5, v.getColor());
        stmt.setString(6, v.getTipo());

        int filas = stmt.executeUpdate();

        stmt.close();
        conn.close();

        return filas > 0;
    }
}
