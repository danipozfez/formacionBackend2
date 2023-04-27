package block7crudvalidation.block7crudvalidation.application;

import block7crudvalidation.block7crudvalidation.controller.dto.PersonaInputDto;
import block7crudvalidation.block7crudvalidation.controller.dto.PersonaOutDto;
import block7crudvalidation.block7crudvalidation.controller.dto.StudentInputDto;
import block7crudvalidation.block7crudvalidation.controller.dto.StudentOutDto;

import java.util.List;

public interface StudentService {
    StudentOutDto addStudent(StudentInputDto studentInputDto) throws Exception;

    StudentOutDto updateStudent(StudentInputDto studentInputDto, int id);

    void deleteStudentById(int id);

    StudentOutDto getStudentById(int id);

    List<StudentOutDto> getStudentByName(String nombre);

    List<StudentOutDto> getListaStudent();
}
