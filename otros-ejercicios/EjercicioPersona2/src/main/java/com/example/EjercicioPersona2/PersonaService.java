package com.example.EjercicioPersona2;

public class PersonaService {

    public Persona crearPersona(String nombre, String localidad, String edad) {

        Persona persona = new Persona();

        persona.setNombre(nombre);
        persona.setLocalidad(localidad);
        persona.setEdad(edad);

        return persona;
    }
}
