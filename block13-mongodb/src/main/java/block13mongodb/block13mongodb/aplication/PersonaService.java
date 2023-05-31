package block13mongodb.block13mongodb.aplication;


import block13mongodb.block13mongodb.controller.dto.PersonaInputDto;
import block13mongodb.block13mongodb.controller.dto.PersonaOutDto;

import java.util.List;
import java.util.UUID;

public interface PersonaService {


    PersonaOutDto addPersona(PersonaInputDto personaInputDto) throws Exception;

    PersonaOutDto updatePersona(PersonaInputDto personaInputDto, UUID id);

    void deletePersonaById(UUID id);

    PersonaOutDto getPersonaById(UUID id);

   // List<PersonaOutDto> getPersonaByName(String nombre);

    List<PersonaOutDto> getListaPersonas();
}
