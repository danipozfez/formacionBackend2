package block6personcontrollers.block6personcontrollers;

import org.springframework.stereotype.Service;

@Service
public class Persona {
    String nombre;
    String localidad;
    int edad;

    public Persona() {
    }

    public Persona(String nombre, String localidad, int edad) {
        this.nombre = nombre;
        this.localidad = localidad;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }


}
