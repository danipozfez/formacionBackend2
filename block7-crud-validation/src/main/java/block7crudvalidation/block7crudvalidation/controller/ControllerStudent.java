package block7crudvalidation.block7crudvalidation.controller;

import block7crudvalidation.block7crudvalidation.application.StudentServiceImpl;
import block7crudvalidation.block7crudvalidation.controller.dto.StudentInputDto;
import block7crudvalidation.block7crudvalidation.controller.dto.StudentOutDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/student")
public class ControllerStudent {
    @Autowired
    StudentServiceImpl studentService;
    @PostMapping
    public ResponseEntity<StudentOutDto>addStudent(@RequestBody StudentInputDto studentInputDto) throws Exception {
        URI location = URI.create("/student");
        return ResponseEntity.created(location).body(studentService.addStudent(studentInputDto));
    }
    @DeleteMapping("delete/{id}")//on delete cascade???
    public ResponseEntity<String> deleteStudentById(@PathVariable int id) {
        studentService.deleteStudentById(id);
        return ResponseEntity.ok().body("el estudiante con id " + id + " ha sido borrado");
    }

}
