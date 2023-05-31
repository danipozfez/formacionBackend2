package block13mongodb.block13mongodb.aplication;


import block13mongodb.block13mongodb.controller.dto.PersonaInputDto;
import block13mongodb.block13mongodb.controller.dto.PersonaOutDto;

import java.util.List;

public interface PersonaService {


    PersonaOutDto addPersona(PersonaInputDto personaInputDto) throws Exception;

    PersonaOutDto updatePersona(PersonaInputDto personaInputDto, int id);

    void deletePersonaById(int id);

    PersonaOutDto getPersonaById(int id);

   // List<PersonaOutDto> getPersonaByName(String nombre);

    List<PersonaOutDto> getListaPersonas();
}
