package block7crudvalidation.block7crudvalidation.domain;

import block7crudvalidation.block7crudvalidation.controller.dto.StudentInputDto;
import block7crudvalidation.block7crudvalidation.controller.dto.StudentOutDto;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "estudiantes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue
    int id_student;
    @OneToOne(cascade = CascadeType.ALL)//permite que se elimine el estudiante y la persona
    @JoinColumn(name = "id",nullable = false,unique = true)
    Persona persona;
    @Column(name = "horas_por_semana")
    int num_hours_week;
    @Column(name = "comentarios")
    String coments;
    @JoinColumn(name = "id_profesor")
    @ManyToOne(fetch = FetchType.LAZY)
    Profesor profesor;
    @Column(name = "rama")
    String branch;
    @OneToMany
    List<Alumnos_Estudios> estudios;

    public Student(StudentInputDto studentInputDto) {
        this.id_student = studentInputDto.getId_student();
        //this.persona = getPersona();
        this.num_hours_week = studentInputDto.getNum_hours_week();
        this.coments = studentInputDto.getComents();
        //this.profesor = studentInputDto.getProfesor();
        this.branch = studentInputDto.getBranch();

        //this.estudios = studentInputDto.getEstudios();
    }

    public StudentOutDto studentToOutDto() {
        return new StudentOutDto(
              this.id_student,
                this.num_hours_week,
                this.coments,
                this.branch,
                this.persona.getId(),
                this.persona.getUsuario(),
                this.persona.getName()
        );
    }
}
