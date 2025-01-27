package com.ejemplo.enfermedad.service;

import com.ejemplo.enfermedad.client.TratamientoClient;
import com.ejemplo.enfermedad.model.Enfermedad;
import com.ejemplo.enfermedad.model.Tratamiento;
import com.ejemplo.enfermedad.repository.EnfermedadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EnfermedadService {

    private final EnfermedadRepository enfermedadRepository;
    private final TratamientoClient tratamientoClient; // Cliente Feign para comunicación con el microservicio Tratamiento

    @Autowired
    public EnfermedadService(EnfermedadRepository enfermedadRepository, TratamientoClient tratamientoClient) {
        this.enfermedadRepository = enfermedadRepository;
        this.tratamientoClient = tratamientoClient;
    }

    // Crear o actualizar una enfermedad
    public Enfermedad crearOActualizarEnfermedad(Enfermedad enfermedad) {
        return enfermedadRepository.save(enfermedad);
    }

    // Obtener todas las enfermedades
    public List<Enfermedad> obtenerTodasLasEnfermedades() {
        return enfermedadRepository.findAll();
    }

    // Obtener enfermedad por ID
    public Optional<Enfermedad> obtenerEnfermedadPorId(Long id) {
        return enfermedadRepository.findById(id);
    }

    // Eliminar enfermedad por ID
    public void eliminarEnfermedad(Long id) {
        enfermedadRepository.deleteById(id);
    }

    // Obtener tratamientos para una enfermedad utilizando el cliente Feign
    public List<Tratamiento> obtenerTratamientosPorEnfermedad(Long enfermedadId) {
        return tratamientoClient.obtenerTratamientosPorEnfermedad(enfermedadId);
    }

}
