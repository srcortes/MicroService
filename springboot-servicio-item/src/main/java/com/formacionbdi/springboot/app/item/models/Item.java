package com.formacionbdi.springboot.app.item.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Item {

    public Item() {
    }

    public Item(Producto producto, Integer cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    private Producto producto;
    private Integer cantidad;

    public Double getTotal() {
        return producto.getPrecio() * cantidad.doubleValue();
    }
}
