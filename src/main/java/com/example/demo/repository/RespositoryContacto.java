package com.example.demo.repository;

import com.example.demo.model.Contacto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RespositoryContacto extends JpaRepository<Contacto,Long> {
    List<Contacto> findByActivoFalse();

    List<Contacto> findByActivoTrue();
}
