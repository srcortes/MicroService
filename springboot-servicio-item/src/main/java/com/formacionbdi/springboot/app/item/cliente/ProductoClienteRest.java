package com.formacionbdi.springboot.app.item.cliente;



import com.formacionbdi.springboot.app.item.models.Producto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * aqui se  consume otro micro desde feign client
 * se usa name y url (name="servicio-productos", url="localhost:8001")
 */
/*@FeignClient(name="servicio-productos", url="localhost:8001")
* HERE WE'VE RETIRED THE ANNOTATION URL, DUE WE GOING TO USE RIBBON
* */
@FeignClient(name="servicio-productos")
public interface ProductoClienteRest {
    @GetMapping("/listar")
    public List<Producto> listar();

    @GetMapping("/ver/{id}")
    public Producto detalle(@PathVariable Long id);
}
