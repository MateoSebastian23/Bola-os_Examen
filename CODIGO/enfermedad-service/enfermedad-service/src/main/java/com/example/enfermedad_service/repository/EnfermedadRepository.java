package com.example.enfermedad_service.repository;

import com.example.enfermedad_service.entity.Enfermedad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnfermedadRepository extends JpaRepository<Enfermedad, Long> {
}
