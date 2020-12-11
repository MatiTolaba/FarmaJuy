package fi.unju.farmajuy.entidades;

public class Cliente {
    private String correo;
    private String nombre;
    private String telefono;
    private String contrasenia;

    public Cliente() {
    }

    public Cliente(Integer cliente_id, String nombre, String telefono, String correo, String contrasenia) {
        this.correo = correo;
        this.nombre = nombre;
        this.telefono = telefono;
        this.contrasenia = contrasenia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
}

