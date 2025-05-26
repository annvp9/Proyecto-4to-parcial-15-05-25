package models;

import java.time.LocalDate;

public class Pago {
    private int idReserva;
    private double monto;
    private String metodoPago;
    private String tipoEstacionamiento;
    private LocalDate fechaPago;

    public Pago(int idReserva, double monto, String metodoPago, String tipoEstacionamiento, LocalDate fechaPago) {
        this.idReserva = idReserva;
        this.monto = monto;
        this.metodoPago = metodoPago;
        this.tipoEstacionamiento = tipoEstacionamiento;
        this.fechaPago = fechaPago;
    }

    // Getters

    public int getIdReserva() {
        return idReserva;
    }

    public double getMonto() {
        return monto;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public String getTipoEstacionamiento() {
        return tipoEstacionamiento;
    }

    public LocalDate getFechaPago() {
        return fechaPago;
    }

    // Setters (opcional)

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public void setTipoEstacionamiento(String tipoEstacionamiento) {
        this.tipoEstacionamiento = tipoEstacionamiento;
    }

    public void setFechaPago(LocalDate fechaPago) {
        this.fechaPago = fechaPago;
    }
}
