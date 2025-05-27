package dao;

import models.Pago;
import utils.ConexionDB;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PagoDAO {

    // Insertar pago
    public static boolean insertarPago(Pago pago) {
        String sql = "INSERT INTO pagos (id_reserva, monto, metodo_pago, fecha_pago) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConexionDB.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, pago.getIdReserva());
            ps.setBigDecimal(2, BigDecimal.valueOf(pago.getMonto()));
            ps.setString(3, pago.getMetodoPago());
            ps.setTimestamp(4, Timestamp.valueOf(pago.getFechaPago()));

            int filas = ps.executeUpdate();
            return filas > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Obtener lista de pagos
    public static List<Pago> obtenerPagos() {
        List<Pago> lista = new ArrayList<>();
        String sql = "SELECT id_pago, id_reserva, monto, metodo_pago, fecha_pago FROM pagos";
        try (Connection conn = ConexionDB.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Pago pago = new Pago(
                        rs.getInt("id_pago"),
                        rs.getInt("id_reserva"),
                        rs.getDouble("monto"),
                        rs.getString("metodo_pago"),
                        rs.getTimestamp("fecha_pago").toLocalDateTime()
                );
                lista.add(pago);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
}
