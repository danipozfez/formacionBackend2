package block7crudvalidation.block7crudvalidation.application;

import block7crudvalidation.block7crudvalidation.controller.dto.PersonaInputDto;
import block7crudvalidation.block7crudvalidation.controller.dto.PersonaOutDto;
import block7crudvalidation.block7crudvalidation.domain.Persona;
import block7crudvalidation.block7crudvalidation.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonaServiceImpl implements PersonaService{
    @Autowired
    PersonaRepository personaRepository;

    @Override
    public PersonaOutDto addPersona(PersonaInputDto personaInputDto) throws Exception {
        if (personaInputDto.getUsuario() == null)
            throw new Exception(personaInputDto.getUsuario()+" es nulo");

        if (personaInputDto.getUsuario().length()<6 || personaInputDto.getUsuario().length()>10)
            throw new Exception(personaInputDto.getUsuario()+" no cumple la longitud");
        if (personaInputDto.getUsuario() == null)
            throw new RuntimeException(personaInputDto.getUsuario()+" es null");
        if (personaInputDto.getUsuario() == null)
            throw new RuntimeException(personaInputDto.getUsuario()+" es null");
        if (personaInputDto.getUsuario() == null)
            throw new RuntimeException(personaInputDto.getUsuario()+" es null");
        if (personaInputDto.getUsuario() == null)
            throw new RuntimeException(personaInputDto.getUsuario()+" es null");

        return personaRepository.save(new Persona(personaInputDto)).personaToOutputDto();

    }

    @Override
    public PersonaOutDto getPersonaById(int id) {
        return null;
    }

    @Override
    public List<PersonaOutDto> getPersonaByName(String nombre) {
        return personaRepository.findByName(nombre).stream().
                map(Persona::personaToOutputDto).collect(Collectors.toList());

    }

    @Override
    public List<PersonaOutDto> getListaPersonas() {
        return personaRepository.findAll().stream()
                .map(Persona::personaToOutputDto).toList();

    }
}
