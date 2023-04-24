package block7crud.controller;

import block7crud.application.PersonaService;
import block7crud.controller.dto.PersonaOutDto;
import block7crud.domain.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/persona")
public class ControladorConsultas {
    @Autowired
    PersonaService personaService;
    @GetMapping("id/{id}")
    public ResponseEntity<PersonaOutDto>getPersonaById(@PathVariable int id){
        try {
            return  ResponseEntity.ok().body(personaService.getPersonaById(id));

        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("nombre/{nombre}")
    public List<PersonaOutDto> getByName(@PathVariable String nombre){
        return personaService.getPersonaByName(nombre);
    }
}

