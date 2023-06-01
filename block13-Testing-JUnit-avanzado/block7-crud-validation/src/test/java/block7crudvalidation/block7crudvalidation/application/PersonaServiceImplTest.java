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
        // Arrange
        PersonaInputDto inputDto = new PersonaInputDto(1, "daniel","password", "pepito", "pérez","lskdj@kfsj","skldj@skdfjsl","Jaén",true,new Date(),"slkdjf",null,null);
        // Set the required fields in the inputDto

        Persona persona = new Persona(inputDto);
        PersonaOutDto expectedOutputDto = persona.personaToOutputDto();

        when(personaRepository.save(any(Persona.class))).thenReturn(persona);

        // Act
        PersonaOutDto result = personaService.addPersona(inputDto);

        // Assert
        assertNotNull(result);
        assertEquals(expectedOutputDto, result);
        verify(personaRepository, times(1)).save(any(Persona.class));
    }

    @Test
    void addPersona_InvalidInput_ThrowsException() {
        // Arrange
        PersonaInputDto inputDto = new PersonaInputDto();
        // Set the inputDto with invalid data that should throw exceptions

        // Act & Assert
        assertThrows(UnsupportedOperationException.class, () -> personaService.addPersona(inputDto));
        // Add more assertThrows for other exceptions
    }

    @Test
    void updatePersona_ValidInput_ReturnsUpdatedPersonaOutDto() {
        // Arrange
        int id = 1;
        PersonaInputDto inputDto = new PersonaInputDto(1, "daniel","password", "pepito", "pérez","lskdj@kfsj","skldj@skdfjsl","Jaén",true,new Date(),"slkdjf",null,null);
        // Set the required fields in the inputDto

        Persona personaExistente = new Persona();
        // Set the existing persona data

        Persona personaActualizada = new Persona();
        // Set the expected updated persona data

        when(personaRepository.findById(id)).thenReturn(Optional.of(personaExistente));
        when(personaRepository.save(any(Persona.class))).thenReturn(personaActualizada);

        // Act
        PersonaOutDto result = personaService.updatePersona(inputDto, id);

        // Assert
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

        // Act
        assertDoesNotThrow(() -> personaService.deletePersonaById(id));

        // Assert
        verify(personaRepository, times(1)).findById(id);
        verify(personaRepository, times(1)).deleteById(id);
    }

    @Test
    void deletePersonaById_InvalidId_ThrowsException() {
        // Arrange
        int id = 1;

        when(personaRepository.findById(id)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(EntityNotEncontradaException.class, () -> personaService.deletePersonaById(id));
        verify(personaRepository, times(1)).findById(id);
        verify(personaRepository, never()).deleteById(anyInt());
    }

    @Test
    void getPersonaById_ValidId_ReturnsPersonaOutDto() {
        // Arrange
        int id = 1;
        Persona persona = new Persona();
        PersonaOutDto expectedOutputDto = persona.personaToOutputDto();

        when(personaRepository.findById(id)).thenReturn(Optional.of(persona));

        // Act
        PersonaOutDto result = personaService.getPersonaById(id);

        // Assert
        assertNotNull(result);
        assertEquals(expectedOutputDto, result);
        verify(personaRepository, times(1)).findById(id);
    }

    /*@Test
    void getPersonaById_InvalidId_ThrowsException() {
        // Arrange
        int id = 1;

        when(personaRepository.findById(id)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(EntityNotFoundException.class, () -> personaService.getPersonaById(id));
        verify(personaRepository, times(1)).findById(id);
    }*/

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

        String nombre = "John Doe";

        when(personaRepository.findByName(nombre)).thenReturn(Collections.emptyList());


        assertThrows(EntityNotEncontradaException.class, () -> personaService.getPersonaByName(nombre));
        verify(personaRepository, times(1)).findByName(nombre);
    }

    @Test
    void getListaPersonas_ExistingPersonas_ReturnsListOfPersonaOutDto() {

        Persona persona = new Persona(1, "daniel","password", "pepito", "pérez","lskdj@kfsj","skldj@skdfjsl","Jaén",true,new Date(),"slkdjf",null,null);
        List<Persona> personas = Collections.singletonList(persona);
        List<PersonaOutDto> expectedOutputDtoList = Collections.singletonList(persona.personaToOutputDto());

        when(personaRepository.findAll()).thenReturn(personas);


        List<PersonaOutDto> result = personaService.getListaPersonas();


        assertNotNull(result);
        assertEquals(expectedOutputDtoList, result);
        verify(personaRepository, times(1)).findAll();
    }

    @Test
    void getListaPersonas_NoPersonas_ThrowsException() {
        // Arrange
        when(personaRepository.findAll()).thenReturn(Collections.emptyList());

        // Act & Assert
        assertThrows(EntityNotEncontradaException.class, () -> personaService.getListaPersonas());
        verify(personaRepository, times(1)).findAll();
    }


}