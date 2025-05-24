package dao;

import models.Pago;
import utils.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class PagoDAO {
    public static void insertarPago(Pago p) throws Exception {
        Connection conn = ConexionDB.getConexion();
        String sql = "INSERT INTO pagos(id_reserva, monto, metodo_pago, fecha_pago) VALUES (?, ?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, p.getIdReserva());
        stmt.setDouble(2, p.getMonto());
        stmt.setString(3, p.getMetodoPago());
        stmt.setObject(4, p.getFechaPago());
        stmt.executeUpdate();
    }
}