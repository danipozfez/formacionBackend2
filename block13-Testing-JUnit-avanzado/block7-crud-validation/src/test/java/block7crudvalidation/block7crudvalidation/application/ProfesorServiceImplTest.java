package block7crudvalidation.block7crudvalidation.application;

import block7crudvalidation.block7crudvalidation.controller.dto.*;
import block7crudvalidation.block7crudvalidation.domain.Persona;
import block7crudvalidation.block7crudvalidation.domain.Profesor;
import block7crudvalidation.block7crudvalidation.domain.Student;
import block7crudvalidation.block7crudvalidation.excepciones.EntityNotEncontradaException;
import block7crudvalidation.block7crudvalidation.excepciones.UnprocessableEntityException;
import block7crudvalidation.block7crudvalidation.repository.PersonaRepository;
import block7crudvalidation.block7crudvalidation.repository.ProfesorRepository;
import block7crudvalidation.block7crudvalidation.repository.StudentRepository;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProfesorServiceImplTest {

    @Mock
    private ProfesorRepository profesorRepository;

    @Mock
    private PersonaRepository personaRepository;

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private ProfesorServiceImpl profesorService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void addProfesor_ValidInput_ReturnsProfesorOutputDto() {

        List<Student> estudiantes = new ArrayList<>();


        PersonaInputDto personaInputDto = new PersonaInputDto(1, "daniel", "password", "pepito", "pérez", "lskdj@kfsj", "skldj@skdfjsl", "Jaén", true, new Date(), "slkdjf", new Date(), null);
        Persona persona = new Persona(personaInputDto);
        persona.setId(1);

        Mockito.when(personaRepository.save(any(Persona.class))).thenReturn(persona);
        Mockito.when(personaRepository.findById(persona.getId())).thenReturn(Optional.of(persona));

        ProfesorInputDto profesorInputDto = new ProfesorInputDto(1, 1, "comentario", "prueba");
        Profesor profesor = new Profesor(1, persona, "comentarios", "prueba", null);
        Mockito.when(profesorRepository.save(any(Profesor.class))).thenReturn(profesor);
        Mockito.when(profesorRepository.existsById(profesorInputDto.getId_persona())).thenReturn(false);
        // Act
        ProfesorOutputDto result = profesorService.addProfesor(profesorInputDto);

        assertNotNull(result);
        verify(profesorRepository, times(1)).existsById(profesorInputDto.getId_persona());
        verify(personaRepository, times(1)).findById(profesorInputDto.getId_persona());
        verify(profesorRepository, times(1)).save(any(Profesor.class));
    }

    @Test
    void addProfesor_InvalidInput_ThrowsException() {

        ProfesorInputDto inputDto = new ProfesorInputDto();

        assertThrows(UnprocessableEntityException.class, () -> profesorService.addProfesor(inputDto));
        verify(profesorRepository, never()).existsById(anyInt());
        verify(personaRepository, never()).findById(anyInt());
        verify(profesorRepository, never()).save(any(Profesor.class));
    }

    @Test
    void updateProfesor_ValidInput_ReturnsUpdatedProfesorOutputDto() {
        int id = 1;
        List<Student> estudiantes = new ArrayList<>();


        ProfesorInputDto profesorInputDto = new ProfesorInputDto(1, 1, "comentario", "prueba");
        Profesor profesorExistente = new Profesor(1, new Persona(1, "daniel", "password", "pepito", "pérez", "lskdj@kfsj", "skldj@skdfjsl", "Jaén", true, new Date(), "slkdjf", null, null), "comentario", "rama", estudiantes);

        Profesor profesorActualizado = new Profesor(1, new Persona(1, "daniel", "password", "pepito", "pérez", "lskdj@kfsj", "skldj@skdfjsl", "Jaén", true, new Date(), "slkdjf", null, null), "comentario2", "rama", estudiantes);

        when(profesorRepository.findById(id)).thenReturn(Optional.of(profesorExistente));
        when(profesorRepository.save(any(Profesor.class))).thenReturn(profesorActualizado);

        ProfesorOutputDto result = profesorService.updateProfesor(profesorInputDto, id);

        assertNotNull(result);
        verify(profesorRepository, times(1)).findById(id);
        verify(profesorRepository, times(1)).save(any(Profesor.class));
    }

    @Test
    void deleteProfesorById_ValidId_SuccessfullyDeleted() {
        // Arrange
        int id = 1;
        List<Student> estudiantes = null;
        Profesor profesor = new Profesor(1, new Persona(1, "daniel", "password", "pepito", "pérez", "lskdj@kfsj", "skldj@skdfjsl", "Jaén", true, new Date(), "slkdjf", null, null), "comentario", "rama", estudiantes);

        when(profesorRepository.findById(id)).thenReturn(Optional.of(profesor));
        when(personaRepository.findById(profesor.getPersona().getId())).thenReturn(Optional.of(new Persona()));


        assertDoesNotThrow(() -> profesorService.deleteProfesorById(id));


        verify(profesorRepository, times(1)).deleteById(id);
        verify(personaRepository, times(1)).findById(profesor.getPersona().getId());

    }

    @Test
    void deleteProfesorById_InvalidId_ThrowsException() {
        // Arrange
        int id = 1;
        List<Student> estudiantes = null;

        Profesor profesor = new Profesor(1, new Persona(1, "daniel", "password", "pepito", "pérez", "lskdj@kfsj", "skldj@skdfjsl", "Jaén", true, new Date(), "slkdjf", null, null), "comentario", "rama", estudiantes);

        when(profesorRepository.findById(id)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(NoSuchElementException.class, () -> profesorService.deleteProfesorById(id));
        verify(profesorRepository, times(1)).findById(id);
        verify(profesorRepository, never()).deleteById(anyInt());
        verify(personaRepository, never()).findById(anyInt());
        verify(personaRepository, never()).save(any(Persona.class));
    }

    @Test
    void getProfesorById_ValidId_ReturnsProfesorOutputDto() {
        // Arrange
        int id = 1;
        Profesor profesor = new Profesor(1, new Persona(1, "daniel", "password", "pepito", "pérez", "lskdj@kfsj", "skldj@skdfjsl", "Jaén", true, new Date(), "slkdjf", null, null), "comentario", "rama", null);
        ProfesorOutputDto expectedOutputDto = profesor.profesorToOutputDto();

        when(profesorRepository.findById(id)).thenReturn(Optional.of(profesor));

        // Act
        ProfesorOutputDto result = profesorService.getProfesorById(id);

        // Assert
        assertNotNull(result);
        //en vez de comparar la referencia de los dos objetos comparo dos propiedades, en este caso el id
        assertEquals(expectedOutputDto.getId_profesor(), result.getId_profesor());
        verify(profesorRepository, times(1)).findById(id);
    }

    @Test
    void getProfesorById_InvalidId_ThrowsException() {
        // Arrange
        int id = 1;

        when(profesorRepository.findById(id)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(NoSuchElementException.class, () -> profesorService.getProfesorById(id));
        verify(profesorRepository, times(1)).findById(id);
    }

    @Test
    void getProfesorByName_ValidName_ReturnsListOfProfesorOutputDto() {
        // Arrange
        String nombre = "pepito";
        Profesor profesor = new Profesor(1, new Persona(1, "daniel", "password", "pepito", "pérez", "lskdj@kfsj", "skldj@skdfjsl", "Jaén", true, new Date(), "slkdjf", null, null), "comentario", "rama", null);
        List<Profesor> profesores = Collections.singletonList(profesor);
        List<ProfesorOutputDto> expectedOutputDtoList = Collections.singletonList(profesor.profesorToOutputDto());

        when(profesorRepository.findByPersonaName(nombre)).thenReturn(profesores);

        // Act
        List<ProfesorOutputDto> result = profesorService.getProfesorByName(nombre);

        // Assert
        assertNotNull(result);
        //assertEquals(expectedOutputDtoList, result);
        verify(profesorRepository, times(1)).findByPersonaName(nombre);
    }

    @Test
    void getProfesorByName_InvalidName_ThrowsException() {
        // Arrange
        String nombre = "pepito";

        when(profesorRepository.findByPersonaName(nombre)).thenReturn(Collections.emptyList());

        // Act & Assert
        assertThrows(EntityNotEncontradaException.class, () -> profesorService.getProfesorByName(nombre));
        verify(profesorRepository, times(1)).findByPersonaName(nombre);
    }

    @Test
    void getListaProfesores_ExistingProfesores_ReturnsListOfProfesorOutputDto() {
        // Arrange
        Profesor profesor = new Profesor(1, new Persona(1, "daniel", "password", "pepito", "pérez", "lskdj@kfsj", "skldj@skdfjsl", "Jaén", true, new Date(), "slkdjf", null, null), "comentario", "rama", null);

        List<Profesor> profesores = Collections.singletonList(profesor);
        List<ProfesorOutputDto> expectedOutputDtoList = Collections.singletonList(profesor.profesorToOutputDto());

        when(profesorRepository.findAll()).thenReturn(profesores);

        // Act
        List<ProfesorOutputDto> result = profesorService.getListaProfesores();

        // Assert
        assertNotNull(result);
        assertEquals(expectedOutputDtoList.size(), result.size());
        // verify(profesorRepository, times(1)).findAll();
    }

    @Test
    void getListaProfesores_NoProfesores_ThrowsException() {
        // Arrange
        when(profesorRepository.findAll()).thenReturn(Collections.emptyList());

        // Act & Assert
        assertThrows(EntityNotEncontradaException.class, () -> profesorService.getListaProfesores());
        verify(profesorRepository, times(1)).findAll();
    }

   /* @Test
    void getListaEstuantesPorProfesor_ValidId_ReturnsListOfStudentOutDtoSimple() {
        // Arrange
        int id = 1;
        StudentOutDtoSimple student = new StudentOutDtoSimple();
        student.setIdProfesorAsignado(id);
        List<StudentOutDtoSimple> estudiantes = Collections.singletonList(student);

        when(studentRepository.findAll()).thenReturn(estudiantes);

        // Act
        List<StudentOutDtoSimple> result = profesorService.getListaEstuantesPorProfesor(id);

        // Assert
        assertNotNull(result);
        assertEquals(estudiantes.size(), result.size());

        for (int i = 0; i < estudiantes.size(); i++) {
            assertEquals(estudiantes.get(i).getIdProfesorAsignado(), result.get(i).getIdProfesorAsignado());
            // Comparar las demás propiedades relevantes aquí
        }

        verify(studentRepository, times(1)).findAll();
    }*/


    @Test
    void getListaEstuantesPorProfesor_NoEstudiantes_ThrowsException() {
        // Arrange
        int id = 1;
        when(studentRepository.findAll()).thenReturn(Collections.emptyList());

        // Act & Assert
        assertThrows(EntityNotEncontradaException.class, () -> profesorService.getListaEstuantesPorProfesor(id));
        verify(studentRepository, times(1)).findAll();
    }

}
