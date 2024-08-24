package com.example.demo.controller;

import com.example.demo.dto.DtoContacto;
import com.example.demo.model.Contacto;
import com.example.demo.repository.RespositoryContacto;
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
public class FormularioController {

    private final RespositoryContacto repository;
    @GetMapping("/formulario")
    public String formulario(DtoContacto dtoContacto){
        return "/contacto/formulario";
    }

    @PostMapping("/nuevo")
    public String nuevo(@Valid DtoContacto dtoContacto,BindingResult result){
        if (result.hasErrors()){
            return "/contacto/formulario";
        }
        repository.save(new Contacto(dtoContacto));
        return "redirect:/";
    }


}
