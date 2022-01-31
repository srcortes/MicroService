package com.formacionbdi.springboot.app.item.service;

import com.formacionbdi.springboot.app.item.models.Item;
import com.formacionbdi.springboot.app.item.models.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService{

    private RestTemplate clienteRest;

    @Autowired
    public ItemServiceImpl(RestTemplate clienteRest){
        this.clienteRest = clienteRest;
    }

    @Override
    public List<Item> findAll() {
        List<Producto> productos = Arrays.asList(clienteRest.getForObject("http://localhost:8001/listar", Producto[].class));
        return productos.stream().map(i->)
    }

    @Override
    public Item findById(Long id, Integer cantidad) {
        return null;
    }
}
