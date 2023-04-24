package block7crud.application;

import block7crud.controller.dto.PersonaInputDto;
import block7crud.controller.dto.PersonaOutDto;
import block7crud.domain.Persona;
import block7crud.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonaServiceImpl implements PersonaService{
    @Autowired
    PersonaRepository personaRepository;
    @Override
    public PersonaOutDto addPersona(PersonaInputDto personaInputDto) {
        return personaRepository.save(new Persona(personaInputDto)).personaToOutDto();
    }

    @Override
    public PersonaOutDto updatePersona(PersonaInputDto personaInputDto, int id) {

        Optional<Persona> personaExistente = personaRepository.findById(id);
        Persona personaActualizada = personaExistente.get();

        personaActualizada.setNombre(personaInputDto.getNombre());
        personaActualizada.setEdad(personaInputDto.getEdad());
        personaActualizada.setPoblacion(personaInputDto.getPoblacion());


        return personaRepository.save(personaActualizada).personaToOutDto();
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
    public List<PersonaOutDto> getPersonaByName(String nombre) {
        return personaRepository.findByNombre(nombre).stream().
                map(Persona::personaToOutDto).collect(Collectors.toList());
    }




    @Override
    public List<PersonaOutDto> getListaPersonas() {


        return personaRepository.findAll().stream()
                .map(Persona::personaToOutDto).toList();
    }
}
