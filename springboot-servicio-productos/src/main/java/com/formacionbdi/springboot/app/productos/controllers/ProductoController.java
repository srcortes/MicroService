package com.formacionbdi.springboot.app.productos.controllers;

import com.formacionbdi.springboot.app.productos.annotation.GeneralAnnotation;
import com.formacionbdi.springboot.app.productos.annotation.InfoController;
import com.formacionbdi.springboot.app.productos.models.entity.Producto;
import com.formacionbdi.springboot.app.productos.models.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

@RestController
@GeneralAnnotation(value = "This a controller")
public class ProductoController {

    private IProductoService productoService;

    @Autowired
    @GeneralAnnotation("Constructor public injection dependency")
    public ProductoController(IProductoService productoService){
        this.productoService = productoService;
    }

    @GetMapping(value = "${api.url.lista}")
    @GeneralAnnotation("This method return a complete list producst that are getting from database")
    public List<Producto> listar(){
       Supplier<List<Producto>> supplier = productoService::findAll;
       return supplier.get();
    }

    @GetMapping(value = "${api.url.ver}")
    @GeneralAnnotation("This method get product from db for id")
    public Producto detalle(@PathVariable("id")
                            @InfoController(id= 0l, descriptionVariable = "Identify a product inside db") Long id){
        Function<Long, Producto> productoFunction = productoService::findById;
        return productoFunction.apply(id);
    }
}
