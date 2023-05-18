package block7crudvalidation.block7crudvalidation.domain;

import block7crudvalidation.block7crudvalidation.controller.dto.PersonaInputDto;
import block7crudvalidation.block7crudvalidation.controller.dto.PersonaOutDto;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
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

  /*  @OneToOne
    Student student;
    @OneToOne
    Profesor profesor;*/

    public Persona(PersonaInputDto personaInputDto) {
        this.id = personaInputDto.getId();
        this.usuario = personaInputDto.getUsuario();
        this.password = personaInputDto.getPassword();
        this.name = personaInputDto.getName();
        this.surname = personaInputDto.getSurname();
        this.company_email = personaInputDto.getCompany_email();
        this.personal_email = personaInputDto.getPersonal_email();
        this.city = personaInputDto.getCity();
        this.active = personaInputDto.getActive();
        this.created_date = personaInputDto.getCreated_date();
        this.imagen_url = personaInputDto.getImagen_url();
        this.termination_date = personaInputDto.getTermination_date();
        this.ocupado=personaInputDto.getOcupado();
    }

    public PersonaOutDto personaToOutputDto() {
        return new PersonaOutDto(
                this.id,
                this.usuario,
                this.password,
                this.name,
                this.surname,
                this.company_email,
                this.personal_email,
                this.city,
                this.active,
                this.created_date,
                this.imagen_url,
                this.termination_date,
                this.ocupado
        );
    }
}
