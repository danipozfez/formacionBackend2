package block7crudvalidation.block7crudvalidation.application;

import block7crudvalidation.block7crudvalidation.controller.dto.ProfesorInputDto;
import block7crudvalidation.block7crudvalidation.controller.dto.ProfesorOutputDto;
import block7crudvalidation.block7crudvalidation.controller.dto.StudentOutDtoFull;
import block7crudvalidation.block7crudvalidation.controller.dto.StudentOutDtoSimple;
import block7crudvalidation.block7crudvalidation.domain.Persona;
import block7crudvalidation.block7crudvalidation.domain.Profesor;
import block7crudvalidation.block7crudvalidation.domain.Student;
import block7crudvalidation.block7crudvalidation.excepciones.EntityNotEncontradaException;
import block7crudvalidation.block7crudvalidation.excepciones.UnprocessableEntityException;
import block7crudvalidation.block7crudvalidation.repository.PersonaRepository;
import block7crudvalidation.block7crudvalidation.repository.ProfesorRepository;
import block7crudvalidation.block7crudvalidation.repository.StudentRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProfesorServiceImpl implements ProfesorService {

    @Autowired
    ProfesorRepository profesorRepository;
    @Autowired
    PersonaRepository personaRepository;
    @Autowired
    StudentRepository studentRepository;

    @Override
    public ProfesorOutputDto addProfesor(ProfesorInputDto profesorInputDto) {
        if (profesorInputDto.getBranch() == null)
            throw new UnprocessableEntityException("rama vacía");

        else {
            if (profesorRepository.existsById(profesorInputDto.getId_persona()))
                throw new UnprocessableEntityException("error, el profesor ya ha sido añadido");


            Persona persona = personaRepository.findById(profesorInputDto.getId_persona()).orElseThrow();
            Profesor profesor = new Profesor(profesorInputDto);

            //persona.setProfesor(profesor);
            profesor.setPersona(persona);
            if (persona.getOcupado() == null) {
                persona.setOcupado("profesor");
                return profesorRepository.save(profesor).profesorToOutputDto();
            }
            throw new UnprocessableEntityException("esta persona ya esta asignada como estudiante");
        }
    }

    @Override
    public ProfesorOutputDto updateProfesor(ProfesorInputDto profesorInputDto, int id) {
        Optional<Profesor> profesorExistente = profesorRepository.findById(id);
        Profesor profesorActualizado = profesorExistente.get();

        if (profesorExistente.isEmpty()) {//revisar
            throw new EntityNotEncontradaException("persona no encontrada");

        } else {
            profesorActualizado.setBranch(profesorInputDto.getBranch());
            profesorActualizado.setComments(profesorInputDto.getComments());


            return profesorRepository.save(profesorActualizado).profesorToOutputDto();
        }
    }

    @Override
    public void deleteProfesorById(int id) {
        Profesor profesor = profesorRepository.findById(id).orElseThrow();
        if (profesorRepository.findById(id).isEmpty())
            throw new NoSuchElementException("profesor no encontrado");
        else {

            Persona persona = personaRepository.findById(profesor.getPersona().getId()).orElseThrow();
            persona.setOcupado(null);
            profesorRepository.deleteById(id);
        }
    }

    @Override
    public ProfesorOutputDto getProfesorById(int id) {
        return profesorRepository.findById(id).orElseThrow().profesorToOutputDto();

    }

    @Override
    public List<ProfesorOutputDto> getProfesorByName(String nombre) {
        List<ProfesorOutputDto> listaProfesores = profesorRepository.findByPersonaName(nombre).stream().
                map(Profesor::profesorToOutputDto).collect(Collectors.toList());
        if (listaProfesores.size() != 0)
            return listaProfesores;
        else
            throw new EntityNotEncontradaException("no se ha encontrado ningún profesor con ese name");
    }

    @Override
    public List<ProfesorOutputDto> getListaProfesores() {
        if (profesorRepository.findAll().stream().map(Profesor::profesorToOutputDto).toList().size() != 0) {
            return profesorRepository.findAll().stream().map(Profesor::profesorToOutputDto).toList();
        } else {
            throw new EntityNotEncontradaException("no hay ningún profesor");
        }
    }

    @Override
    public List<StudentOutDtoSimple> getListaEstuantesPorProfesor(int id) {
        List<StudentOutDtoSimple> estudiantesPorProfesor = new ArrayList<>();
        List<StudentOutDtoSimple> estudiantes = studentRepository.findAll().stream().
                map(Student::studentOutDtoSimple).collect(Collectors.toList());

        for (StudentOutDtoSimple student : estudiantes) {
            if (student.getIdProfesorAsignado() == id)
                estudiantesPorProfesor.add(student);
        }
        if (estudiantesPorProfesor.size() != 0)
            return estudiantesPorProfesor;

        throw new EntityNotEncontradaException("no hay estudiantes asignados al profesor con id " + id);

    }
}
