package block7crudvalidation.block7crudvalidation.application;

import block7crudvalidation.block7crudvalidation.controller.dto.PersonaInputDto;
import block7crudvalidation.block7crudvalidation.controller.dto.PersonaOutDto;

import java.util.List;

public interface PersonaService {


    PersonaOutDto addPersona(PersonaInputDto personaInputDto) throws Exception;

    PersonaOutDto updatePersona(PersonaInputDto personaInputDto, int id);

    void deletePersonaById(int id);

    PersonaOutDto getPersonaById(int id);

    List<PersonaOutDto> getPersonaByName(String nombre);

    List<PersonaOutDto> getListaPersonas();
}
