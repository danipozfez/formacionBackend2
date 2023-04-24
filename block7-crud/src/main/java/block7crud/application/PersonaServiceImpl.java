package block7crud.application;

import block7crud.controller.dto.PersonaInputDto;
import block7crud.controller.dto.PersonaOutDto;
import block7crud.domain.Persona;
import block7crud.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PersonaServiceImpl implements PersonaService{
    @Autowired
    PersonaRepository personaRepository;
    @Override
    public PersonaOutDto addPersona(PersonaInputDto personaInputDto) {
        return personaRepository.save(new Persona(personaInputDto)).personaToOutDto();
    }

    @Override
    public PersonaOutDto updatePersona(PersonaInputDto personaInputDto) {
        personaRepository.findById(personaInputDto.getId()).orElseThrow();
        return personaRepository.save(new Persona(personaInputDto)).personaToOutDto();
    }

    @Override
    public void deletePersonaById(int id) {
        personaRepository.findById(id).orElseThrow();
        personaRepository.deleteById(id);
    }

    @Override
    public PersonaOutDto getPersonaById(int id) {
        return personaRepository.findById(id).orElseThrow().personaToOutDto();
    }

    @Override
    public List<Persona> getPersonaByName(String nombre) {
        return null;//personaRepository.findByNombreContainingIgnoreCAse(nombre);
    }


    @Override
    public List<PersonaOutDto> getListaPersonas(int pageNumber, int pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNumber,pageSize);

        return personaRepository.findAll(pageRequest).getContent().stream()
                .map(Persona::personaToOutDto).toList();
    }
}
