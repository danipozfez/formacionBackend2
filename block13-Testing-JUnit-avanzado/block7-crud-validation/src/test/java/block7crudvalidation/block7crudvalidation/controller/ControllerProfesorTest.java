package block7crudvalidation.block7crudvalidation.controller;

import block7crudvalidation.block7crudvalidation.application.ProfesorServiceImpl;
import block7crudvalidation.block7crudvalidation.controller.dto.ProfesorInputDto;
import block7crudvalidation.block7crudvalidation.controller.dto.ProfesorOutputDto;
import block7crudvalidation.block7crudvalidation.controller.dto.StudentOutDtoSimple;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


class ControllerProfesorTest {

    @Mock
    private ProfesorServiceImpl profesorService;

    private ControllerProfesor controller;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        controller = new ControllerProfesor();
        controller.profesorService = profesorService;
    }

    @Test
    void addProfesor() throws Exception {
        ProfesorInputDto inputDto = new ProfesorInputDto();
        ProfesorOutputDto expectedOutputDto = new ProfesorOutputDto();

        when(profesorService.addProfesor(inputDto)).thenReturn(expectedOutputDto);

        ResponseEntity<ProfesorOutputDto> response = controller.addProfesor(inputDto);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(expectedOutputDto, response.getBody());

        verify(profesorService).addProfesor(inputDto);
    }

    @Test
    void deleteProfesorById() {
        int id = 1;

        ResponseEntity<String> response = controller.deleteProfesorById(id);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("el profesor con id " + id + " ha sido borrado", response.getBody());

        verify(profesorService).deleteProfesorById(id);
    }


    @Test
    void gerProfesorId() {
        int id = 1;
        ProfesorOutputDto expectedOutputDto = new ProfesorOutputDto();

        when(profesorService.getProfesorById(id)).thenReturn(expectedOutputDto);

        ResponseEntity<Object> response = controller.gerProfesorId(id);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedOutputDto, response.getBody());

        verify(profesorService).getProfesorById(id);
    }

    @Test
    void getAll() {
        List<ProfesorOutputDto> expectedList = new ArrayList<>();

        when(profesorService.getListaProfesores()).thenReturn(expectedList);

        List<ProfesorOutputDto> result = controller.getAll();

        assertEquals(expectedList, result);

        verify(profesorService).getListaProfesores();
    }

    @Test
    void getByName() {
        String nombre = "pepito";
        List<ProfesorOutputDto> expectedList = new ArrayList<>();

        when(profesorService.getProfesorByName(nombre)).thenReturn(expectedList);

        List<ProfesorOutputDto> result = controller.getByName(nombre);

        assertEquals(expectedList, result);

        verify(profesorService).getProfesorByName(nombre);
    }

    @Test
    void modStudent() {
        int id = 1;
        ProfesorInputDto inputDto = new ProfesorInputDto();
        ProfesorOutputDto expectedOutputDto = new ProfesorOutputDto();

        when(profesorService.updateProfesor(inputDto, id)).thenReturn(expectedOutputDto);

        ResponseEntity<ProfesorOutputDto> response = controller.modStudent(inputDto, id);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedOutputDto, response.getBody());

        verify(profesorService).updateProfesor(inputDto, id);
    }

    @Test
    void getEtudiantes() {
        int idProfesorAsignado = 1;
        List<StudentOutDtoSimple> expectedList = new ArrayList<>();

        when(profesorService.getListaEstuantesPorProfesor(idProfesorAsignado)).thenReturn(expectedList);

        List<StudentOutDtoSimple> result = controller.getEtudiantes(idProfesorAsignado);

        assertEquals(expectedList, result);

        verify(profesorService).getListaEstuantesPorProfesor(idProfesorAsignado);
    }
}