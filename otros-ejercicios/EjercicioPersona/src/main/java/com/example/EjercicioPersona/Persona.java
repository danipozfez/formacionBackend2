package com.example.EjercicioPersona;

public class Persona {
    String nombre;
    String poblacion;
    String Edad;

    public Persona() {
    }

    public Persona(String nombre, String poblacion, String edad) {
        this.nombre = nombre;
        this.poblacion = poblacion;
        Edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    public String getEdad() {
        return Edad;
    }

    public void setEdad(String edad) {
        Edad = edad;
    }
}
