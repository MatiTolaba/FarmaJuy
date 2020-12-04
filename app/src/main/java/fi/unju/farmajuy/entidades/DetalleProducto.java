package fi.unju.farmajuy.entidades;

import java.io.Serializable;
import java.util.Date;

public class DetalleProducto implements Serializable {
    private Integer detalle_producto_id;
    private Integer farmacia_id;
    private Integer producto_id;
    private Double precio;
    private Date fecha_Vencimiento;
    private Integer stock;

    public DetalleProducto() {
    }

    public DetalleProducto(Integer detalle_producto_id, Integer farmacia_id, Integer producto_id, Double precio, Date fecha_Vencimiento, Integer stock) {
        this.detalle_producto_id = detalle_producto_id;
        this.farmacia_id = farmacia_id;
        this.producto_id = producto_id;
        this.precio = precio;
        this.fecha_Vencimiento = fecha_Vencimiento;
        this.stock = stock;
    }

    public Integer getDetalle_producto_id() {
        return detalle_producto_id;
    }

    public void setDetalle_producto_id(Integer detalle_producto_id) {
        this.detalle_producto_id = detalle_producto_id;
    }

    public Integer getFarmacia_id() {
        return farmacia_id;
    }

    public void setFarmacia_id(Integer farmacia_id) {
        this.farmacia_id = farmacia_id;
    }

    public Integer getProducto_id() {
        return producto_id;
    }

    public void setProducto_id(Integer producto_id) {
        this.producto_id = producto_id;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Date getFecha_Vencimiento() {
        return fecha_Vencimiento;
    }

    public void setFecha_Vencimiento(Date fecha_Vencimiento) {
        this.fecha_Vencimiento = fecha_Vencimiento;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
