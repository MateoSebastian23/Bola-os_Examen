package com.example.enfermedad_service.entity;

import jakarta.persistence.*;  // Correcto para Spring Boot 3.x

@Entity
@Table(name = "enfermedades")
public class Enfermedad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nombre;

    // Constructor sin argumentos (requerido por JPA)
    public Enfermedad() {
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
