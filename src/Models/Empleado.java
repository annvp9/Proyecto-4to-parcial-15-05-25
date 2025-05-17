package Models;

public class Empleado {
    private int id;
    private String nombre, apellido, correo, cargo, telefono;

    public Empleado(int id, String nombre, String apellido, String correo, String cargo, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.cargo = cargo;
        this.telefono = telefono;
    }

    public String getNombre() { return nombre; }
    public String getCorreo() { return correo; }
}
