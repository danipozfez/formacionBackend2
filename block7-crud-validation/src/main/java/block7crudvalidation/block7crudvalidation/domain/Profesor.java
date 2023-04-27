package block7crudvalidation.block7crudvalidation.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Table(name = "profesores")
@AllArgsConstructor
@NoArgsConstructor
public class Profesor {
    @Id
    @GeneratedValue
    int id_profesor;
    @OneToOne
    @JoinColumn(name = "id_persona")
    Persona persona;
    @Column(name = "comentarios")
    String comments;
    @Column(name = "rama")
    String branch;
}
