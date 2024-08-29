package com.example.demo.domain.repository;

import com.example.demo.domain.model.Contacto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepositoryContacto extends JpaRepository<Contacto,Long> {
    List<Contacto> findByActivoFalse();

    List<Contacto> findByActivoTrue();

    Contacto findByNombre(String nombre);
}
