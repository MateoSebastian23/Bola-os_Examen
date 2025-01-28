package com.example.tratamiento_service.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tratamiento_service.entity.Tratamiento;
import com.example.tratamiento_service.repository.TratamientoRepository;

@RestController
@RequestMapping("/api/tratamientos")
public class TratamientoController {

    private final TratamientoRepository tratamientoRepository;

    // Constructor para inyección de dependencia
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
                .map(ResponseEntity::ok)  // Si se encuentra, devolver 200 OK
                .orElse(ResponseEntity.notFound().build());  // Si no se encuentra, devolver 404 Not Found
    }

    // Crear un nuevo tratamiento
    @PostMapping
    public Tratamiento crearTratamiento(@RequestBody Tratamiento tratamiento) {
        return tratamientoRepository.save(tratamiento);  // Guardar el tratamiento en la base de datos
    }

    // Actualizar un tratamiento existente
    @PutMapping("/{id}")
    public ResponseEntity<Tratamiento> actualizarTratamiento(@PathVariable Long id, @RequestBody Tratamiento detallesTratamiento) {
        return tratamientoRepository.findById(id)
                .map(tratamiento -> {
                    tratamiento.setNombre(detallesTratamiento.getNombre());  // Actualizar nombre o los campos necesarios
                    Tratamiento actualizado = tratamientoRepository.save(tratamiento);  // Guardar los cambios
                    return ResponseEntity.ok(actualizado);  // Devolver el tratamiento actualizado con respuesta 200 OK
                })
                .orElse(ResponseEntity.notFound().build());  // Si no se encuentra el tratamiento, devolver 404 Not Found
    }

    // Eliminar un tratamiento
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> eliminarTratamiento(@PathVariable Long id) {
        return tratamientoRepository.findById(id)
                .map(tratamiento -> {
                    tratamientoRepository.delete(tratamiento);  // Eliminar el tratamiento
                    return ResponseEntity.noContent().build();  // Respuesta 204 No Content, ya que no se devuelve contenido
                })
                .orElse(ResponseEntity.notFound().build());  // Si no se encuentra el tratamiento, devolver 404 Not Found
    }
}
