package models;

import java.time.LocalDateTime;

public class Reserva {
    private int idReserva;
    private int idCliente;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
    private String estado;

    public Reserva(int idReserva, int idCliente, LocalDateTime fechaInicio, LocalDateTime fechaFin, String estado) {
        this.idReserva = idReserva;
        this.idCliente = idCliente;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estado = estado;
    }

    public int getIdReserva() { return idReserva; }
    public int getIdCliente() { return idCliente; }
    public LocalDateTime getFechaInicio() { return fechaInicio; }
    public LocalDateTime getFechaFin() { return fechaFin; }
    public String getEstado() { return estado; }
}
