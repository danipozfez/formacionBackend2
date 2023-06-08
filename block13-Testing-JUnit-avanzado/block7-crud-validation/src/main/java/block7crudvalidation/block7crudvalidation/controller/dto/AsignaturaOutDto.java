package block7crudvalidation.block7crudvalidation.controller.dto;

import block7crudvalidation.block7crudvalidation.domain.Student;
import lombok.*;

import java.util.Date;
import java.util.List;
@Generated
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AsignaturaOutDto {
    Integer idAsignatura;
    String nombreAsignatura;
    String comment;
    Date initial_date;
    Date finish_date;
    //int id_student;
    List<StudentOutDtoSimple> estudiantesPorAsignatura;
}
