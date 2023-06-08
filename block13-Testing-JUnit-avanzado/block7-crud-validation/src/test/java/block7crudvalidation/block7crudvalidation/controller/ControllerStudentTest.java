package block7crudvalidation.block7crudvalidation.controller;

import block7crudvalidation.block7crudvalidation.application.StudentServiceImpl;
import block7crudvalidation.block7crudvalidation.controller.dto.StudentInputDto;
import block7crudvalidation.block7crudvalidation.controller.dto.StudentOutDtoFull;
import block7crudvalidation.block7crudvalidation.controller.dto.StudentOutDtoSimple;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class ControllerStudentTest {
    @Mock
    private StudentServiceImpl studentService;

    private ControllerStudent controller;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        controller = new ControllerStudent();
        controller.studentService = studentService;
    }
    @Test
    void addStudent() throws Exception {
        StudentInputDto inputDto = new StudentInputDto();
        StudentOutDtoFull expectedOutputDto = new StudentOutDtoFull();

        when(studentService.addStudent(inputDto)).thenReturn(expectedOutputDto);

        ResponseEntity<StudentOutDtoFull> response = controller.addStudent(inputDto);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(expectedOutputDto, response.getBody());

        verify(studentService).addStudent(inputDto);
    }

    @Test
    void deleteStudentById() {
        int id = 1;

        ResponseEntity<String> response = controller.deleteStudentById(id);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("el estudiante con id " + id + " ha sido borrado", response.getBody());

        verify(studentService).deleteStudentById(id);
    }

    @Test
    void getStudentId() {

    }

    @Test
    void getAll() {
        List<StudentOutDtoSimple> expectedList = new ArrayList<>();

        when(studentService.getListaStudent()).thenReturn(expectedList);

        List<StudentOutDtoSimple> result = controller.getAll();

        assertEquals(expectedList, result);

        verify(studentService).getListaStudent();
    }

    @Test
    void getByName() {
        String nombre = "John Doe";
        List<StudentOutDtoFull> expectedList = new ArrayList<>();

        when(studentService.getStudentByName(nombre)).thenReturn(expectedList);

        List<StudentOutDtoFull> result = controller.getByName(nombre);

        assertEquals(expectedList, result);

        verify(studentService).getStudentByName(nombre);
    }

    @Test
    void modStudent() {
        int id = 1;
        StudentInputDto inputDto = new StudentInputDto();
        StudentOutDtoFull expectedOutputDto = new StudentOutDtoFull();

        when(studentService.updateStudent(inputDto, id)).thenReturn(expectedOutputDto);

        ResponseEntity<StudentOutDtoFull> response = controller.modStudent(inputDto, id);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedOutputDto, response.getBody());

        verify(studentService).updateStudent(inputDto, id);
    }

    @Test
    void addAsignatura() {
        int id = 1;
        List<Integer> listaDeAsignaturas = new ArrayList<>();
        StudentOutDtoSimple expectedOutputDto = new StudentOutDtoSimple();

        when(studentService.addAsignaturaAEstudiante(listaDeAsignaturas, id)).thenReturn(expectedOutputDto);

        ResponseEntity<StudentOutDtoSimple> response = controller.addAsignatura(listaDeAsignaturas, id);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedOutputDto, response.getBody());

        verify(studentService).addAsignaturaAEstudiante(listaDeAsignaturas, id);
    }

    @Test
    void deleteAsignatura() {
        int id = 1;
        List<Integer> listaDeAsignaturas = new ArrayList<>();
        StudentOutDtoFull expectedOutputDto = new StudentOutDtoFull();

        when(studentService.deleteAsignaturaAEstudiante(listaDeAsignaturas, id)).thenReturn(expectedOutputDto);

        ResponseEntity<StudentOutDtoFull> response = controller.deleteAsignatura(listaDeAsignaturas, id);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedOutputDto, response.getBody());

        verify(studentService).deleteAsignaturaAEstudiante(listaDeAsignaturas, id);
    }
}