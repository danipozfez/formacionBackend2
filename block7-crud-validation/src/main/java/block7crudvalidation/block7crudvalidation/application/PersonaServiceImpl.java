package block7crudvalidation.block7crudvalidation.application;

import block7crudvalidation.block7crudvalidation.controller.dto.PersonaInputDto;
import block7crudvalidation.block7crudvalidation.controller.dto.PersonaOutDto;
import block7crudvalidation.block7crudvalidation.domain.Persona;
import block7crudvalidation.block7crudvalidation.excepciones.EntityNotEncontradaException;
import block7crudvalidation.block7crudvalidation.excepciones.UnprocessableEntityException;
import block7crudvalidation.block7crudvalidation.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.DelegatingServerHttpResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonaServiceImpl implements PersonaService {
    @Autowired
    PersonaRepository personaRepository;

    @Override
    public PersonaOutDto addPersona(PersonaInputDto personaInputDto) throws Exception {

        if (personaInputDto.getUsuario() == null)
            throw new UnsupportedOperationException(personaInputDto.getUsuario() + " es nulo");
        else if (personaInputDto.getUsuario().length() < 6 || personaInputDto.getUsuario().length() > 10)
            throw new UnprocessableEntityException(personaInputDto.getUsuario() + " no cumple la longitud");
        else if (personaInputDto.getPassword() == null)
            throw new UnprocessableEntityException("password es null");
        else if (personaInputDto.getName() == null)
            throw new UnprocessableEntityException("name es null");
        else if (personaInputDto.getCompanyEmail() == null)
            throw new UnprocessableEntityException("companyEmail es null");
        else if (personaInputDto.getPersonalEmail() == null)
            throw new UnprocessableEntityException("email personal es null");
        else if (personaInputDto.getCity() == null)
            throw new UnprocessableEntityException("city es null");
        else if (personaInputDto.getActive() == null)
            throw new UnprocessableEntityException("active es null");
        else if (personaInputDto.getCreatedDate() == null)
            throw new UnprocessableEntityException("created date es null");
        else
            return personaRepository.save(new Persona(personaInputDto)).personaToOutputDto();

    }

    @Override
    public PersonaOutDto updatePersona(PersonaInputDto personaInputDto, int id) {
        Optional<Persona> personaExistente = personaRepository.findById(id);
        Persona personaActualizada = personaExistente.get();
        if (personaInputDto.getName().length() == 0) {
            throw new EntityNotEncontradaException("persona no encontrada");

        } else {
            personaActualizada.setName(personaInputDto.getName());
            personaActualizada.setUsuario(personaInputDto.getUsuario());
            personaActualizada.setCity(personaInputDto.getCity());
            personaActualizada.setPassword(personaInputDto.getPassword());
            personaActualizada.setActive(personaInputDto.getActive());
            personaActualizada.setCompanyEmail(personaInputDto.getCompanyEmail());
            personaActualizada.setCreatedDate(personaInputDto.getCreatedDate());
            personaActualizada.setImagenUrl(personaInputDto.getImagenUrl());
            personaActualizada.setSurName(personaInputDto.getSurName());
            personaActualizada.setPersonalEmail(personaInputDto.getPersonalEmail());
            personaActualizada.setTerminationDate(personaInputDto.getTerminationDate());

            return personaRepository.save(personaActualizada).personaToOutputDto();
        }

    }

    @Override
    public void deletePersonaById(int id) {
        if (personaRepository.findById(id).isEmpty())
            throw new EntityNotEncontradaException("persona no encontrada");
        else {
            personaRepository.deleteById(id);
        }

    }

    @Override
    public PersonaOutDto getPersonaById(int id) {
         return personaRepository.findById(id).orElseThrow().personaToOutputDto();
    }

    @Override
    public List<PersonaOutDto> getPersonaByName(String nombre) {
        List<PersonaOutDto> listaPersonas = personaRepository.findByName(nombre).stream().
                map(Persona::personaToOutputDto).collect(Collectors.toList());
        if (listaPersonas.size() != 0)
            return listaPersonas;
        else
            throw new EntityNotEncontradaException("no se ha encontrado ninguna persona con ese name");

    }

    @Override
    public List<PersonaOutDto> getListaPersonas() {

        if (personaRepository.findAll().stream()
                .map(Persona::personaToOutputDto).toList().size() != 0)
            return personaRepository.findAll().stream().map(Persona::personaToOutputDto).toList();
        else
            throw new EntityNotEncontradaException("no hay ninguna persona");
    }
}
