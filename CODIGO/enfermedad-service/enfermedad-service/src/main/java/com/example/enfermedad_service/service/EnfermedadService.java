package com.example.enfermedad_service.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.enfermedad_service.client.TratamientoClient;
import com.example.enfermedad_service.model.Tratamiento;

@Service
public class EnfermedadService {

    private final TratamientoClient tratamientoClient;

    public EnfermedadService(TratamientoClient tratamientoClient) {
        this.tratamientoClient = tratamientoClient;
    }

    public List<Tratamiento> obtenerTratamientosPorEnfermedad(Long enfermedadId) {
        return tratamientoClient.obtenerTratamientosPorEnfermedad(enfermedadId);
    }
}
