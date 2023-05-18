package block7crudvalidation.block7crudvalidation.controller;

import block7crudvalidation.block7crudvalidation.application.AsignaturaServiceImpl;
import block7crudvalidation.block7crudvalidation.application.StudentServiceImpl;
import block7crudvalidation.block7crudvalidation.controller.dto.AsignaturaInputDto;
import block7crudvalidation.block7crudvalidation.controller.dto.AsignaturaOutDto;
import block7crudvalidation.block7crudvalidation.controller.dto.PersonaOutDto;
import block7crudvalidation.block7crudvalidation.controller.dto.StudentOutDtoSimple;
import block7crudvalidation.block7crudvalidation.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/asignatura")
public class ControllerAsignatura {
    @Autowired
    AsignaturaServiceImpl asignaturaService;
    @Autowired
    StudentServiceImpl studentService;

    @PostMapping
    public ResponseEntity<AsignaturaOutDto> addAsignatura(@RequestBody AsignaturaInputDto asignaturaInputDto) {

        return ResponseEntity.status(HttpStatus.CREATED).body(asignaturaService.addAsignatura((asignaturaInputDto)));
    }

    @GetMapping("lista")
    public List<AsignaturaOutDto> getAll() {

        return asignaturaService.getListaAsignaturas();
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteAsignaturaById(@PathVariable int id) {
        asignaturaService.deleteAsignaturaById(id);
        return ResponseEntity.ok().body("asignatura con id:" + id + " borrada");
    }

    @PutMapping("/modificar/{id}")
    public ResponseEntity<AsignaturaOutDto> modAsignatura(@RequestBody AsignaturaInputDto asignaturaInputDto, @PathVariable int id) {
        return ResponseEntity.ok().body(asignaturaService.updateAsignatura(asignaturaInputDto, id));
    }


    @GetMapping("id/{id}")
    public ResponseEntity<AsignaturaOutDto> getAsignaturaById(@PathVariable int id) {
        try {
            return ResponseEntity.ok().body(asignaturaService.getAsignaturaById(id));

        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/listastudents/{id}")
    public ResponseEntity<List<StudentOutDtoSimple>> getAsignaturasById(@PathVariable int id) {
        List<StudentOutDtoSimple> students = asignaturaService.getStudentByAsignatura(id);
        return ResponseEntity.ok(students);
    }
}
