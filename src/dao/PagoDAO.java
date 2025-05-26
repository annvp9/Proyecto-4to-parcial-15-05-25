package dao;

import models.Pago;
import utils.ConexionDB;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PagoDAO {


    public static boolean insertarPago(Pago pago) {

        try (Connection connection = ConexionDB.getConexion()) {


            String sql = "INSERT INTO pagos (id_reserva, monto, metodo_pago, tipo_estacionamiento, fecha_pago) VALUES (?, ?, ?, ?, ?)";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, pago.getIdReserva());
                ps.setDouble(2, pago.getMonto());
                ps.setString(3, pago.getMetodoPago());
                ps.setString(4, pago.getTipoEstacionamiento());
                ps.setString(5, pago.getFechaPago());

                int rowsAffected = ps.executeUpdate();
                return rowsAffected > 0;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static List<Pago> obtenerTodos() {
        List<Pago> pagos = new ArrayList<>();
        String sql = "SELECT * FROM pagos";

        try (Connection connection = ConexionDB.getConexion();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int idPago = rs.getInt("id");
                int idReserva = rs.getInt("id_reserva");
                double monto = rs.getDouble("monto");
                String metodoPago = rs.getString("metodo_pago");
                String tipoEstacionamiento = rs.getString("tipo_estacionamiento");
                Date fechaPago = rs.getDate("fecha_pago");

                double horasEstacionadas = 0;
                Pago pago = new Pago(metodoPago, tipoEstacionamiento);
                pagos.add(pago);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pagos;
    }

}
