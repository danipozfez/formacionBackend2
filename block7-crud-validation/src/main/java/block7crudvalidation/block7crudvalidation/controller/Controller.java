package block7crudvalidation.block7crudvalidation.controller;

import block7crudvalidation.block7crudvalidation.application.PersonaServiceImpl;
import block7crudvalidation.block7crudvalidation.controller.dto.PersonaInputDto;
import block7crudvalidation.block7crudvalidation.controller.dto.PersonaOutDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/persona")
public class Controller {

    @Autowired
    PersonaServiceImpl personaService;

    @PostMapping
    public ResponseEntity<PersonaOutDto> addPersona(@RequestBody PersonaInputDto personaInputDto){
        URI location = URI.create("/persona");
        return  ResponseEntity.created(location).body(personaService.addPersona(personaInputDto));

    }
    @GetMapping("lista")
    public List<PersonaOutDto> getAll(){
        return personaService.getListaPersonas();
    }

    @GetMapping("nombre/{nombre}")
    public List<PersonaOutDto> getByName(@PathVariable String nombre){
        return personaService.getPersonaByName(nombre);
    }
}
