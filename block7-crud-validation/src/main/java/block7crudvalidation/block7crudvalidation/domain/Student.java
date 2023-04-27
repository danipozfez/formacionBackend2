package block7crudvalidation.block7crudvalidation.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@Entity
@Table(name = "estudiantes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue
    int id_student;
    @OneToOne
    @JoinColumn(name = "id_persona")
    Persona persona;
    @Column(name="horas_por_semana")
    int num_hours_week;
    @Column(name="comentarios")
    String coments;
    @JoinColumn(name="id_profesor")
    @ManyToOne(fetch = FetchType.LAZY)
    Profesor Profesor;
    @Column(name = "rama")
    String branch;
    @OneToOne
    List<Alumnos_Estudios> estudios;
}
