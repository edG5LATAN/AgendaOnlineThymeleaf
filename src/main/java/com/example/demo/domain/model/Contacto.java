package com.example.demo.domain.model;

import com.example.demo.domain.dto.DtoContacto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "contacto")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Contacto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;
    private String imagen;
    private String telefono;
    private Integer edad;
    private String correo;
    private String direccion;
    private LocalDate fecha;
    private Boolean activo;

    public Contacto(DtoContacto dtoContacto) {
        this.nombre= dtoContacto.nombre();
        this.imagen= dtoContacto.imagen();
        this.telefono= dtoContacto.telefono();
        this.edad= dtoContacto.edad();
        this.correo= dtoContacto.correo();
        this.direccion= dtoContacto.direccion();
        this.fecha=LocalDate.now();
        this.activo=true;
    }

    public void restaurar() {
        this.activo=true;
    }

    public void borrar() {
        this.activo=false;
    }

    public void modificar(DtoContacto dtoContacto) {
        if(dtoContacto.nombre()!=""){
            this.nombre= dtoContacto.nombre();
        }
        if(dtoContacto.imagen()!=""){
            this.imagen= dtoContacto.imagen();
        }
        if(dtoContacto.telefono()!=""){
            this.telefono= dtoContacto.telefono();
        }
        if(dtoContacto.edad()!=null){
            this.edad= dtoContacto.edad();
        }
        if(dtoContacto.correo()!=""){
            this.correo= dtoContacto.correo();
        }
        if(dtoContacto.direccion()!=""){
            this.direccion= dtoContacto.direccion();
        }
    }
}
