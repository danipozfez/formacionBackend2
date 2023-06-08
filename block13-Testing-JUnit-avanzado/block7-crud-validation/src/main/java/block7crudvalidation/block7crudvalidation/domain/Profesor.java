package block7crudvalidation.block7crudvalidation.domain;

import block7crudvalidation.block7crudvalidation.controller.dto.PersonaOutDto;
import block7crudvalidation.block7crudvalidation.controller.dto.ProfesorInputDto;
import block7crudvalidation.block7crudvalidation.controller.dto.ProfesorOutputDto;
import block7crudvalidation.block7crudvalidation.controller.dto.StudentInputDto;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "profesores")
@AllArgsConstructor
@NoArgsConstructor
@Generated
public class Profesor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    int id_profesor;
    @OneToOne
    @JoinColumn(name = "id_persona")
    Persona persona;
    @Column(name = "comentarios")
    String comments;
    @Column(name = "rama")
    String branch;

    //@JoinColumn(name = "id_Student")
    @OneToMany(fetch = FetchType.LAZY)
    List<Student> estudiantes;

    public Profesor(ProfesorInputDto profesorInputDto) {
        this.id_profesor = profesorInputDto.getId_profesor();
        this.comments = profesorInputDto.getComments();
        this.branch = profesorInputDto.getBranch();
    }

    public ProfesorOutputDto profesorToOutputDto() {
        PersonaOutDto personaOutDto = this.persona.personaToOutputDto();
        return new ProfesorOutputDto(
                this.id_profesor,
                this.comments,
                this.branch,
                personaOutDto
        );
    }
}
