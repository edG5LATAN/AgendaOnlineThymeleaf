package com.example.demo.controller;


import com.example.demo.domain.dto.DtoContacto;
import com.example.demo.domain.model.Contacto;
import com.example.demo.domain.repository.RepositoryContacto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/crear")
@RequiredArgsConstructor
public class ControllerFormulario {

    private final RepositoryContacto repository;

    @GetMapping("/formulario")
    public String formulario(DtoContacto dtoContacto){
        return "contacto/formulario";
    }

    @PostMapping("/nuevo")
    public String nuevo(@Valid DtoContacto dtoContacto, BindingResult result){
        repository.save(new Contacto(dtoContacto));
        if(result.hasErrors()){
            return "contacto/formulariores";
        }
        return "redirect:/";
    }

}
