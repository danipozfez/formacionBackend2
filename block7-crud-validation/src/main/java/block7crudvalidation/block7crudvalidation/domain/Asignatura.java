package block7crudvalidation.block7crudvalidation.domain;

import block7crudvalidation.block7crudvalidation.controller.dto.AsignaturaInputDto;
import block7crudvalidation.block7crudvalidation.controller.dto.AsignaturaOutDto;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "estudios")
@Getter
@Setter

public class Asignatura {
    @Id
    @GeneratedValue
    Integer id_study;

    @ManyToOne
    @JoinColumn(name = "profesor_id")
    Profesor profesor;
    // @OneToMany(cascade = CascadeType.ALL)//será una lista
    // @JoinColumn(name = "estudiante_id")
   // List<Student> students;
    @JoinColumn(name = "id_estudiante")
    @ManyToOne
    Student student;
    @Column(name = "asignatura")
    String nombreAsignatura;
    @Column(name = "comentarios")
    String comment;
    @Column(name = "initial_date")
    Date initial_date;
    @Column(name = "finish_date")
    Date finish_date;

    int id_student;

    public Asignatura(AsignaturaInputDto asignaturaInputDto) {
        this.id_study = asignaturaInputDto.getId_study();
        this.nombreAsignatura = asignaturaInputDto.getNombreAsignatura();
        this.comment = asignaturaInputDto.getComment();
        this.initial_date = asignaturaInputDto.getInitial_date();
        this.finish_date = asignaturaInputDto.getFinish_date();
    }

    public AsignaturaOutDto alumnosEstudiosToOutDto() {
        return new AsignaturaOutDto(
                this.id_study,
                this.nombreAsignatura,
                this.comment,
                this.initial_date,
                this.finish_date,
                this.student.id_student
        );
    }

}
