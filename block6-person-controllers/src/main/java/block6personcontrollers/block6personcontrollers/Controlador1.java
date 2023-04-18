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

    public List<Ciudad> ciudades = new ArrayList<>();

    @PostMapping("/addPersona")
    public Persona addPersona(@RequestHeader String nombre, @RequestHeader String localidad, @RequestHeader int edad) {
        persona = new Persona(nombre,localidad,edad);
        return persona;
    }
    @PostMapping("/addCiudad")
    public Ciudad addCiudad(@RequestBody Ciudad ciudad){
        ciudad.setNombre(ciudad.getNombre());
        ciudad.setNumeroHabitantes(ciudad.getNumeroHabitantes());
        ciudades.add(ciudad);
        return ciudad;
    }
    public List<Ciudad> mostrarCiudades(){
        return ciudades;
    }
}
