package com.example.EjercicioPersona2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controlador2 {

    //@Autowired
    //private PersonaService personaService;

    @PostMapping("/persona2")
    public  Persona obtenerPersonaModificada (@RequestBody Persona persona){
        int edad = Integer.parseInt(persona.getEdad())*2;
        persona.setEdad(String.valueOf(edad));
        return persona;
    }
}
