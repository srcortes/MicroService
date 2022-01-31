package com.formacionbdi.springboot.app.item;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.formacionbdi.springboot.app"})
public class SpringbootServicioItemApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootServicioItemApplication.class);
    }
}
