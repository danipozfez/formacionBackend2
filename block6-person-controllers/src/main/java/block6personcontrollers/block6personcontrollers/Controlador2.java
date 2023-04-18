package block6personcontrollers.block6personcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controlador2 {

    @Autowired
    Controlador1 controlador1;

    @PostMapping("/getPersona")
    public Persona multiplicaEdadPorDos (@RequestBody Persona persona){
        int edad = persona.getEdad()*2;
        persona.setEdad(edad);
        return persona;
    }
    @GetMapping("/getCiudades")
    public List<Ciudad> mostrarListaCiudades (){
        return controlador1.mostrarCiudades();
    }
}
