package block7crudvalidation.block7crudvalidation.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "estudios")
@Getter
@Setter

public class Alumnos_Estudios {
    @Id
    @GeneratedValue
    Integer id_study;

    @ManyToOne
    @JoinColumn(name = "profesor_id")
    Profesor profesor;
    @ManyToMany(cascade = CascadeType.ALL)//será una lista
    @JoinColumn(name = "estudiante_id")
    List <Student> students;
    @Column(name = "asignatura")
    String asignatura;
    @Column(name = "comentarios")
    String comment;
    @Column(name = "initial_date")
    Date initial_date;
    @Column(name = "finish_date")
    Date finish_date;

}
