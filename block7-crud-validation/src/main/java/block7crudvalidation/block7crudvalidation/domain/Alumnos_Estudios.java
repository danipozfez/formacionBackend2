package block7crudvalidation.block7crudvalidation.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "estudios")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Alumnos_Estudios {
    @Id
    @GeneratedValue
    int id_study;
   // @ManyToOne
    //@JoinColumn(name = "profesor_id")
    Profesor profesor;
   // @ManyToMany
    Student student;
    @Column(name = "asignatura")
    String asignatura;
    @Column(name="comentarios")
    String comment;
    @Column(name = "initial_date")
    Date initial_date;
    @Column(name="finish_date")
    Date finish_date;

}
