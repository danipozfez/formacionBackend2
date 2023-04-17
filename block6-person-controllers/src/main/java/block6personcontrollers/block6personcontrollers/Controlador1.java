package block6personcontrollers.block6personcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controlador1 {

    @Autowired
    PersonaService personaService;

    @PostMapping("/addPersona")
    public Persona addPersona(@RequestHeader String nombre, @RequestHeader String localidad, @RequestHeader int edad) {
        return personaService.crearPersona(nombre, localidad, edad);
    }
}
