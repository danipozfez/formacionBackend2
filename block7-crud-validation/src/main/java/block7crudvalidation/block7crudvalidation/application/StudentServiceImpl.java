package block7crudvalidation.block7crudvalidation.application;

import block7crudvalidation.block7crudvalidation.controller.dto.StudentInputDto;
import block7crudvalidation.block7crudvalidation.controller.dto.StudentOutDtoFull;
import block7crudvalidation.block7crudvalidation.controller.dto.StudentOutDtoSimple;
import block7crudvalidation.block7crudvalidation.domain.Persona;
import block7crudvalidation.block7crudvalidation.domain.Student;
import block7crudvalidation.block7crudvalidation.excepciones.EntityNotEncontradaException;
import block7crudvalidation.block7crudvalidation.excepciones.UnprocessableEntityException;
import block7crudvalidation.block7crudvalidation.repository.PersonaRepository;
import block7crudvalidation.block7crudvalidation.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service

public class StudentServiceImpl implements StudentService {
    @Autowired
    //@Resource
    StudentRepository studentRepository;
    @Autowired
    PersonaRepository personaRepository;
    @Override
    public StudentOutDtoFull addStudent(StudentInputDto studentInputDto) throws Exception {

        if (studentInputDto.getNum_hours_week() == 0)
            throw new UnprocessableEntityException("número de horas obligatorio");
        else if (studentInputDto.getBranch() == null)
            throw new UnprocessableEntityException("rama vacía");
        else {
            //persona= new Persona(persona.getId(),persona.getUsuario(), persona.getPassword(), persona.getName(), persona.getSurName(), persona.getCompanyEmail(), persona.getPersonalEmail(), persona.getCity(), persona.getActive(),persona.getCreatedDate(), persona.getImagenUrl(), persona.getTerminationDate());
            if(studentRepository.existsById(studentInputDto.getId_persona()))
                throw new UnprocessableEntityException("error, el estudiante ya ha sido añadido");
            Persona persona = personaRepository.findById(studentInputDto.getId_persona()).orElseThrow();
            Student student = new Student(studentInputDto);

            persona.setStudent(student);
            student.setPersona(persona);

            return studentRepository.save(student).studentToOutDtoFull();
        }
    }

    @Override
    public StudentOutDtoFull updateStudent(StudentInputDto studentInputDto, int id) {
        Optional<Student> estudianteExistente = studentRepository.findById(id);
        Student estudianteActualizado = estudianteExistente.get();

        if (estudianteExistente.isEmpty()) {//revisar
            throw new EntityNotEncontradaException("persona no encontrada");

        } else {
            estudianteActualizado.setBranch(studentInputDto.getBranch());
            estudianteActualizado.setComents(studentInputDto.getComents());
            estudianteActualizado.setNum_hours_week(studentInputDto.getNum_hours_week());


            return studentRepository.save(estudianteActualizado).studentToOutDtoFull();
        }
    }

    @Override
    public void deleteStudentById(int id) {
        if (studentRepository.findById(id).isEmpty())
            throw new EntityNotEncontradaException("estudiante no encontrado");
        else
            studentRepository.deleteById(id);

    }

    @Override
    public StudentOutDtoFull getStudentByIdFull(int id) {
        return studentRepository.findById(id).orElseThrow().studentToOutDtoFull();
    }

    @Override
    public StudentOutDtoSimple getStudentByIdSimple(int id) {
        return studentRepository.findById(id).orElseThrow().studentOutDtoSimple();
    }


    @Override
    public List<StudentOutDtoFull> getStudentByName(String nombre) {
        List<StudentOutDtoFull> listaEstudiantes = studentRepository.findByPersonaName(nombre).stream().
                map(Student::studentToOutDtoFull).collect(Collectors.toList());
        if (listaEstudiantes.size() != 0)
            return listaEstudiantes;
        else
            throw new EntityNotEncontradaException("no se ha encontrado ningún estudiante con ese name");

    }



    @Override
    public List<StudentOutDtoFull> getListaStudent() {
       if (studentRepository.findAll().stream().map(Student::studentToOutDtoFull).toList().size()!=0)
           return studentRepository.findAll().stream().map(Student::studentToOutDtoFull).toList();
       else
           throw new EntityNotEncontradaException("no hay ningún estudiante");
    }
}
