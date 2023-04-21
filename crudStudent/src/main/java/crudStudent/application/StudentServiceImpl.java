package crudStudent.application;

import crudStudent.controller.dto.StudentInputDto;
import crudStudent.controller.dto.StudentOutputDto;
import crudStudent.domain.Student;
import crudStudent.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    StudentRepository studentRepository;
    @Override
    public StudentOutputDto addStudent(StudentInputDto student) {
        return studentRepository.save(new Student(student)).studentToStudentOutputDto();
    }

    @Override
    public StudentOutputDto getStudentById(int id) {
        return studentRepository.findById(id).orElseThrow().studentToStudentOutputDto();
    }

    @Override
    public void deleteStudentByID(int id) {
        studentRepository.findById(id).orElseThrow();
        studentRepository.deleteById(id);
    }

    @Override
    public Iterable<StudentOutputDto> getAllStudents(int pageNumer, int pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNumer,pageSize);
        return studentRepository.findAll(pageRequest).getContent().stream().
                map(Student::studentToStudentOutputDto).toList();
    }

    @Override
    public StudentOutputDto updateStudent(StudentInputDto studentInputDto) {
        studentRepository.findById(studentInputDto.getId()).orElseThrow();
        return studentRepository.save(new Student(studentInputDto)).studentToStudentOutputDto();
    }
}
