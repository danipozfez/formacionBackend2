package block7crudvalidation.block7crudvalidation.application;

import block7crudvalidation.block7crudvalidation.controller.dto.StudentInputDto;
import block7crudvalidation.block7crudvalidation.controller.dto.StudentOutDto;
import block7crudvalidation.block7crudvalidation.domain.Student;
import block7crudvalidation.block7crudvalidation.excepciones.UnprocessableEntityException;
import block7crudvalidation.block7crudvalidation.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepository studentRepository;

    @Override
    public StudentOutDto addStudent(StudentInputDto studentInputDto) throws Exception {
        if (studentInputDto.getNum_hours_week() == 0)
            throw new UnprocessableEntityException("número de horas obligatorio");
        else if (studentInputDto.getBranch() == null)
            throw new UnprocessableEntityException("rama vacía");
        else
            return studentRepository.save(new Student(studentInputDto)).StudentToOutDto();
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
