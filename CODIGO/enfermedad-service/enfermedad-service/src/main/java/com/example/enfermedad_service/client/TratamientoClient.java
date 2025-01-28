package com.example.enfermedad_service.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.enfermedad_service.model.Tratamiento;

@FeignClient(name = "tratamiento-service", url = "http://localhost:8081")
public interface TratamientoClient {

    @GetMapping("/tratamientos/enfermedad/{id}")
    List<Tratamiento> obtenerTratamientosPorEnfermedad(@PathVariable("id") Long enfermedadId);
}
