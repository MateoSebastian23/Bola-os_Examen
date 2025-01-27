package com.example.tratamiento_service.controller;

import com.example.tratamiento_service.entity.Tratamiento;
import com.example.tratamiento_service.repository.TratamientoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tratamientos")
public class TratamientoController {

    private final TratamientoRepository tratamientoRepository;

    public TratamientoController(TratamientoRepository tratamientoRepository) {
        this.tratamientoRepository = tratamientoRepository;
    }

    // Obtener todos los tratamientos
    @GetMapping
    public List<Tratamiento> listarTratamientos() {
        return tratamientoRepository.findAll();
    }

    // Obtener un tratamiento por ID
    @GetMapping("/{id}")
    public ResponseEntity<Tratamiento> obtenerTratamientoPorId(@PathVariable Long id) {
        return tratamientoRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Crear un nuevo tratamiento
    @PostMapping
    public Tratamiento crearTratamiento(@RequestBody Tratamiento tratamiento) {
        return tratamientoRepository.save(tratamiento);
    }

    // Actualizar un tratamiento existente
    @PutMapping("/{id}")
    public ResponseEntity<Tratamiento> actualizarTratamiento(@PathVariable Long id, @RequestBody Tratamiento detallesTratamiento) {
        return tratamientoRepository.findById(id)
                .map(tratamiento -> {
                    tratamiento.setNombre(detallesTratamiento.getNombre());
                    Tratamiento actualizado = tratamientoRepository.save(tratamiento);
                    return ResponseEntity.ok(actualizado);
                })
                .orElse(ResponseEntity.notFound().build());
    }

// Eliminar un tratamiento
@DeleteMapping("/{id}")
public ResponseEntity<Void> eliminarTratamiento(@PathVariable Long id) {
    return tratamientoRepository.findById(id)
            .map(tratamiento -> {
                tratamientoRepository.delete(tratamiento);
                return ResponseEntity.<Void>noContent().build(); // Se especifica el tipo genérico explícitamente
            })
            .orElse(ResponseEntity.notFound().build());
}
