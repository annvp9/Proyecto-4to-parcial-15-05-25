package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import models.Reserva;
import utils.ConexionDB;

public class ReservaDAO {

    public static List<Reserva> obtenerTodos() throws Exception {
        List<Reserva> reservas = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = ConexionDB.getConexion();
            String sql = "SELECT id_reserva, id_cliente, id_espacio, fecha_inicio, fecha_fin FROM reservas";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Reserva r = new Reserva(
                        rs.getInt("id_reserva"),
                        rs.getInt("id_cliente"),
                        rs.getInt("id_espacio"),
                        rs.getString("fecha_inicio"),
                        rs.getString("fecha_fin")
                );
                reservas.add(r);
            }
        } finally {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        }
        return reservas;
    }
}

