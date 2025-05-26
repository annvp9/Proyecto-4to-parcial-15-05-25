package dao;

import models.Reserva;
import utils.ConexionDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReservaDAO {

    public static List<Reserva> obtenerTodos() throws Exception {
        List<Reserva> reservas = new ArrayList<>();
        String sql = "SELECT id_reserva, id_cliente, fecha_inicio, fecha_fin, estado FROM reservas";
        try (Connection conn = ConexionDB.getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Reserva r = new Reserva(
                        rs.getInt("id_reserva"),
                        rs.getInt("id_cliente"),
                        rs.getTimestamp("fecha_inicio").toLocalDateTime(),
                        rs.getTimestamp("fecha_fin").toLocalDateTime(),
                        rs.getString("estado")
                );
                reservas.add(r);
            }
        }
        return reservas;
    }

    public static boolean insertarReserva(Reserva reserva) throws Exception {
        String sql = "INSERT INTO reservas (id_cliente, fecha_inicio, fecha_fin, estado) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConexionDB.getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, reserva.getIdCliente());
            stmt.setTimestamp(2, Timestamp.valueOf(reserva.getFechaInicio()));
            stmt.setTimestamp(3, Timestamp.valueOf(reserva.getFechaFin()));
            stmt.setString(4, reserva.getEstado());

            int filas = stmt.executeUpdate();
            return filas > 0;
        }
    }

    public static boolean existeCliente(int idCliente) {
        String sql = "SELECT 1 FROM clientes WHERE id_cliente = ?";
        try (Connection conn = ConexionDB.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idCliente);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}

