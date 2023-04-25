package block7crudvalidation.block7crudvalidation.application;

import block7crudvalidation.block7crudvalidation.controller.dto.PersonaInputDto;
import block7crudvalidation.block7crudvalidation.controller.dto.PersonaOutDto;
import block7crudvalidation.block7crudvalidation.domain.Persona;
import block7crudvalidation.block7crudvalidation.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PersonaServiceImpl implements PersonaService{
    @Autowired
    PersonaRepository personaRepository;

    @Override
    public PersonaOutDto addPersona(PersonaInputDto personaInputDto) {
        return personaRepository.save(new Persona(personaInputDto)).personaToOutputDto();

    }

    @Override
    public PersonaOutDto getPersonaById(int id) {
        return null;
    }

    @Override
    public List<PersonaOutDto> getPersonaByName(String nombre) {
        return null;
    }

    @Override
    public List<PersonaOutDto> getListaPersonas() {
        return personaRepository.findAll().stream()
                .map(Persona::personaToOutputDto).toList();

    }
}
