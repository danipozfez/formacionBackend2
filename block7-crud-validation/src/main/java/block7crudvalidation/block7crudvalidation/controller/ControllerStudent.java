package block7crudvalidation.block7crudvalidation.controller;

import block7crudvalidation.block7crudvalidation.application.StudentServiceImpl;
import block7crudvalidation.block7crudvalidation.controller.dto.StudentInputDto;
import block7crudvalidation.block7crudvalidation.controller.dto.StudentOutDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
