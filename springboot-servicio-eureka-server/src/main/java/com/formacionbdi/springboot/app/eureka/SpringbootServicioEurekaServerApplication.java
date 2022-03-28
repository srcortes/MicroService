package com.formacionbdi.springboot.app.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaServer
@ComponentScan({"com.formacionbdi.springboot.app"})
public class SpringbootServicioEurekaServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootServicioEurekaServerApplication.class);
    }
}
