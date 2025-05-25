package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import models.Pago;
import utils.ConexionDB;

public class PagoDAO {

    public static List<Pago> obtenerTodos() throws Exception {
        List<Pago> pagos = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = ConexionDB.getConexion();
            String sql = "SELECT id_pago, id_reserva, monto, metodo_pago, fecha_pago FROM pagos";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Pago p = new Pago(
                        rs.getInt("id_pago"),
                        rs.getInt("id_reserva"),
                        rs.getDouble("monto"),
                        rs.getString("metodo_pago"),
                        rs.getString("fecha_pago")
                );
                pagos.add(p);
            }
        } finally {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        }
        return pagos;
    }
}
