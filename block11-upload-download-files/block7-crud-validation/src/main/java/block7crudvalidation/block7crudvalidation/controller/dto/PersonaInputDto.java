package block7crudvalidation.block7crudvalidation.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonaInputDto {

    int id;

    String usuario;

    String password;

    String name;
    String surname;

    String company_email;

    String personal_email;

    String city;

    Boolean active;

    Date created_date;
    String imagen_url;
    Date termination_date;
    String ocupado;


}
