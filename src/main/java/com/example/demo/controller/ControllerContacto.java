package com.example.demo.controller;

import com.example.demo.domain.dto.DtoContacto;
import com.example.demo.domain.model.Contacto;
import com.example.demo.domain.repository.RepositoryContacto;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ControllerContacto {

    private final RepositoryContacto repository;

    @GetMapping("")
    public String home(Model model){
        List<Contacto> contactos=repository.findByActivoTrue();
        model.addAttribute("contactos",contactos);
        return "index";
    }

    @GetMapping("/borrados")
    public String eliminados(Model model){
        List<Contacto> contactos=repository.findByActivoFalse();
        model.addAttribute("contactos",contactos);
        return "contacto/eliminados";
    }

    @GetMapping("/borrar/{id}")
    @Transactional
    public String borrar(@PathVariable Long id){
        try {
            Contacto contacto= repository.getReferenceById(id);
            contacto.borrar();
            return "redirect:/";
        }catch (Exception exception){
            System.out.println(exception.toString());
            return "redirect:/";
        }

    }
    @GetMapping("/borrar/restaurar/{id}")
    @Transactional
    public String restaurar(@PathVariable Long id){
        try{
            Contacto contacto=repository.getReferenceById(id);
            contacto.restaurar();
            return "redirect:/borrados";
        }catch (Exception e){
            System.out.println(e.toString());
            return "redirect:/";
        }

    }

    @GetMapping("/actualizar/{id}")
    public String actualizar(@PathVariable Long id, Model model){
        Contacto contactos=repository.getReferenceById(id);
        model.addAttribute("contactos",contactos);
        return "contacto/actualizar";
    }

    @PostMapping("/actualizar/contacto/{id}")
    @Transactional
    public String modificar(@PathVariable Long id,@Valid DtoContacto dtoContacto){
        Contacto contacto=repository.getReferenceById(id);
        contacto.modificar(dtoContacto);
        return "redirect:/";
    }

    @PostMapping("/busqueda/unidad")
    public String busqueda(String nombre,Model model){

        Contacto contacto=repository.findByNombre(nombre);
        model.addAttribute("contactos",contacto);
        return "contacto/busqueda";

    }


}
