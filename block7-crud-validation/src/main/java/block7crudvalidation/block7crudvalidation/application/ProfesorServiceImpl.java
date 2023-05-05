package block7crudvalidation.block7crudvalidation.application;

import block7crudvalidation.block7crudvalidation.controller.dto.ProfesorInputDto;
import block7crudvalidation.block7crudvalidation.controller.dto.ProfesorOutputDto;
import block7crudvalidation.block7crudvalidation.domain.Persona;
import block7crudvalidation.block7crudvalidation.domain.Profesor;
import block7crudvalidation.block7crudvalidation.domain.Student;
import block7crudvalidation.block7crudvalidation.excepciones.EntityNotEncontradaException;
import block7crudvalidation.block7crudvalidation.excepciones.UnprocessableEntityException;
import block7crudvalidation.block7crudvalidation.repository.PersonaRepository;
import block7crudvalidation.block7crudvalidation.repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfesorServiceImpl implements ProfesorService {

    @Autowired
    ProfesorRepository profesorRepository;
    @Autowired
    PersonaRepository personaRepository;

    @Override
    public ProfesorOutputDto addProfesor(ProfesorInputDto profesorInputDto) {
        if (profesorInputDto.getBranch() == null)
            throw new UnprocessableEntityException("rama vacía");

        else {
            if (profesorRepository.existsById(profesorInputDto.getId_persona()))
                throw new UnprocessableEntityException("error, el profesor ya ha sido añadido");


            Persona persona = personaRepository.findById(profesorInputDto.getId_persona()).orElseThrow();
            Profesor profesor = new Profesor(profesorInputDto);

            persona.setProfesor(profesor);
            profesor.setPersona(persona);

            return profesorRepository.save(profesor).profesorToOutputDto();
        }
    }

    @Override
    public ProfesorOutputDto updateProfesor(ProfesorInputDto profesorInputDto, int id) {
        return null;
    }

    @Override
    public void deleteProfesorById(int id) {

        if (profesorRepository.findById(id).isEmpty())
            throw new EntityNotEncontradaException("profesor no encontrado");
        else
            profesorRepository.deleteById(id);
    }

    @Override
    public ProfesorOutputDto getProfesorById(int id) {
        return null;
    }

    @Override
    public List<ProfesorOutputDto> getProfesorByName(String nombre) {
        return null;
    }

    @Override
    public List<ProfesorOutputDto> getListaProfesores() {
        return null;
    }
}
