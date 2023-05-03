package block7crudvalidation.block7crudvalidation.domain;

import block7crudvalidation.block7crudvalidation.controller.dto.PersonaInputDto;
import block7crudvalidation.block7crudvalidation.controller.dto.PersonaOutDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Persona {
    @Id
    @GeneratedValue
    int id;

    String usuario;

    String password;

    String name;
    String surName;

    String companyEmail;

    String personalEmail;

    String city;

    Boolean active;

    Date createdDate;
    String imagenUrl;
    Date terminationDate;

    @OneToOne
    Student student;

    public Persona(PersonaInputDto personaInputDto) {
        this.id = personaInputDto.getId();
        this.usuario = personaInputDto.getUsuario();
        this.password = personaInputDto.getPassword();
        this.name = personaInputDto.getName();
        this.surName = personaInputDto.getSurName();
        this.companyEmail = personaInputDto.getCompanyEmail();
        this.personalEmail = personaInputDto.getPersonalEmail();
        this.city = personaInputDto.getCity();
        this.active = personaInputDto.getActive();
        this.createdDate = personaInputDto.getCreatedDate();
        this.imagenUrl = personaInputDto.getImagenUrl();
        this.terminationDate = personaInputDto.getTerminationDate();
    }

    public PersonaOutDto personaToOutputDto() {
        return new PersonaOutDto(
                this.id,
                this.usuario,
                this.password,
                this.name,
                this.surName,
                this.companyEmail,
                this.personalEmail,
                this.city,
                this.active,
                this.createdDate,
                this.imagenUrl,
                this.terminationDate
        );
    }
}
