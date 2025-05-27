package models;

public class Cliente {
    private String nombre;
    private String apellido;
    private String correoElectronico;
    private String telefono;
    private String direccion;
    private String contraseña;

    public Cliente(String nombre, String apellido, String correoElectronico, String telefono, String direccion, String contraseña) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correoElectronico = correoElectronico;
        this.telefono = telefono;
        this.direccion = direccion;
        this.contraseña = contraseña;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getDireccion() {
        return direccion;
    }
}