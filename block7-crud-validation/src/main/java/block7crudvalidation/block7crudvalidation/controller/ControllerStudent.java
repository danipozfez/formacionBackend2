package block7crudvalidation.block7crudvalidation.controller;

import block7crudvalidation.block7crudvalidation.application.StudentServiceImpl;
import block7crudvalidation.block7crudvalidation.controller.dto.PersonaInputDto;
import block7crudvalidation.block7crudvalidation.controller.dto.PersonaOutDto;
import block7crudvalidation.block7crudvalidation.controller.dto.StudentInputDto;
import block7crudvalidation.block7crudvalidation.controller.dto.StudentOutDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/student")
public class ControllerStudent {
    @Autowired
    StudentServiceImpl studentService;

    @PostMapping
    public ResponseEntity<StudentOutDto> addStudent(@RequestBody StudentInputDto studentInputDto) throws Exception {
        URI location = URI.create("/student");
        return ResponseEntity.created(location).body(studentService.addStudent(studentInputDto));
    }

    @DeleteMapping("delete/{id}")//on delete cascade???
    public ResponseEntity<String> deleteStudentById(@PathVariable int id) {
        studentService.deleteStudentById(id);
        return ResponseEntity.ok().body("el estudiante con id " + id + " ha sido borrado");
    }

    @GetMapping("id/{id}")
    public ResponseEntity<StudentOutDto> getStudentId(@PathVariable int id) {
        try {
            return ResponseEntity.ok().body(studentService.getStudentById(id));

        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("lista")
    public List<StudentOutDto> getAll() {
        return studentService.getListaStudent();
    }

    @GetMapping("nombre/{nombre}")
    public List<StudentOutDto> getByName(@PathVariable String nombre) {
        return studentService.getStudentByName(nombre);
    }

    @PutMapping("/modificar/{id}")
    public ResponseEntity<StudentOutDto> modStudent(@RequestBody StudentInputDto studentInputDto, @PathVariable int id) {
        return ResponseEntity.ok().body(studentService.updateStudent(studentInputDto, id));
    }

}
