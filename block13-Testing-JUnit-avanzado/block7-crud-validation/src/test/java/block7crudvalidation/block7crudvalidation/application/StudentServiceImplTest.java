package block7crudvalidation.block7crudvalidation.application;

import block7crudvalidation.block7crudvalidation.controller.dto.PersonaInputDto;
import block7crudvalidation.block7crudvalidation.controller.dto.StudentInputDto;
import block7crudvalidation.block7crudvalidation.controller.dto.StudentOutDtoFull;
import block7crudvalidation.block7crudvalidation.controller.dto.StudentOutDtoSimple;
import block7crudvalidation.block7crudvalidation.domain.Persona;
import block7crudvalidation.block7crudvalidation.domain.Profesor;
import block7crudvalidation.block7crudvalidation.domain.Student;
import block7crudvalidation.block7crudvalidation.repository.AsignaturaRepository;
import block7crudvalidation.block7crudvalidation.repository.PersonaRepository;
import block7crudvalidation.block7crudvalidation.repository.ProfesorRepository;
import block7crudvalidation.block7crudvalidation.repository.StudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

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
    @Test
    public void testUpdateStudent() {

        PersonaInputDto personaInputDto = new PersonaInputDto(1, "daniel", "password", "pepito", "pérez", "lskdj@kfsj", "skldj@skdfjsl", "Jaén", true, new Date(), "slkdjf", null, null);
        Persona persona = new Persona(personaInputDto);
        StudentInputDto studentInputDto = new StudentInputDto(1,8,"comentario","rama",1,1);
        Student student = new Student(studentInputDto);
        student.setPersona(persona);


        int id = 1;


        Student estudianteActualizado = new Student(studentInputDto);
        estudianteActualizado.setPersona(persona);

        when(studentRepository.findById(id)).thenReturn(Optional.of(student));

        when(studentRepository.save(any(Student.class))).thenReturn(estudianteActualizado);


        Profesor profesorExistente = new Profesor();
        when(profesorRepository.findById(studentInputDto.getIdProfesorAsignado())).thenReturn(Optional.of(profesorExistente));


        StudentOutDtoFull result = studentService.updateStudent(studentInputDto, id);


        assertNotNull(result);

    }
    @Test
    public void testDeleteStudentById() {

        int id = 1;
        PersonaInputDto personaInputDto = new PersonaInputDto(1, "daniel", "password", "pepito", "pérez", "lskdj@kfsj", "skldj@skdfjsl", "Jaén", true, new Date(), "slkdjf", null, null);
        Persona persona = new Persona(personaInputDto);
        StudentInputDto studentInputDto = new StudentInputDto(1,8,"comentario","rama",1,1);
        Student student = new Student(studentInputDto);
        student.setPersona(persona);


        when(studentRepository.findById(id)).thenReturn(Optional.of(student));


        when(personaRepository.findById(student.getPersona().getId())).thenReturn(Optional.of(persona));

        Assertions.assertDoesNotThrow(() -> studentService.deleteStudentById(id));


        verify(studentRepository, times(1)).deleteById(id);

    }

    @Test
    public void testGetStudentByIdFull() {

        int id = 1;
        PersonaInputDto personaInputDto = new PersonaInputDto(1, "daniel", "password", "pepito", "pérez", "lskdj@kfsj", "skldj@skdfjsl", "Jaén", true, new Date(), "slkdjf", null, null);
        Persona persona = new Persona(personaInputDto);
        StudentInputDto studentInputDto = new StudentInputDto(1,8,"comentario","rama",1,1);
        Student student = new Student(studentInputDto);
        student.setPersona(persona);



        when(studentRepository.findById(id)).thenReturn(Optional.of(student));


        StudentOutDtoFull result = studentService.getStudentByIdFull(id);

        assertNotNull(result);

    }

    @Test
    public void testGetStudentByIdSimple() {

        int id = 1;


        Student student = new Student();
        when(studentRepository.findById(id)).thenReturn(Optional.of(student));

        StudentOutDtoSimple result = studentService.getStudentByIdSimple(id);

        assertNotNull(result);

    }

    @Test
    public void testGetStudentByName() {

        String nombre = "pepito";
        PersonaInputDto personaInputDto = new PersonaInputDto(1, "daniel", "password", "pepito", "pérez", "lskdj@kfsj", "skldj@skdfjsl", "Jaén", true, new Date(), "slkdjf", null, null);
        Persona persona = new Persona(personaInputDto);
        StudentInputDto studentInputDto = new StudentInputDto(1,8,"comentario","rama",1,1);
        Student student = new Student(studentInputDto);
        student.setPersona(persona);


        List<Student> estudiantes = new ArrayList<>();
        estudiantes.add(student);
        when(studentRepository.findByPersonaName(nombre)).thenReturn(estudiantes);

        List<StudentOutDtoFull> result = studentService.getStudentByName(nombre);
        assertEquals(estudiantes.size(),result.size());

        assertNotNull(result);

    }

    @Test
    public void testGetListaStudent() {
        // Simulación del repositorio de estudiantes
        List<Student> estudiantes = new ArrayList<>();
        estudiantes.add(new Student());
        when(studentRepository.findAll()).thenReturn(estudiantes);

        // Ejecutar el método que queremos probar
        List<StudentOutDtoSimple> result = studentService.getListaStudent();


        assertNotNull(result);

    }

    @Test
    public void testGetlistaStudentByIdProfesor() {
        // Datos de entrada
        int idProfesorAsignado = 1;
        PersonaInputDto personaInputDto = new PersonaInputDto(1, "daniel", "password", "pepito", "pérez", "lskdj@kfsj", "skldj@skdfjsl", "Jaén", true, new Date(), "slkdjf", null, null);
        Persona persona = new Persona(personaInputDto);
        StudentInputDto studentInputDto = new StudentInputDto(1,8,"comentario","rama",1,1);
        Student student = new Student(studentInputDto);
        student.setPersona(persona);

        List<Student> estudiantes = new ArrayList<>();
        estudiantes.add(student);
        when(studentRepository.findById(idProfesorAsignado)).thenReturn(Optional.of(student));


        List<StudentOutDtoFull> result = studentService.getlistaStudentByIdProfesor(idProfesorAsignado);


        assertNotNull(result);

    }
}

