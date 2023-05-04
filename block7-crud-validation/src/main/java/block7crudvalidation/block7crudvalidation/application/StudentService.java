package block7crudvalidation.block7crudvalidation.application;

import block7crudvalidation.block7crudvalidation.controller.dto.StudentInputDto;
import block7crudvalidation.block7crudvalidation.controller.dto.StudentOutDtoFull;
import block7crudvalidation.block7crudvalidation.controller.dto.StudentOutDtoSimple;

import java.util.List;

public interface StudentService {
    StudentOutDtoFull addStudent(StudentInputDto studentInputDto) throws Exception;

    StudentOutDtoFull updateStudent(StudentInputDto studentInputDto, int id);

    void deleteStudentById(int id);

    StudentOutDtoFull getStudentByIdFull(int id);

    StudentOutDtoSimple getStudentByIdSimple(int id);


    List<StudentOutDtoFull> getStudentByName(String nombre);

    List<StudentOutDtoFull> getListaStudent();
}
