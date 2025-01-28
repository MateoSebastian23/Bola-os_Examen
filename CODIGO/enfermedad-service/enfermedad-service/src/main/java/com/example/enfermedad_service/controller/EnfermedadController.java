package com.example.enfermedad_service.controller;

import com.example.enfermedad_service.service.EnfermedadService;
import com.example.enfermedad_service.model.Tratamiento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/enfermedades")
public class EnfermedadController {

    private final EnfermedadService enfermedadService;

    @Autowired
    public EnfermedadController(EnfermedadService enfermedadService) {
        this.enfermedadService = enfermedadService;
    }

    // Endpoint para obtener los tratamientos de una enfermedad
    @GetMapping("/{enfermedadId}/tratamientos")
    public List<Tratamiento> obtenerTratamientosPorEnfermedad(@PathVariable Long enfermedadId) {
        return enfermedadService.obtenerTratamientosPorEnfermedad(enfermedadId);
    }
}
