package com.example.EjercicioPersona;

import org.springframework.web.bind.annotation.*;

@RestController("/prueba")
public class Controlador {

    @GetMapping("/user/{nombre}")
    public String devuelveSaludo(@PathVariable String nombre){
        return "Hola " + nombre;
    }

    @PostMapping("/addUser")
    public Persona persona (@RequestBody Persona persona){
        persona.setNombre(persona.getNombre()+" bosonit");
        persona.setPoblacion("oficina de "+persona.getPoblacion());
        return persona;
    }
}
