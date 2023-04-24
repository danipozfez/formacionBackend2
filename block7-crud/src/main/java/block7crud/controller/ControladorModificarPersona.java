package block7crud.controller;

import block7crud.application.PersonaServiceImpl;
import block7crud.controller.dto.PersonaInputDto;
import block7crud.controller.dto.PersonaOutDto;
import block7crud.domain.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/persona")
public class ControladorModificarPersona {
    @Autowired
    PersonaServiceImpl personaService;

    @PutMapping("/modificar/{id}")
    public ResponseEntity<PersonaOutDto> modPersona(@RequestBody PersonaInputDto personaInputDto,@PathVariable int id){



        return  ResponseEntity.ok().body(personaService.updatePersona(personaInputDto,id));
    }

}
