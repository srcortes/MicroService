package com.formacionbdi.springboot.app.item.controller;

import com.formacionbdi.springboot.app.item.models.Item;
import com.formacionbdi.springboot.app.item.models.Producto;
import com.formacionbdi.springboot.app.item.service.ItemService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import io.micrometer.core.annotation.Timed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Supplier;

@RestController
public class ItemController {

    private ItemService itemService;

    @Autowired
    public ItemController( @Qualifier("serviceFeign")ItemService itemService){
        this.itemService = itemService;
    }

    @GetMapping("/listar")
    public List<Item> listar(){
        Supplier<List<Item>> listSupplier = itemService::findAll;
        return listSupplier.get();
    }

    @Timed("getting.detalle")
    @GetMapping("/ver/{id}/cantidad/{cantidad}")
    public Item detalle(@PathVariable Long id, @PathVariable Integer cantidad) {
        BiFunction<Long, Integer, Item>  getItem = itemService::findById;
        return getItem.apply(id, cantidad);
    }


}
