package block7crudvalidation.block7crudvalidation.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentInputDto {

    int id_student;

    //Persona persona;

    int num_hours_week;

    String coments;
  //  Profesor Profesor;

    String branch;

   // List<Alumnos_Estudios> estudios;

    int id_persona;
    int idProfesorAsignado;
}
