package block7crudvalidation.block7crudvalidation.application;
import block7crudvalidation.block7crudvalidation.controller.dto.PersonaInputDto;
import block7crudvalidation.block7crudvalidation.controller.dto.PersonaOutDto;
import block7crudvalidation.block7crudvalidation.domain.Persona;
import block7crudvalidation.block7crudvalidation.repository.PersonaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Date;
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


}