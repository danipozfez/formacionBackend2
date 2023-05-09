package block7crudvalidation.block7crudvalidation.domain;

import block7crudvalidation.block7crudvalidation.controller.dto.AlumnosEstudiosInputDto;
import block7crudvalidation.block7crudvalidation.controller.dto.AlumnosEstudiosOutDto;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "estudios")
@Getter
@Setter

public class AlumnosEstudios {
    @Id
    @GeneratedValue
    Integer id_study;

    @ManyToOne
    @JoinColumn(name = "profesor_id")
    Profesor profesor;
    // @OneToMany(cascade = CascadeType.ALL)//será una lista
    // @JoinColumn(name = "estudiante_id")
    List<Student> students;
    @JoinColumn(name = "id_student")
    @OneToMany
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

    public AlumnosEstudios(AlumnosEstudiosInputDto alumnosEstudiosInputDto) {
        this.id_study = alumnosEstudiosInputDto.getId_study();
        this.nombreAsignatura = alumnosEstudiosInputDto.getNombreAsignatura();
        this.comment = alumnosEstudiosInputDto.getComment();
        this.initial_date = alumnosEstudiosInputDto.getInitial_date();
        this.finish_date = alumnosEstudiosInputDto.getFinish_date();
    }

    public AlumnosEstudiosOutDto alumnosEstudiosToOutDto() {
        return new AlumnosEstudiosOutDto(
                this.id_study,
                this.nombreAsignatura,
                this.comment,
                this.initial_date,
                this.finish_date,
                this.student.id_student
        );
    }

}
