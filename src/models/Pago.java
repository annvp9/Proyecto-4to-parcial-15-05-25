package models;

public class Pago {
    private int idPago;
    private int idReserva;
    private double monto;
    private String metodoPago;
    private String tipoEstacionamiento;
    private String fechaPago;

    public Pago(String metodoPago, String tipoEstacionamiento) {
        this.idPago = idPago;
        this.idReserva = idReserva;
        this.monto = this.monto;
        this.metodoPago = metodoPago;
        this.tipoEstacionamiento = tipoEstacionamiento;
        this.fechaPago = fechaPago;
    }

    public Pago(String tipoEstacionamiento, double horasEstacionadas, String metodoPago) {
    }

    // Getters
    public int getIdPago() {
        return idPago;
    }

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

    public String getFechaPago() {
        return fechaPago;
    }
}


