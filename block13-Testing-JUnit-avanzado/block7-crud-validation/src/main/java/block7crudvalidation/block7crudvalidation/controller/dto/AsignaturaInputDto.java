package block7crudvalidation.block7crudvalidation.controller.dto;

import lombok.*;

import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Generated
public class AsignaturaInputDto {

    Integer idAsignatura;
    String nombreAsignatura;
    String comment;
    Date initial_date;
    Date finish_date;
   // int id_student;
}
