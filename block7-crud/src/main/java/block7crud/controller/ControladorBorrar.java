package block7crud.controller;

import block7crud.application.PersonaService;
import block7crud.controller.dto.PersonaOutDto;
import block7crud.domain.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/persona")

public class ControladorBorrar {
    @Autowired
    PersonaService personaService;

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePersonaById(@PathVariable int id) {
        //PersonaService personaService1= (PersonaService) personaService.getPersonaById(id);
        try {
            personaService.deletePersonaById(id);
            return ResponseEntity.ok().body("la persona con id " + id + " ha sido borrada");
        } catch (Exception e) {
            return  ResponseEntity.notFound().build();
        }
    }
}
