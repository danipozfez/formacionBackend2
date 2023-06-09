package block7crudvalidation.block7crudvalidation.application;

import block7crudvalidation.block7crudvalidation.controller.dto.AsignaturaOutDto;
import block7crudvalidation.block7crudvalidation.controller.dto.StudentInputDto;
import block7crudvalidation.block7crudvalidation.controller.dto.StudentOutDtoFull;
import block7crudvalidation.block7crudvalidation.controller.dto.StudentOutDtoSimple;
import block7crudvalidation.block7crudvalidation.domain.Asignatura;
import block7crudvalidation.block7crudvalidation.domain.Persona;
import block7crudvalidation.block7crudvalidation.domain.Profesor;
import block7crudvalidation.block7crudvalidation.domain.Student;
import block7crudvalidation.block7crudvalidation.excepciones.EntityNotEncontradaException;
import block7crudvalidation.block7crudvalidation.excepciones.UnprocessableEntityException;
import block7crudvalidation.block7crudvalidation.repository.AsignaturaRepository;
import block7crudvalidation.block7crudvalidation.repository.PersonaRepository;
import block7crudvalidation.block7crudvalidation.repository.ProfesorRepository;
import block7crudvalidation.block7crudvalidation.repository.StudentRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service

public class StudentServiceImpl implements StudentService {
    @Autowired

    StudentRepository studentRepository;
    @Autowired
    PersonaRepository personaRepository;

    @Autowired
    ProfesorRepository profesorRepository;
    @Autowired
    AsignaturaRepository asignaturaRepository;

    @Override
    public StudentOutDtoFull addStudent(StudentInputDto studentInputDto) throws Exception {

        if (studentInputDto.getNum_hours_week() == 0)
            throw new UnprocessableEntityException("número de horas obligatorio");
        else if (studentInputDto.getBranch() == null)
            throw new UnprocessableEntityException("rama vacía");
        else {
            Persona persona = personaRepository.findById(studentInputDto.getId_persona()).orElseThrow();
            Student student = new Student(studentInputDto);


            student.setPersona(persona);

            if (persona.getOcupado() == null) {
                persona.setOcupado("estudiante");
                return studentRepository.save(student).studentToOutDtoFull();

            }
            throw new UnprocessableEntityException("esta persona ya está asignada como profesor");
        }
    }

    @Override
    public StudentOutDtoFull updateStudent(StudentInputDto studentInputDto, int id) {
        Student estudianteActualizado = studentRepository.findById(id)
                .orElseThrow(() -> new EntityNotEncontradaException("Estudiante no encontrado"));

        estudianteActualizado.setBranch(studentInputDto.getBranch());
        estudianteActualizado.setComents(studentInputDto.getComents());
        estudianteActualizado.setNum_hours_week(studentInputDto.getNum_hours_week());

        Optional<Profesor> profesor = profesorRepository.findById(studentInputDto.getIdProfesorAsignado());

        if (profesor.isPresent()) {
            estudianteActualizado.setIdProfesorAsignado(studentInputDto.getIdProfesorAsignado());
            return studentRepository.save(estudianteActualizado).studentToOutDtoFull();
        } else {
            throw new UnprocessableEntityException("El ID del profesor no existe");
        }
    }


    @Override
    public void deleteStudentById(int id) {
        Student student = studentRepository.findById(id).orElseThrow();
        if (student == null) {
            throw new EntityNotEncontradaException("estudiante no encontrado");
        } else {

            Persona persona = personaRepository.findById(student.getPersona().getId()).orElseThrow();
            persona.setOcupado(null);
            studentRepository.deleteById(id);
        }
    }

    @Override
    public StudentOutDtoFull getStudentByIdFull(int id) {
        return studentRepository.findById(id).orElseThrow().studentToOutDtoFull();
    }

    @Override
    public StudentOutDtoSimple getStudentByIdSimple(int id) {
        return studentRepository.findById(id).orElseThrow().studentOutDtoSimple();
    }


    @Override
    public List<StudentOutDtoFull> getStudentByName(String nombre) {
        List<StudentOutDtoFull> listaEstudiantes = studentRepository.findByPersonaName(nombre).stream().
                map(Student::studentToOutDtoFull).collect(Collectors.toList());
        if (listaEstudiantes.size() != 0) {

            return listaEstudiantes;
        } else {
            throw new EntityNotEncontradaException("no se ha encontrado ningún estudiante con ese name");
        }
    }


    @Override
    public List<StudentOutDtoSimple> getListaStudent() {
        if (studentRepository.findAll().stream().map(Student::studentOutDtoSimple).toList().size() != 0)
            return studentRepository.findAll().stream().map(Student::studentOutDtoSimple).toList();
        else
            throw new EntityNotEncontradaException("no hay ningún estudiante");
    }

    @Override
    public List<StudentOutDtoFull> getlistaStudentByIdProfesor(int idProfesorAsignado) {
        List<StudentOutDtoFull> estudiantes = studentRepository.findById(idProfesorAsignado).stream().
                map(Student::studentToOutDtoFull).collect(Collectors.toList());
        if (estudiantes.size() != 0) {
            return estudiantes;
        } else {
            throw new EntityNotEncontradaException("no hay estudiantes asignados al profesor con id " + idProfesorAsignado);
        }
    }

    @Override
    public List<AsignaturaOutDto> getListaAsginaturaPorEstudiante(int id) {


        return null;
    }


    @Override
    public StudentOutDtoSimple addAsignaturaAEstudiante(List<Integer> listaDeIdAsignatura, int id) {
        Student estudiante = studentRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        List<Asignatura> asignaturas = asignaturaRepository.findAllById(listaDeIdAsignatura);

        estudiante.getAsignaturas().addAll(asignaturas);

        for (Asignatura asignatura : asignaturas) {
            asignatura.getEstudiantesPorAsignatura().add(estudiante);
        }

        return studentRepository.save(estudiante).studentOutDtoSimple();
    }

    @Override
    public StudentOutDtoFull deleteAsignaturaAEstudiante(List<Integer> listaPorEstudiante, int id) {
        Student estudiante = studentRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        List<Asignatura> asignaturas = asignaturaRepository.findAllById(listaPorEstudiante);
        estudiante.getAsignaturas().removeAll(asignaturas);
        return studentRepository.save(estudiante).studentToOutDtoFull();
    }


}