package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import models.Vehiculo;
import utils.ConexionDB;

public class VehiculoDAO {

    public static List<Vehiculo> obtenerTodos() throws Exception {
        List<Vehiculo> vehiculos = new ArrayList<>();
        Connection conn = ConexionDB.getConexion();
        String sql = "SELECT id_cliente, placa, marca, modelo, color, tipo FROM vehiculos";
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

    public static void insertarVehiculo(Vehiculo v) {

    }
}
