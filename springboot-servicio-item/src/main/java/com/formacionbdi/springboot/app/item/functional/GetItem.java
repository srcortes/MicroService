package com.formacionbdi.springboot.app.item.functional;

import com.formacionbdi.springboot.app.item.models.Item;
import com.formacionbdi.springboot.app.item.models.Producto;


public interface GetItem{
    Item getItem(Producto producto, Integer cantidad);
}