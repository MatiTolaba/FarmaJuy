package fi.unju.farmajuy.entidades;

import android.location.Location;

import java.io.Serializable;

public class Farmacia implements Serializable {
    private Integer farmacia_id;
    private String nombre;
    private String direccion;
    private String horario;
    private String telefono;
    private Double latitud;
    private Double longitud;
    private String foto;

    public Farmacia() {
    }

    public Farmacia(Integer farmacia_id, String nombre, String direccion, String horario, String telefono, Double latitud, Double longitud, String foto) {
        this.farmacia_id = farmacia_id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.horario = horario;
        this.telefono = telefono;
        this.latitud = latitud;
        this.longitud = longitud;
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

    public Double getLatitud() { return latitud; }

    public void setLatitud(Double latitud) { this.latitud = latitud; }

    public Double getLongitud() { return longitud; }

    public void setLongitud(Double longitud) { this.longitud = longitud; }

    public String getFoto() { return foto; }

    public void setFoto(String foto) { this.foto = foto; }
}
