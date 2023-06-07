package block7crudvalidation.block7crudvalidation.domain;

import block7crudvalidation.block7crudvalidation.controller.dto.PersonaOutDto;
import block7crudvalidation.block7crudvalidation.controller.dto.StudentInputDto;
import block7crudvalidation.block7crudvalidation.controller.dto.StudentOutDtoFull;
import block7crudvalidation.block7crudvalidation.controller.dto.StudentOutDtoSimple;
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
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    int id_student;
    @OneToOne//(cascade = CascadeType.REMOVE)//permite que se elimine el estudiante y la persona
    @JoinColumn(name = "id", nullable = false, unique = true)
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
    List<Asignatura> asignaturas;

    int idProfesorAsignado;


    public Student(StudentInputDto studentInputDto) {
        this.id_student = studentInputDto.getId_student();
        //this.persona = getPersona();
        this.num_hours_week = studentInputDto.getNum_hours_week();
        this.coments = studentInputDto.getComents();
        //this.profesor = studentInputDto.getProfesor();
        this.branch = studentInputDto.getBranch();

        //this.estudios = studentInputDto.getEstudios();
    }

    public StudentOutDtoFull studentToOutDtoFull() {
        PersonaOutDto personaOutDto = this.persona.personaToOutputDto();
        return new StudentOutDtoFull(
                this.id_student,
                this.num_hours_week,
                this.coments,
                this.branch,
                this.idProfesorAsignado,
                personaOutDto



        );
    }

    public StudentOutDtoSimple studentOutDtoSimple() {

        return new StudentOutDtoSimple(

                this.id_student,
                this.num_hours_week,
                this.coments,
                this.branch,
                this.idProfesorAsignado



        );
    }
}
