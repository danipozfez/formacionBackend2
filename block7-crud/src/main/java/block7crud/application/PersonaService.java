package block7crud.application;

import block7crud.controller.dto.PersonaInputDto;
import block7crud.controller.dto.PersonaOutDto;
import block7crud.domain.Persona;

import java.util.List;

public interface PersonaService {

    PersonaOutDto addPersona(PersonaInputDto personaInputDto);
    PersonaOutDto updatePersona(PersonaInputDto personaInputDto,int id);

    void  deletePersonaById(int id);
    PersonaOutDto getPersonaById(int id);

    List<PersonaOutDto> getPersonaByName(String nombre);

    List<PersonaOutDto> getListaPersonas();


}
