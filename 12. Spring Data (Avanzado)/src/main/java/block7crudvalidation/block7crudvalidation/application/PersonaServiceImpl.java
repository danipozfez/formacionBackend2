package block7crudvalidation.block7crudvalidation.application;

import block7crudvalidation.block7crudvalidation.controller.dto.PersonaInputDto;
import block7crudvalidation.block7crudvalidation.controller.dto.PersonaOutDto;
import block7crudvalidation.block7crudvalidation.domain.Persona;
import block7crudvalidation.block7crudvalidation.excepciones.EntityNotEncontradaException;
import block7crudvalidation.block7crudvalidation.excepciones.UnprocessableEntityException;
import block7crudvalidation.block7crudvalidation.repository.PersonaRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonaServiceImpl implements PersonaService {
    @Autowired
    PersonaRepository personaRepository;
    @PersistenceContext
    private EntityManager entityManager;

    public List<PersonaOutDto> getCustomQuery(
            HashMap<String, Object> conditions) {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Persona> query = cb.createQuery(Persona.class);
        Root<Persona> root = query.from(Persona.class);

        List<Predicate> predicates = new ArrayList<>();

        conditions.forEach((field, value) -> {
            switch (field) {
                case "name":
                    predicates.add(cb.like(root.get(field),
                            "%" + (String) value + "%"));
                    break;
                case "lastName":
                    predicates.add(cb.like(root.get(field),
                            "%" + (String) value + "%"));
                    break;
            }
        });
        query.select(root)
                .where(predicates.toArray(new Predicate[predicates.size()]));
        return entityManager
                .createQuery(query)
                .getResultList()
                .stream()
                .map(Persona::personaToOutputDto)
                .toList();
    }



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
            personaActualizada.setCompany_email(personaInputDto.getCompany_email());
            personaActualizada.setCreated_date(personaInputDto.getCreated_date());
            personaActualizada.setImagen_url(personaInputDto.getImagen_url());
            personaActualizada.setSurname(personaInputDto.getSurname());
            personaActualizada.setPersonal_email(personaInputDto.getPersonal_email());
            personaActualizada.setTermination_date(personaInputDto.getTermination_date());

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
