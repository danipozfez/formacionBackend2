package block7crudvalidation.block7crudvalidation.application;

import block7crudvalidation.block7crudvalidation.controller.dto.AsignaturaOutDto;
import block7crudvalidation.block7crudvalidation.controller.dto.StudentInputDto;
import block7crudvalidation.block7crudvalidation.controller.dto.StudentOutDtoFull;
import block7crudvalidation.block7crudvalidation.controller.dto.StudentOutDtoSimple;
import block7crudvalidation.block7crudvalidation.domain.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    StudentOutDtoFull addStudent(StudentInputDto studentInputDto) throws Exception;

    StudentOutDtoFull updateStudent(StudentInputDto studentInputDto, int id);

    void deleteStudentById(int id);

    StudentOutDtoFull getStudentByIdFull(int id);

    StudentOutDtoSimple getStudentByIdSimple(int id);


    List<StudentOutDtoFull> getStudentByName(String nombre);

    List<StudentOutDtoFull> getListaStudent();

    List<StudentOutDtoFull>getlistaStudentByIdProfesor(int id);

    List<AsignaturaOutDto>getListaAsginaturaPorEstudiante(int id);

    StudentOutDtoFull addAsignaturaAEstudiante(List<Integer>listaPorEstudiante, int id);

    StudentOutDtoFull deleteAsignaturaAEstudiante(List<Integer>listaPorEstudiante, int id);

}
