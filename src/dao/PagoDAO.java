package dao;

import models.Pago;
import utils.ConexionDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PagoDAO {

    public static boolean insertarPago(Pago pago) {
        String sql = "INSERT INTO pagos (id_reserva, monto, metodo_pago, tipo_estacionamiento, fecha_pago) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = ConexionDB.getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, pago.getIdReserva());
            stmt.setDouble(2, pago.getMonto());
            stmt.setString(3, pago.getMetodoPago());
            stmt.setString(4, pago.getTipoEstacionamiento());
            stmt.setDate(5, Date.valueOf(pago.getFechaPago())); // convertir LocalDate a java.sql.Date

            int filas = stmt.executeUpdate();
            return filas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static List<Pago> obtenerTodos() {
        List<Pago> pagos = new ArrayList<>();
        String sql = "SELECT id_reserva, monto, metodo_pago, tipo_estacionamiento, fecha_pago FROM pagos";
        try (Connection conn = ConexionDB.getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Pago pago = new Pago(
                        rs.getInt("id_reserva"),
                        rs.getDouble("monto"),
                        rs.getString("metodo_pago"),
                        rs.getString("tipo_estacionamiento"),
                        rs.getDate("fecha_pago").toLocalDate()
                );
                pagos.add(pago);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pagos;
    }
}
