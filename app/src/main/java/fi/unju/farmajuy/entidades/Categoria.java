package fi.unju.farmajuy.entidades;

import java.io.Serializable;

public class Categoria implements Serializable {

    private Integer categoria_id;
    private String nombre;

    public Categoria() {
    }

    public Categoria(Integer categoria_id, String nombre) {
        this.categoria_id = categoria_id;
        this.nombre = nombre;
    }

    public Integer getCategoria_id() {
        return categoria_id;
    }

    public void setCategoria_id(Integer categoria_id) {
        this.categoria_id = categoria_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
