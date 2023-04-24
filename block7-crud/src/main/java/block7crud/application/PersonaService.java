package block7crud.application;

import block7crud.controller.dto.PersonaInputDto;
import block7crud.controller.dto.PersonaOutDto;
import block7crud.domain.Persona;

import java.util.List;

public interface PersonaService {

    PersonaOutDto addPersona(PersonaInputDto personaInputDto);
    PersonaOutDto updatePersona(PersonaInputDto personaInputDto);

    void  deletePersonaById(int id);
    PersonaOutDto getPersonaById(int id);

    List<Persona> getPersonaByName(String nombre);

    List<PersonaOutDto> getListaPersonas(int pageNumber, int pageSize);


}
