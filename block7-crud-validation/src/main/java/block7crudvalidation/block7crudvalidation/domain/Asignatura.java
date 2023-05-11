package block7crudvalidation.block7crudvalidation.domain;

import block7crudvalidation.block7crudvalidation.controller.dto.AsignaturaInputDto;
import block7crudvalidation.block7crudvalidation.controller.dto.AsignaturaOutDto;
import block7crudvalidation.block7crudvalidation.controller.dto.StudentOutDtoSimple;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "estudios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Asignatura {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Integer idAsignatura;

    @ManyToOne
    @JoinColumn(name = "profesor_id")
    Profesor profesor;
    // @OneToMany(cascade = CascadeType.ALL)//será una lista
    // @JoinColumn(name = "estudiante_id")
   // List<Student> students;

    @Column(name = "asignatura")
    String nombreAsignatura;
    @Column(name = "comentarios")
    String comment;
    @Column(name = "initial_date")
    Date initial_date;
    @Column(name = "finish_date")
    Date finish_date;
    @ManyToMany
    List<Student> estudiantesPorAsignatura;

    int id_student;

    public Asignatura(AsignaturaInputDto asignaturaInputDto) {
        this.idAsignatura = asignaturaInputDto.getIdAsignatura();
        this.nombreAsignatura = asignaturaInputDto.getNombreAsignatura();
        this.comment = asignaturaInputDto.getComment();
        this.initial_date = asignaturaInputDto.getInitial_date();
        this.finish_date = asignaturaInputDto.getFinish_date();
    }

    public AsignaturaOutDto asignaturaToOutDto() {
        List<StudentOutDtoSimple>estudiantes= new ArrayList<>();
        if (estudiantesPorAsignatura!= null) {
            for (Student student : estudiantesPorAsignatura) {
                estudiantes.add(student.studentOutDtoSimple());
            }
        }
        return new AsignaturaOutDto(
                this.idAsignatura,
                this.nombreAsignatura,
                this.comment,
                this.initial_date,
                this.finish_date,
                estudiantes
                //this.student.id_student
        );
    }

}
