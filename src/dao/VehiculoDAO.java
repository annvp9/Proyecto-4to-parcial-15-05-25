package dao;

import models.Vehiculo;
import utils.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class VehiculoDAO {
    public static void insertarVehiculo(Vehiculo v) throws Exception {
        Connection conn = ConexionDB.getConexion();
        String sql = "INSERT INTO vehiculos(id_cliente, placa, marca, modelo, color, tipo) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, v.getIdCliente());
        stmt.setString(2, v.getPlaca());
        stmt.setString(3, v.getMarca());
        stmt.setString(4, v.getModelo());
        stmt.setString(5, v.getColor());
        stmt.setString(6, v.getTipo());
        stmt.executeUpdate();
    }
}
