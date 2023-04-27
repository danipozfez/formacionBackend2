package block7crudvalidation.block7crudvalidation.controller.dto;

import block7crudvalidation.block7crudvalidation.domain.Alumnos_Estudios;
import block7crudvalidation.block7crudvalidation.domain.Persona;
import block7crudvalidation.block7crudvalidation.domain.Profesor;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

public class StudentInputDto {

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public class Student {

        int id_student;

        Persona persona;

        int num_hours_week;

        String coments;
        Profesor Profesor;

        String branch;

        List<Alumnos_Estudios> estudios;
    }
}