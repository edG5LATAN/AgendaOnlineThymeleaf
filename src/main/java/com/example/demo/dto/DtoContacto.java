package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;

public record DtoContacto(
        @NotBlank String nombre,
        @NotBlank String imagen,
        @NotBlank String edad,
        @NotBlank String correo,
        @NotBlank String telefono,
        @NotBlank String direccion
) {
}
