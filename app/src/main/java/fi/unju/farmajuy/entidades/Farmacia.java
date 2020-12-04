package fi.unju.farmajuy.entidades;

import android.location.Location;

public class Farmacia {
    private Integer farmacia_id;
    private String nombre;
    private String direccion;
    private String horario;
    private String telefono;
    private Location ubicacion;
    private String foto;

    public Farmacia() {
    }

    public Farmacia(Integer farmacia_id, String nombre, String direccion, String horario, String telefono, Location ubicacion, String foto) {
        this.farmacia_id = farmacia_id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.horario = horario;
        this.telefono = telefono;
        this.ubicacion = ubicacion;
        this.foto = foto;
    }

    public Integer getFarmacia_id() {
        return farmacia_id;
    }

    public void setFarmacia_id(Integer farmacia_id) {
        this.farmacia_id = farmacia_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Location getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Location ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getFoto() { return foto; }

    public void setFoto(String foto) { this.foto = foto; }
}
