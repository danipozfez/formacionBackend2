package block13mongodb.block13mongodb.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class PersonaOutDto {


    UUID id;

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
