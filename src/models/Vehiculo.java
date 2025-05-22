package models;

public class Vehiculo {
    private int id;
    private int idCliente;
    private String placa;
    private String marca;
    private String modelo;
    private String color;
    private String tipo;

    public Vehiculo(int idCliente, String placa, String marca, String modelo, String color, String tipo) {
        this.idCliente = idCliente;
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.tipo = tipo;
    }

    public int getIdCliente() { return idCliente; }
    public String getPlaca() { return placa; }
    public String getMarca() { return marca; }
    public String getModelo() { return modelo; }
    public String getColor() { return color; }
    public String getTipo() { return tipo; }
}

