package com.example.demo.model;

import com.example.demo.dto.DtoContacto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "contacto")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Contacto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String imagen;
    private LocalDate fecha;
    private Integer edad;
    private String correo;
    private String telefono;
    private String direccion;
    private Boolean activo;


    public Contacto(DtoContacto dtoContacto) {
        this.nombre= dtoContacto.nombre();
        this.imagen= dtoContacto.imagen();
        this.edad= Integer.valueOf(dtoContacto.edad());
        this.correo= dtoContacto.correo();
        this.telefono= dtoContacto.telefono();
        this.direccion= dtoContacto.direccion();
        this.activo=true;
        this.fecha=LocalDate.now();
    }

    public void ocultar() {
       this.activo=false;
    }

    public void restaurar() {
        this.activo=true;
    }

    public void actualizar(DtoContacto dtoContacto) {
        if(dtoContacto.nombre()!=null){
            this.nombre= dtoContacto.nombre();
        }
        if(dtoContacto.imagen()!=null){
            this.imagen= dtoContacto.imagen();
        }
        if(dtoContacto.edad()!=null){
            this.edad= Integer.valueOf(dtoContacto.edad());
        }
        if(dtoContacto.correo()!=null){
            this.correo= dtoContacto.correo();
        }
        if(dtoContacto.telefono()!=null){
            this.telefono= dtoContacto.telefono();
        }
        if(dtoContacto.direccion()!=null){
            this.direccion= dtoContacto.direccion();
        }

    }
}
