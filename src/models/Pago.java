package models;

import java.time.LocalDateTime;

public class Pago {
    private int idReserva;
    private double monto;
    private String metodoPago;
    private LocalDateTime fechaPago;

    public Pago(int idReserva, double monto, String metodoPago, LocalDateTime fechaPago) {
        this.idReserva = idReserva;
        this.monto = monto;
        this.metodoPago = metodoPago;
        this.fechaPago = fechaPago;
    }

    public int getIdReserva() { return idReserva; }
    public double getMonto() { return monto; }
    public String getMetodoPago() { return metodoPago; }
    public LocalDateTime getFechaPago() { return fechaPago; }
}
