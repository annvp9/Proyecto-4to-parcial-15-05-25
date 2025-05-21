package models;

public class Cliente {
    private int id;
    private String nombre;
    private String apellido;
    private String correo;
    private String telefono;
    private String direccion;

    public Cliente(String nombre, String apellido, String correo, String telefono, String direccion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public String getNombre() { return nombre; }
    public String getApellido() { return apellido; }
    public String getCorreo() { return correo; }
    public String getTelefono() { return telefono; }
    public String getDireccion() { return direccion; }
}
