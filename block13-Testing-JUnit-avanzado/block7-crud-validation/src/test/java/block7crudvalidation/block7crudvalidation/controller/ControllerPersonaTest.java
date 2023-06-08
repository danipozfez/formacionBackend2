package block7crudvalidation.block7crudvalidation.controller;

import block7crudvalidation.block7crudvalidation.application.PersonaServiceImpl;
import block7crudvalidation.block7crudvalidation.controller.dto.PersonaInputDto;
import block7crudvalidation.block7crudvalidation.controller.dto.PersonaOutDto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class ControllerPersonaTest {
    @Mock
    private PersonaServiceImpl personaService;

    @Mock
    private MyFeign myFeign;

    private ControllerPersona controller;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        controller = new ControllerPersona();
        controller.personaService = personaService;
        controller.myFeign = myFeign;
    }

    @Test
    void addPerson() throws Exception {
        PersonaInputDto inputDto = new PersonaInputDto();
        PersonaOutDto expectedOutputDto = new PersonaOutDto();

        when(personaService.addPersona(inputDto)).thenReturn(expectedOutputDto);

        ResponseEntity<PersonaOutDto> response = controller.addPerson(inputDto);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(expectedOutputDto, response.getBody());

        verify(personaService).addPersona(inputDto);

    }

    @Test
    void getAll() {
        List<PersonaOutDto> expectedList = new ArrayList<>();

        when(personaService.getListaPersonas()).thenReturn(expectedList);

        List<PersonaOutDto> result = controller.getAll();

        assertEquals(expectedList, result);

        verify(personaService).getListaPersonas();
    }

    @Test
    void getByName() {
        String nombre = "pepito";
        List<PersonaOutDto> expectedList = new ArrayList<>();

        when(personaService.getPersonaByName(nombre)).thenReturn(expectedList);

        List<PersonaOutDto> result = controller.getByName(nombre);

        assertEquals(expectedList, result);

        verify(personaService).getPersonaByName(nombre);
    }

    @Test
    void deletePersonaById() {
        int id = 1;

        ResponseEntity<String> response = controller.deletePersonaById(id);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("la persona con id:" + id + " ha sido borrada", response.getBody());

        verify(personaService).deletePersonaById(id);
    }

    @Test
    void modPersona() {
        int id = 1;
        PersonaInputDto inputDto = new PersonaInputDto();
        PersonaOutDto expectedOutputDto = new PersonaOutDto();

        when(personaService.updatePersona(inputDto, id)).thenReturn(expectedOutputDto);

        ResponseEntity<PersonaOutDto> response = controller.modPersona(inputDto, id);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedOutputDto, response.getBody());

        verify(personaService).updatePersona(inputDto, id);
    }

    @Test
    void getPersonaById() {
        int id = 1;
        PersonaOutDto expectedOutputDto = new PersonaOutDto();

        when(personaService.getPersonaById(id)).thenReturn(expectedOutputDto);

        ResponseEntity<PersonaOutDto> response = controller.getPersonaById(id);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedOutputDto, response.getBody());

        verify(personaService).getPersonaById(id);
    }


}