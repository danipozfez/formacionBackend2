package block6personcontrollers.block6personcontrollers;

import org.springframework.stereotype.Service;

@Service
public class PersonaService {

    public Persona crearPersona(String nombre, String localidad, int edad){
        Persona persona = new Persona();

        persona.setNombre(nombre);
        persona.setLocalidad(localidad);
        persona.setEdad(edad);

        return persona;
    }
}
