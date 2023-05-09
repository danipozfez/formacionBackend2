package block7crudvalidation.block7crudvalidation.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AlumnosEstudiosInputDto {

    Integer id_study;
    String nombreAsignatura;
    String comment;
    Date initial_date;
    Date finish_date;
    int id_student;
}
