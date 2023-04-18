package block6personcontrollers.block6personcontrollers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controlador2 {

    @PostMapping("/getPersona")
    public Persona multiplicaEdadPorDos (@RequestBody Persona persona){
        int edad = persona.getEdad()*2;
        persona.setEdad(edad);
        return persona;
    }
}
