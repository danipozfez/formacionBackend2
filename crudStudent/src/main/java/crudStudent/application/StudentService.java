package crudStudent.application;

import crudStudent.controller.dto.StudentInputDto;
import crudStudent.controller.dto.StudentOutputDto;
import crudStudent.domain.Student;

public interface StudentService {

    StudentOutputDto addStudent (StudentInputDto student);
    StudentOutputDto getStudentById(int id);
    void deleteStudentByID(int id);
    Iterable<StudentOutputDto>getAllStudents(int pageNumer,int pageSize);
    StudentOutputDto updateStudent(StudentInputDto studentInputDto);
}
