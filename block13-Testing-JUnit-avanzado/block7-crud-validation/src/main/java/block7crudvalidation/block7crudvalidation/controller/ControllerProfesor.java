package block7crudvalidation.block7crudvalidation.controller;

import block7crudvalidation.block7crudvalidation.application.ProfesorServiceImpl;
import block7crudvalidation.block7crudvalidation.controller.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/profesor")
public class ControllerProfesor {

    @Autowired
    ProfesorServiceImpl profesorService;

    @PostMapping
    public ResponseEntity<ProfesorOutputDto> addProfesor(@RequestBody ProfesorInputDto profesorInputDto) throws Exception {

        return ResponseEntity.status(HttpStatus.CREATED).body(profesorService.addProfesor(profesorInputDto));
    }

    @DeleteMapping("delete/{id}")//on delete cascade???
    public ResponseEntity<String> deleteProfesorById(@PathVariable int id) {
        profesorService.deleteProfesorById(id);
        return ResponseEntity.ok().body("el profesor con id " + id + " ha sido borrado");
    }

    @GetMapping("id/{id}")
    public ResponseEntity<Object> gerProfesorId(@PathVariable int id) {

            try {
                return ResponseEntity.ok().body(profesorService.getProfesorById(id));

            } catch (Exception e) {
                return ResponseEntity.notFound().build();
            }

    }
    @GetMapping("lista")
    public List<ProfesorOutputDto> getAll() {

        return profesorService.getListaProfesores();
    }

    @GetMapping("nombre/{nombre}")
    public List<ProfesorOutputDto> getByName(@PathVariable String nombre) {
        return profesorService.getProfesorByName(nombre);
    }

    @PutMapping("/modificar/{id}")
    public ResponseEntity<ProfesorOutputDto> modStudent(@RequestBody ProfesorInputDto profesorInputDto, @PathVariable int id) {
        return ResponseEntity.ok().body(profesorService.updateProfesor(profesorInputDto, id));
    }

    @GetMapping("listaestudiantes/{idProfesorAsignado}")
    public List<StudentOutDtoSimple> getEtudiantes(@PathVariable int idProfesorAsignado) {

        return profesorService.getListaEstuantesPorProfesor(idProfesorAsignado);
    }


}
