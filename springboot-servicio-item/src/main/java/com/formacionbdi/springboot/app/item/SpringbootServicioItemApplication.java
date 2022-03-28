package com.formacionbdi.springboot.app.item;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
/*@RibbonClient(name="servicio-productos") the annotatyion is moved away due for eurteka */
@EnableFeignClients
@EnableEurekaClient
@EnableCircuitBreaker//This annotation depend on dependecie hystrix and is dedicated for controls flaws
@ComponentScan({"com.formacionbdi.springboot.app"})
public class SpringbootServicioItemApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootServicioItemApplication.class);
    }
}
