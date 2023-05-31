package block13mongodb.block13mongodb.controller;

import block13mongodb.block13mongodb.aplication.PersonaService;
import block13mongodb.block13mongodb.controller.dto.PersonaInputDto;
import block13mongodb.block13mongodb.controller.dto.PersonaOutDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/persona")
public class ControllerPersona {

    @Autowired
    PersonaService personaService;



    @PostMapping("/addperson")
    public ResponseEntity<PersonaOutDto> addPerson(@RequestBody PersonaInputDto personaInputDto) throws Exception {

        return ResponseEntity.status(HttpStatus.CREATED).body(personaService.addPersona(personaInputDto));

    }

    @GetMapping("/getall")
    public List<PersonaOutDto> getAll() {
        return personaService.getListaPersonas();
    }

    /*@GetMapping("nombre/{nombre}")
    public List<PersonaOutDto> getByName(@PathVariable String nombre) {
        return personaService.getPersonaByName(nombre);
    }*/

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deletePersonaById(@PathVariable int id) {
        personaService.deletePersonaById(id);
        return ResponseEntity.ok().body("la persona con id:" + id + " ha sido borrada");
    }

    @PutMapping("/modificar/{id}")
    public ResponseEntity<PersonaOutDto> modPersona(@RequestBody PersonaInputDto personaInputDto, @PathVariable int id) {
        return ResponseEntity.ok().body(personaService.updatePersona(personaInputDto, id));
    }

    @GetMapping("id/{id}")
    public ResponseEntity<PersonaOutDto> getPersonaById(@PathVariable int id) {
        try {
            return ResponseEntity.ok().body(personaService.getPersonaById(id));

        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }


}
