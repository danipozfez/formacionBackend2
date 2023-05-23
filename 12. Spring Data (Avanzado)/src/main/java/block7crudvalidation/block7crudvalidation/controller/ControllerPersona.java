package block7crudvalidation.block7crudvalidation.controller;

import block7crudvalidation.block7crudvalidation.application.PersonaServiceImpl;
import block7crudvalidation.block7crudvalidation.controller.dto.PersonaInputDto;
import block7crudvalidation.block7crudvalidation.controller.dto.PersonaOutDto;
import block7crudvalidation.block7crudvalidation.controller.dto.ProfesorOutputDto;
import block7crudvalidation.block7crudvalidation.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin("*")
//@RequestMapping("/persona") COMENTADO PARA ADAPTARLO AL EJERCICIO CORS
public class ControllerPersona {

    @Autowired
    PersonaServiceImpl personaService;

    @Autowired
    PersonaRepository personaRepository;
    @Autowired
    MyFeign myFeign;

    @PostMapping("/addperson")
    public ResponseEntity<PersonaOutDto> addPerson(@RequestBody PersonaInputDto personaInputDto) throws Exception {

        return ResponseEntity.status(HttpStatus.CREATED).body(personaService.addPersona(personaInputDto));

    }

    @GetMapping("/getall")
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

    @GetMapping("/customquery")
    public Iterable<PersonaOutDto> getPersonaByCustom (
            @RequestParam(required = false)String name,
            @RequestParam(required = false)String surname,
            @RequestParam(required = false)String usuario,
            @RequestParam(required = false)String created_date

            ){
        HashMap<String,Object> data = new HashMap<>();

        if (name != null) data.put("name",name);
        if (name != null) data.put("surname",surname);
        if (name != null) data.put("usuario",usuario);
        if (name != null) data.put("created_date",created_date);

        return personaService.getCustomQuery(data);//pendiente
    }

}
