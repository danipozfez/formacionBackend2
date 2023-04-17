package com.example.EjercicioPersona2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controlador1 {
    @Autowired
    private PersonaService personaService;

    @PostMapping("/persona")
    public  Persona crearPersona(@RequestHeader String nombre, @RequestHeader String localidad, @RequestHeader String edad){
        return personaService.crearPersona(nombre,localidad,edad);
    }
}
