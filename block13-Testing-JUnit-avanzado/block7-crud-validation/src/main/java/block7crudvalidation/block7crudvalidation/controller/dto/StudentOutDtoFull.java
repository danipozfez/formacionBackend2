package block7crudvalidation.block7crudvalidation.controller.dto;

import block7crudvalidation.block7crudvalidation.domain.Asignatura;
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
public class StudentOutDtoFull {

    int id_student;

    //Persona persona;

    int num_hours_week;

    String coments;
    //Profesor Profesor;

    String branch;


    int id_persona;

    int idProfesorAsignado;

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

    String ocupacion;

    List<Asignatura> asignaturas;



}