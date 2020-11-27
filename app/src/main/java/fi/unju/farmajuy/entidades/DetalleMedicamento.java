package fi.unju.farmajuy.entidades;

import java.util.Date;

public class DetalleMedicamento {
    private Integer detalle_medicamento_id;
    private Integer farmacia_id;
    private Integer medicamento_id;
    private Double precio;
    private Date fecha_Vencimiento;
    private Integer stock;

    public DetalleMedicamento() {
    }

    public DetalleMedicamento(Integer detalle_medicamento_id, Integer farmacia_id, Integer medicamento_id, Double precio, Date fecha_Vencimiento, Integer stock) {
        this.detalle_medicamento_id = detalle_medicamento_id;
        this.farmacia_id = farmacia_id;
        this.medicamento_id = medicamento_id;
        this.precio = precio;
        this.fecha_Vencimiento = fecha_Vencimiento;
        this.stock = stock;
    }

    public Integer getDetalle_medicamento_id() {
        return detalle_medicamento_id;
    }

    public void setDetalle_medicamento_id(Integer detalle_medicamento_id) {
        this.detalle_medicamento_id = detalle_medicamento_id;
    }

    public Integer getFarmacia_id() {
        return farmacia_id;
    }

    public void setFarmacia_id(Integer farmacia_id) {
        this.farmacia_id = farmacia_id;
    }

    public Integer getMedicamento_id() {
        return medicamento_id;
    }

    public void setMedicamento_id(Integer medicamento_id) {
        this.medicamento_id = medicamento_id;
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
