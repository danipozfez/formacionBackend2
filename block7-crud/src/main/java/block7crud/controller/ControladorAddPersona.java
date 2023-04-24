package block7crud.controller;

import block7crud.application.PersonaServiceImpl;
import block7crud.controller.dto.PersonaInputDto;
import block7crud.controller.dto.PersonaOutDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/persona")
public class ControladorAddPersona {

    @Autowired
    PersonaServiceImpl personaService;

    @PostMapping
    public ResponseEntity<PersonaOutDto>addPersona(@RequestBody PersonaInputDto personaInputDto){
        URI location = URI.create("/persona");
        return  ResponseEntity.created(location).body(personaService.addPersona(personaInputDto));
    }
}
