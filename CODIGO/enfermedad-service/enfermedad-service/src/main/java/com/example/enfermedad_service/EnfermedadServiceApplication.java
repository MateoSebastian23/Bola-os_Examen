package com.example.enfermedad_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients  // Habilita Feign en la aplicación
public class EnfermedadServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EnfermedadServiceApplication.class, args);
    }
}
