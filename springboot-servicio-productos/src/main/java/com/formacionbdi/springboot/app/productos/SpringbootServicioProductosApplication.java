package com.formacionbdi.springboot.app.productos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@ComponentScan({"com.formacionbdi.springboot.app"})
public class SpringbootServicioProductosApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootServicioProductosApplication.class);
    }
}
