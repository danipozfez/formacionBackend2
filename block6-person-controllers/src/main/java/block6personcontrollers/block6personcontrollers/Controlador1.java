package block6personcontrollers.block6personcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controlador1 {

    @Autowired
    Persona persona;
    @Autowired
    PersonaService personaService;
    @Autowired
    CiudadService ciudadService;

    public List<Ciudad> ciudades = new ArrayList<>();

    @PostMapping("/addPersona")
    public Persona addPersona(@RequestHeader String nombre, @RequestHeader String localidad, @RequestHeader int edad) {
        return personaService.crearPersona(nombre,localidad,edad);
    }
    @PostMapping("/addCiudad")
    public Ciudad addCiudad(@RequestBody Ciudad ciudad){
        ciudades.add(ciudadService.crearCiudad(ciudad.getNombre(),ciudad.getNumeroHabitantes()));
        return ciudad;
    }
    public List<Ciudad> mostrarCiudades(){
        return ciudades;
    }
}
