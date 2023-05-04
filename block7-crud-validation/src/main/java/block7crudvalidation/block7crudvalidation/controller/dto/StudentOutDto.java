package block7crudvalidation.block7crudvalidation.controller.dto;

import block7crudvalidation.block7crudvalidation.domain.Alumnos_Estudios;
import block7crudvalidation.block7crudvalidation.domain.Persona;
import block7crudvalidation.block7crudvalidation.domain.Profesor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentOutDto {

    int id_student;

    //Persona persona;

    int num_hours_week;

    String coments;
    //Profesor Profesor;

    String branch;

    //List<Alumnos_Estudios> estudios;
    int id_persona;

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

}