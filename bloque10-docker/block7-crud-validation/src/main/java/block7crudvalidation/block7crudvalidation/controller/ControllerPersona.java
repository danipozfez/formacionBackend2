package block7crudvalidation.block7crudvalidation.controller;

import block7crudvalidation.block7crudvalidation.application.PersonaServiceImpl;
import block7crudvalidation.block7crudvalidation.controller.dto.PersonaInputDto;
import block7crudvalidation.block7crudvalidation.controller.dto.PersonaOutDto;
import block7crudvalidation.block7crudvalidation.controller.dto.ProfesorOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/persona")
public class ControllerPersona {

    @Autowired
    PersonaServiceImpl personaService;
    @Autowired
    MyFeign myFeign;

    @PostMapping
    public ResponseEntity<PersonaOutDto> addPersona(@RequestBody PersonaInputDto personaInputDto) throws Exception {
        URI location = URI.create("/persona");
        return ResponseEntity.created(location).body(personaService.addPersona(personaInputDto));

    }

    @GetMapping("lista")
    public List<PersonaOutDto> getAll() {
        return personaService.getListaPersonas();
    }

    @GetMapping("nombre/{nombre}")
    public List<PersonaOutDto> getByName(@PathVariable String nombre) {
        return personaService.getPersonaByName(nombre);
    }

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
    @GetMapping("profesor/{id}")
    public ProfesorOutputDto getProfesor(@PathVariable int id){
        String url= "http://localhost:8081/profesor/id/"+id;
        RestTemplate restTemplate= new RestTemplate();
        ResponseEntity<ProfesorOutputDto>response = restTemplate.getForEntity(url,ProfesorOutputDto.class);
        return response.getBody();
    }

    @GetMapping("profesor2/{id}")
    public ProfesorOutputDto getPofesor(@PathVariable int id){

        return myFeign.getProfesor(id);
    }

}
