package com.formacionbdi.springboot.app.item.service;


import com.formacionbdi.springboot.app.item.models.Item;
import com.formacionbdi.springboot.app.item.models.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.formacionbdi.springboot.app.item.functional.GetItem;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@Service("serviceRest")
public class ItemServiceImpl implements ItemService{


    private RestTemplate clienteRest;

    @Autowired
    public ItemServiceImpl(RestTemplate clienteRest){
        this.clienteRest = clienteRest;
    }

    @Override
    public List<Item> findAll() {
        List<Producto> productos = Arrays.asList(clienteRest.getForObject("http://localhost:8001/listar", Producto[].class));
        GetItem getItem = Item::new;
        return productos.stream().map(i-> getItem.getItem(i, 1)).collect(Collectors.toList());

    }

    @Override
    public Item findById(Long id, Integer cantidad) {
        Supplier<HashMap> pathVariable =  HashMap::new;
        Map<String, String> pathVariables = pathVariable.get();
        pathVariables.put("id", id.toString());
        Producto producto  = clienteRest.getForObject("http://localhost:8001/ver/{id}", Producto.class,pathVariables);

        GetItem item = Item::new;
        return item.getItem(producto, cantidad);
    }
}
