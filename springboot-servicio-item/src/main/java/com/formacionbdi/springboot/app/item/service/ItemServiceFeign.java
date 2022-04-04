package com.formacionbdi.springboot.app.item.service;

import com.formacionbdi.springboot.app.item.cliente.ProductoClienteRest;
import com.formacionbdi.springboot.app.item.functional.GetItem;
import com.formacionbdi.springboot.app.item.models.Item;
import com.formacionbdi.springboot.app.item.models.Producto;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@Service("serviceFeign")
//@Primary //Esta anotacion es para indicar que este es el servicio principal
public class ItemServiceFeign implements ItemService {

    private ProductoClienteRest productoClienteRest;

    @Autowired
    public ItemServiceFeign(ProductoClienteRest productoClienteRest) {
        this.productoClienteRest = productoClienteRest;
    }

    @Override
    public List<Item> findAll() {
        GetItem getItem = Item::new;
        return productoClienteRest.listar().stream().map(p -> new Item(p, 1)).collect(Collectors.toList());
    }

    @Override
    @HystrixCommand(fallbackMethod = "metodoAlternativo")
    public Item findById(Long id, Integer cantidad) {
        GetItem getItem = Item::new;
        return getItem.getItem(productoClienteRest.detalle(id), cantidad);
    }

    public Item metodoAlternativo(Long id,Integer cantidad){
        System.out.println("here");
        Supplier<Item> item = Item::new;
        Item item1 = item.get();
        Supplier<Producto> producto = Producto::new;
        Producto producto1 = producto.get();

        item1.setCantidad(cantidad);
        producto1.setId(id);
        producto1.setNombre("Chanclas asesinas 2");
        producto1.setPrecio(2.5);
        item1.setProducto(producto1);
        return item1;
    }
}
