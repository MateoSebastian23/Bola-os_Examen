package com.example.enfermedad_service.client;

import com.example.enfermedad_service.model.Tratamiento;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

// Define el Feign client para interactuar con el microservicio de Tratamiento
@FeignClient(name = "tratamiento-service", url = "http://localhost:8081") // URL para el servicio Tratamiento
public interface TratamientoClient {

    // Método para obtener tratamientos disponibles para una enfermedad
    @GetMapping("/tratamientos/enfermedad/{id}")
    List<Tratamiento> obtenerTratamientosPorEnfermedad(@PathVariable("id") Long enfermedadId);
}
