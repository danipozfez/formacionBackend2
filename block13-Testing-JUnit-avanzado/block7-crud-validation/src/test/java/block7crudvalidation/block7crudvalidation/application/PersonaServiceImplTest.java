package block7crudvalidation.block7crudvalidation.application;

import block7crudvalidation.block7crudvalidation.controller.dto.PersonaInputDto;
import block7crudvalidation.block7crudvalidation.controller.dto.PersonaOutDto;
import block7crudvalidation.block7crudvalidation.domain.Persona;
import block7crudvalidation.block7crudvalidation.excepciones.EntityNotEncontradaException;
import block7crudvalidation.block7crudvalidation.repository.PersonaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class PersonaServiceImplTest {
    @Mock
    private PersonaRepository personaRepository;

    @InjectMocks
    private PersonaServiceImpl personaService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void addPersona_ValidInput_ReturnsPersonaOutDto() throws Exception {

        PersonaInputDto inputDto = new PersonaInputDto(1, "daniel", "password", "pepito", "pérez", "lskdj@kfsj", "skldj@skdfjsl", "Jaén", true, new Date(), "slkdjf", null, null);

        Persona persona = new Persona(inputDto);
        PersonaOutDto expectedOutputDto = persona.personaToOutputDto();
        when(personaRepository.save(any(Persona.class))).thenReturn(persona);
        PersonaOutDto result = personaService.addPersona(inputDto);
        assertNotNull(result);
        assertEquals(expectedOutputDto, result);
        verify(personaRepository, times(1)).save(any(Persona.class));
    }

    @Test
    void addPersona_InvalidInput_ThrowsException() {

        PersonaInputDto inputDto = new PersonaInputDto();

        assertThrows(UnsupportedOperationException.class, () -> personaService.addPersona(inputDto));

    }

    @Test
    void updatePersona_ValidInput_ReturnsUpdatedPersonaOutDto() {

        int id = 1;
        PersonaInputDto inputDto = new PersonaInputDto(1, "daniel", "password", "pepito", "pérez", "lskdj@kfsj", "skldj@skdfjsl", "Jaén", true, new Date(), "slkdjf", null, null);

        Persona personaExistente = new Persona();

        Persona personaActualizada = new Persona();

        when(personaRepository.findById(id)).thenReturn(Optional.of(personaExistente));
        when(personaRepository.save(any(Persona.class))).thenReturn(personaActualizada);
        PersonaOutDto result = personaService.updatePersona(inputDto, id);

        assertNotNull(result);
        assertEquals(personaActualizada.personaToOutputDto(), result);
        verify(personaRepository, times(1)).findById(id);
        verify(personaRepository, times(1)).save(any(Persona.class));
    }

    @Test
    void deletePersonaById_ValidId_SuccessfullyDeleted() {
        // Arrange
        int id = 1;

        when(personaRepository.findById(id)).thenReturn(Optional.of(new Persona()));

        assertDoesNotThrow(() -> personaService.deletePersonaById(id));

        verify(personaRepository, times(1)).findById(id);
        verify(personaRepository, times(1)).deleteById(id);
    }


    @Test
    void getPersonaById_ValidId_ReturnsPersonaOutDto() {

        int id = 1;
        Persona persona = new Persona(1, "daniel", "password", "pepito", "pérez", "lskdj@kfsj", "skldj@skdfjsl", "Jaén", true, new Date(), "slkdjf", null, null);
        PersonaOutDto expectedOutputDto = persona.personaToOutputDto();
        when(personaRepository.findById(id)).thenReturn(Optional.of(persona));
        PersonaOutDto result = personaService.getPersonaById(id);
        assertNotNull(result);
        assertEquals(expectedOutputDto, result);
        verify(personaRepository, times(1)).findById(id);
    }


    @Test
    void getPersonaByName_ValidName_ReturnsListOfPersonaOutDto() {

        String nombre = "Daniel";
        Persona persona = new Persona();
        List<Persona> personas = Collections.singletonList(persona);
        List<PersonaOutDto> expectedOutputDtoList = Collections.singletonList(persona.personaToOutputDto());
        when(personaRepository.findByName(nombre)).thenReturn(personas);
        List<PersonaOutDto> result = personaService.getPersonaByName(nombre);
        assertNotNull(result);
        assertEquals(expectedOutputDtoList, result);
        verify(personaRepository, times(1)).findByName(nombre);
    }

    @Test
    void getPersonaByName_InvalidName_ThrowsException() {

        String nombre = "Daniel";
        when(personaRepository.findByName(nombre)).thenReturn(Collections.emptyList());
        assertThrows(EntityNotEncontradaException.class, () -> personaService.getPersonaByName(nombre));
        verify(personaRepository, times(1)).findByName(nombre);
    }

    @Test
    void getListaPersonas_ExistingPersonas_ReturnsListOfPersonaOutDto() {

        Persona persona = new Persona(1, "daniel", "password", "pepito", "pérez", "lskdj@kfsj", "skldj@skdfjsl", "Jaén", true, new Date(), "slkdjf", null, null);
        List<Persona> personas = Collections.singletonList(persona);
        List<PersonaOutDto> expectedOutputDtoList = Collections.singletonList(persona.personaToOutputDto());
        when(personaRepository.findAll()).thenReturn(personas);
        List<PersonaOutDto> result = personaService.getListaPersonas();
        assertNotNull(result);
        assertEquals(expectedOutputDtoList.size(), result.size());

    }

    @Test
    void getListaPersonas_NoPersonas_ThrowsException() {

        when(personaRepository.findAll()).thenReturn(Collections.emptyList());
        assertThrows(EntityNotFoundException.class, () -> personaService.getListaPersonas());
        verify(personaRepository, times(1)).findAll();
    }


}