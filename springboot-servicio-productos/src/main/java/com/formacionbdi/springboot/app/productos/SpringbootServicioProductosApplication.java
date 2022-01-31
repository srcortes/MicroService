package com.formacionbdi.springboot.app.productos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.formacionbdi.springboot.app.productos"})
public class SpringbootServicioProductosApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootServicioProductosApplication.class);
    }
}
