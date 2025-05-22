package dao;

import models.Reserva;
import utils.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class ReservaDAO {
    public static void insertarReserva(Reserva r) throws Exception {
        Connection conn = ConexionDB.getConexion();
        String sql = "INSERT INTO reservas(id_cliente, id_espacio, id_tarifa, fecha_inicio, fecha_fin, estado) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, r.getIdCliente());
        stmt.setInt(2, r.getIdEspacio());
        stmt.setInt(3, r.getIdTarifa());
        stmt.setObject(4, r.getFechaInicio());
        stmt.setObject(5, r.getFechaFin());
        stmt.setString(6, r.getEstado());
        stmt.executeUpdate();
    }
}
