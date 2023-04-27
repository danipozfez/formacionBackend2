package block7crudvalidation.block7crudvalidation.application;

import block7crudvalidation.block7crudvalidation.controller.dto.StudentInputDto;
import block7crudvalidation.block7crudvalidation.controller.dto.StudentOutDto;

import java.util.List;

public class StudentServiceImpl implements StudentService
{
    @Override
    public StudentOutDto addStudent(StudentInputDto studentInputDto) throws Exception {
        return null;
    }

    @Override
    public StudentOutDto updateStudent(StudentInputDto studentInputDto, int id) {
        return null;
    }

    @Override
    public void deleteStudentById(int id) {

    }

    @Override
    public StudentOutDto getStudentById(int id) {
        return null;
    }

    @Override
    public List<StudentOutDto> getStudentByName(String nombre) {
        return null;
    }

    @Override
    public List<StudentOutDto> getListaStudent() {
        return null;
    }
}
