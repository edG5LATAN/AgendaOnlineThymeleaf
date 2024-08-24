package com.example.demo.controller;

import com.example.demo.dto.DtoContacto;
import com.example.demo.model.Contacto;
import com.example.demo.repository.RespositoryContacto;
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
public class HomeController {

    private final RespositoryContacto repository;
    @GetMapping("/")
    public String home(Model model){
        List<Contacto> contactos=repository.findByActivoTrue();
        model.addAttribute("contactos",contactos);
        return "index";
    }

    @GetMapping("borrar/{id}")
    @Transactional
    public String borrar(@PathVariable Long id){
        Contacto contac=repository.getReferenceById(id);
        contac.ocultar();
        return "redirect:/";
    }

    @GetMapping("actualizar/{id}")
    public String actualizar(@PathVariable Long id,Model model){
        Contacto contacto= repository.getReferenceById(id);
        model.addAttribute("contacto",contacto);
        return "contacto/actualizar";
    }

    @PostMapping("editar/contacto/{id}")
    @Transactional
    public String actualizarContacto(@PathVariable Long id,@Valid DtoContacto dtoContacto){
        try{
            Contacto contacto  =repository.getReferenceById(id);
            contacto.actualizar(dtoContacto);

            return "redirect:/";
        }catch (Exception e){
            System.out.println(e.toString());
            return "redirect:/";
        }

    }
    @GetMapping("borrados")
    public String borrados(Model model){
        List<Contacto> contactos=repository.findByActivoFalse();
        model.addAttribute("contactos",contactos);
        return "contacto/borrados";
    }

    @GetMapping("borrados/restaurar/{id}")
    @Transactional
    public String restaurar(@PathVariable Long id){
        var contact=repository.getReferenceById(id);
        contact.restaurar();
        System.out.println(contact);
        return "redirect:/";
    }

}
