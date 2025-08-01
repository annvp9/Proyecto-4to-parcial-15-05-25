package models;

import java.time.LocalDateTime;

public class Pago {
    private int idPago;            //autoincremental
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

    public Pago(int idPago, int idReserva, double monto, String metodoPago, LocalDateTime fechaPago) {
        this.idPago = idPago;
        this.idReserva = idReserva;
        this.monto = monto;
        this.metodoPago = metodoPago;
        this.fechaPago = fechaPago;
    }

    public int getIdPago() {
        return idPago;
    }

    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public LocalDateTime getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(LocalDateTime fechaPago) {
        this.fechaPago = fechaPago;
    }
}
