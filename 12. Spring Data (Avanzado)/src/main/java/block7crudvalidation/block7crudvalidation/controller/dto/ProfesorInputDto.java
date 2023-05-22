package block7crudvalidation.block7crudvalidation.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProfesorInputDto {
    int id_profesor;
    int id_persona;
    String comments;
    String branch;
}