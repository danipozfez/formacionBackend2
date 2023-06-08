package block7crudvalidation.block7crudvalidation.controller.dto;

import block7crudvalidation.block7crudvalidation.domain.Asignatura;
import lombok.*;

import java.util.Date;
import java.util.List;
@Generated
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentOutDtoFull {

    int id_student;

    //Persona persona;

    int num_hours_week;

    String coments;
    //Profesor Profesor;

    String branch;


    int idProfesorAsignado;

    PersonaOutDto personaOutDto;

    //List<Asignatura> asignaturas;



}