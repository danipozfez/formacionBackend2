package block6simplecontrollers.block6simplecontrollers;

import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {

    @GetMapping("/user/{nombre}")
    public String saludaPersona (@PathVariable String nombre){
        return "hola, soy "+nombre;
    }
    @PostMapping("/addUser")
    public Persona addPersona (@RequestBody Persona persona){
        return persona;
    }
}
