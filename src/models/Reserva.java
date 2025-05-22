package models;

import java.time.LocalDateTime;

public class Reserva {
    private int idCliente;
    private int idEspacio;
    private int idTarifa;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
    private String estado;

    public Reserva(int idCliente, int idEspacio, int idTarifa, LocalDateTime fechaInicio, LocalDateTime fechaFin, String estado) {
        this.idCliente = idCliente;
        this.idEspacio = idEspacio;
        this.idTarifa = idTarifa;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estado = estado;
    }

    public int getIdCliente() { return idCliente; }
    public int getIdEspacio() { return idEspacio; }
    public int getIdTarifa() { return idTarifa; }
    public LocalDateTime getFechaInicio() { return fechaInicio; }
    public LocalDateTime getFechaFin() { return fechaFin; }
    public String getEstado() { return estado; }
}