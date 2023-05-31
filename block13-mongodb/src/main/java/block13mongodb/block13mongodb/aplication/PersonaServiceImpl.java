package block13mongodb.block13mongodb.aplication;

import block13mongodb.block13mongodb.controller.dto.PersonaInputDto;
import block13mongodb.block13mongodb.controller.dto.PersonaOutDto;
import block13mongodb.block13mongodb.domain.Persona;
import block13mongodb.block13mongodb.excepciones.EntityNotEncontradaException;
import block13mongodb.block13mongodb.excepciones.UnprocessableEntityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonaServiceImpl implements PersonaService {
    @Autowired
    MongoTemplate mongoTemplate;

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
        else if (personaInputDto.getCompany_email() == null)
            throw new UnprocessableEntityException("companyEmail es null");
        else if (personaInputDto.getPersonal_email() == null)
            throw new UnprocessableEntityException("email personal es null");
        else if (personaInputDto.getCity() == null)
            throw new UnprocessableEntityException("city es null");
        else if (personaInputDto.getActive() == null)
            throw new UnprocessableEntityException("active es null");
        else if (personaInputDto.getCreated_date() == null)
            throw new UnprocessableEntityException("created date es null");
        else
            return mongoTemplate.save(new Persona(personaInputDto)).personaToOutputDto();

    }

    @Override
    public PersonaOutDto updatePersona(PersonaInputDto personaInputDto, int id) {
        Optional<Persona> personaExistente = Optional.ofNullable(mongoTemplate.findById(id, Persona.class));
        Persona personaActualizada = personaExistente.get();
        if (personaInputDto.getName().length() == 0) {
            throw new EntityNotEncontradaException("persona no encontrada");

        } else {
            personaActualizada.setName(personaInputDto.getName());
            personaActualizada.setUsuario(personaInputDto.getUsuario());
            personaActualizada.setCity(personaInputDto.getCity());
            personaActualizada.setPassword(personaInputDto.getPassword());
            personaActualizada.setActive(personaInputDto.getActive());
            personaActualizada.setCompany_email(personaInputDto.getCompany_email());
            personaActualizada.setCreated_date(personaInputDto.getCreated_date());
            personaActualizada.setImagen_url(personaInputDto.getImagen_url());
            personaActualizada.setSurname(personaInputDto.getSurname());
            personaActualizada.setPersonal_email(personaInputDto.getPersonal_email());
            personaActualizada.setTermination_date(personaInputDto.getTermination_date());

            return mongoTemplate.save(personaActualizada).personaToOutputDto();
        }

    }

    @Override
    public void deletePersonaById(int id) {
        Persona persona = mongoTemplate.findById(id, Persona.class);
        if (persona == null)
            throw new EntityNotEncontradaException("persona no encontrada");
        else {
            mongoTemplate.remove(persona);
        }
    }

    @Override
    public PersonaOutDto getPersonaById(int id) {
        return mongoTemplate.findById(id, Persona.class).personaToOutputDto();
    }

    /*@Override
    public List<PersonaOutDto> getPersonaByName(String nombre) {
        List<PersonaOutDto> listaPersonas = mongoTemplate.findByName(nombre).stream().
                map(Persona::personaToOutputDto).collect(Collectors.toList());
        if (listaPersonas.size() != 0)
            return listaPersonas;
        else
            throw new EntityNotEncontradaException("no se ha encontrado ninguna persona con ese name");

    }*/

    @Override
    public List<PersonaOutDto> getListaPersonas() {

        if (mongoTemplate.findAll(Persona.class).stream()
                .map(Persona::personaToOutputDto).toList().size() != 0)
            return mongoTemplate.findAll(Persona.class).stream().map(Persona::personaToOutputDto).toList();
        else
            throw new EntityNotEncontradaException("no hay ninguna persona");
    }
}
