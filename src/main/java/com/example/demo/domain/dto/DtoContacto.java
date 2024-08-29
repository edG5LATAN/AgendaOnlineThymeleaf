package com.example.demo.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public record DtoContacto(
        @NotBlank String nombre,
        @NotBlank String imagen,
        @NotBlank String telefono,
        @NotNull Integer edad,
        @NotBlank String correo,
        @NotBlank String direccion

) {
}
