package block7crudvalidation.block7crudvalidation.controller.dto;

import lombok.*;

@Generated
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProfesorOutputDto {
    int id_profesor;

    String comments;
    String branch;
    //int id_persona;
    PersonaOutDto personaOutDto;
}
