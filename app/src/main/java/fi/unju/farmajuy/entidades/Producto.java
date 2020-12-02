package fi.unju.farmajuy.entidades;

import java.io.Serializable;

public class Producto implements Serializable {

    private Integer producto_id;
    private String nombre;
    private String droga;
    private String descripcion;
    private String presentacion;
    private String foto;
    private Integer categoria_id;

    public Producto() {
    }

    public Producto(Integer producto_id, String nombre, String droga, String descripcion, String presentacion, String foto, Integer categoria_id) {
        this.producto_id = producto_id;
        this.nombre = nombre;
        this.droga = droga;
        this.descripcion = descripcion;
        this.presentacion = presentacion;
        this.foto = foto;
        this.categoria_id = categoria_id;
    }

    public Integer getProducto_id() {
        return producto_id;
    }

    public void setProducto_id(Integer producto_id) {
        this.producto_id = producto_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDroga() {
        return droga;
    }

    public void setDroga(String droga) {
        this.droga = droga;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Integer getCategoria_id() {
        return categoria_id;
    }

    public void setCategoria_id(Integer categoria_id) {
        this.categoria_id = categoria_id;
    }
}
