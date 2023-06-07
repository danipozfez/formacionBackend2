package block7crudvalidation.block7crudvalidation.application;

import block7crudvalidation.block7crudvalidation.controller.dto.PersonaInputDto;
import block7crudvalidation.block7crudvalidation.controller.dto.StudentInputDto;
import block7crudvalidation.block7crudvalidation.controller.dto.StudentOutDtoFull;
import block7crudvalidation.block7crudvalidation.domain.Persona;
import block7crudvalidation.block7crudvalidation.domain.Student;
import block7crudvalidation.block7crudvalidation.repository.AsignaturaRepository;
import block7crudvalidation.block7crudvalidation.repository.PersonaRepository;
import block7crudvalidation.block7crudvalidation.repository.ProfesorRepository;
import block7crudvalidation.block7crudvalidation.repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class StudentServiceImplTest {
    @InjectMocks
    private StudentServiceImpl studentService;

    @Mock
    private StudentRepository studentRepository;

    @Mock
    private PersonaRepository personaRepository;

    @Mock
    private ProfesorRepository profesorRepository;

    @Mock
    private AsignaturaRepository asignaturaRepository;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void addStudent() throws Exception {

        PersonaInputDto personaInputDto = new PersonaInputDto(1, "daniel", "password", "pepito", "pérez", "lskdj@kfsj", "skldj@skdfjsl", "Jaén", true, new Date(), "slkdjf", null, null);
        Persona persona = new Persona(personaInputDto);
        StudentInputDto studentInputDto = new StudentInputDto(1,8,"comentario","rama",1,1);
        Student student = new Student(studentInputDto);
        student.setPersona(persona);

        Mockito.when(personaRepository.save(Mockito.any(Persona.class))).thenReturn(persona);
        Mockito.when(studentRepository.findById(1)).thenReturn(null);
        Mockito.when(profesorRepository.findById(1)).thenReturn(null);
        Mockito.when(personaRepository.findById(studentInputDto.getId_persona())).thenReturn(Optional.of(persona));
        Mockito.when(studentRepository.save(Mockito.any(Student.class))).thenReturn(student);

        StudentOutDtoFull estudianteDevuelto = studentService.addStudent(studentInputDto);
        assertNotNull(estudianteDevuelto);
    }

}