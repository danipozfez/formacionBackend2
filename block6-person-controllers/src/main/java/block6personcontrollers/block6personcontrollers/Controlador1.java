package block6personcontrollers.block6personcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controlador1 {

    @Autowired
    Persona persona;

    @PostMapping("/addPersona")
    public Persona addPersona(@RequestHeader String nombre, @RequestHeader String localidad, @RequestHeader int edad) {
        persona = new Persona(nombre,localidad,edad);
        return persona;
    }
}
