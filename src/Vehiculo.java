import java.time.LocalDate;

public class Vehiculo {
    private int id, idCliente;
    private String placa, marca, modelo, color, tipo;
    private LocalDate fechaRegistro;

    public Vehiculo(int id, int idCliente, String placa, String marca, String modelo,
                    String color, String tipo, LocalDate fechaRegistro) {
        this.id = id;
        this.idCliente = idCliente;
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.tipo = tipo;
        this.fechaRegistro = fechaRegistro;
    }

    // Getters y setters
}

