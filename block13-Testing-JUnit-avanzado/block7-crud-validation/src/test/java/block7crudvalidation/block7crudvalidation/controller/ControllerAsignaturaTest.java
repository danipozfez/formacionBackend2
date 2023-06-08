package block7crudvalidation.block7crudvalidation.controller;

import block7crudvalidation.block7crudvalidation.application.AsignaturaServiceImpl;
import block7crudvalidation.block7crudvalidation.application.StudentServiceImpl;
import block7crudvalidation.block7crudvalidation.controller.dto.AsignaturaInputDto;
import block7crudvalidation.block7crudvalidation.controller.dto.AsignaturaOutDto;
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

class ControllerAsignaturaTest {
    @Mock
    private AsignaturaServiceImpl asignaturaService;

    @Mock
    private StudentServiceImpl studentService;

    private ControllerAsignatura controller;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        controller = new ControllerAsignatura();
        controller.asignaturaService = asignaturaService;
        controller.studentService = studentService;
    }
    @Test
    void addAsignatura() {
        AsignaturaInputDto inputDto = new AsignaturaInputDto();
        AsignaturaOutDto expectedOutputDto = new AsignaturaOutDto();

        when(asignaturaService.addAsignatura(inputDto)).thenReturn(expectedOutputDto);

        ResponseEntity<AsignaturaOutDto> response = controller.addAsignatura(inputDto);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(expectedOutputDto, response.getBody());

        verify(asignaturaService).addAsignatura(inputDto);
    }


    @Test
    void getAll() {
        List<AsignaturaOutDto> expectedList = new ArrayList<>();

        when(asignaturaService.getListaAsignaturas()).thenReturn(expectedList);

        List<AsignaturaOutDto> result = controller.getAll();

        assertEquals(expectedList, result);

        verify(asignaturaService).getListaAsignaturas();
    }

    @Test
    void deleteAsignaturaById() {
        int id = 1;

        ResponseEntity<String> response = controller.deleteAsignaturaById(id);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("asignatura con id:" + id + " borrada", response.getBody());

        verify(asignaturaService).deleteAsignaturaById(id);
    }

    @Test
    void modAsignatura() {
        int id = 1;
        AsignaturaInputDto inputDto = new AsignaturaInputDto();
        AsignaturaOutDto expectedOutputDto = new AsignaturaOutDto();

        when(asignaturaService.updateAsignatura(inputDto, id)).thenReturn(expectedOutputDto);

        ResponseEntity<AsignaturaOutDto> response = controller.modAsignatura(inputDto, id);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedOutputDto, response.getBody());

        verify(asignaturaService).updateAsignatura(inputDto, id);
    }

    @Test
    void getAsignaturaById() {
        int id = 1;
        AsignaturaOutDto expectedOutputDto = new AsignaturaOutDto();

        when(asignaturaService.getAsignaturaById(id)).thenReturn(expectedOutputDto);

        ResponseEntity<AsignaturaOutDto> response = controller.getAsignaturaById(id);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedOutputDto, response.getBody());

        verify(asignaturaService).getAsignaturaById(id);
    }

    @Test
    void getAsignaturasById() {
        int id = 1;
        List<StudentOutDtoSimple> expectedList = new ArrayList<>();

        when(asignaturaService.getStudentByAsignatura(id)).thenReturn(expectedList);

        ResponseEntity<List<StudentOutDtoSimple>> response = controller.getAsignaturasById(id);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedList, response.getBody());

        verify(asignaturaService).getStudentByAsignatura(id);
    }
}