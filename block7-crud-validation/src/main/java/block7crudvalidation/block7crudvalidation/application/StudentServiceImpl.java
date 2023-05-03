package block7crudvalidation.block7crudvalidation.application;

import block7crudvalidation.block7crudvalidation.controller.dto.PersonaOutDto;
import block7crudvalidation.block7crudvalidation.controller.dto.StudentInputDto;
import block7crudvalidation.block7crudvalidation.controller.dto.StudentOutDto;
import block7crudvalidation.block7crudvalidation.domain.Persona;
import block7crudvalidation.block7crudvalidation.domain.Student;
import block7crudvalidation.block7crudvalidation.excepciones.UnprocessableEntityException;
import block7crudvalidation.block7crudvalidation.repository.PersonaRepository;
import block7crudvalidation.block7crudvalidation.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    PersonaRepository personaRepository;
    @Override
    public StudentOutDto addStudent(StudentInputDto studentInputDto) throws Exception {

        if (studentInputDto.getNum_hours_week() == 0)
            throw new UnprocessableEntityException("número de horas obligatorio");
        else if (studentInputDto.getBranch() == null)
            throw new UnprocessableEntityException("rama vacía");
        else {
            //persona= new Persona(persona.getId(),persona.getUsuario(), persona.getPassword(), persona.getName(), persona.getSurName(), persona.getCompanyEmail(), persona.getPersonalEmail(), persona.getCity(), persona.getActive(),persona.getCreatedDate(), persona.getImagenUrl(), persona.getTerminationDate());

            Persona persona = personaRepository.findById(studentInputDto.getId_persona()).orElseThrow();
            Student student = new Student(studentInputDto);

            persona.setStudent(student);
            student.setPersona(persona);

            return studentRepository.save(student).StudentToOutDto();
        }
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
