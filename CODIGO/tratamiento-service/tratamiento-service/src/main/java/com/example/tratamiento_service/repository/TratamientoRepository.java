package com.example.tratamiento_service.repository;

import com.example.tratamiento_service.entity.Tratamiento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TratamientoRepository extends JpaRepository<Tratamiento, Long> {
}
