package block7crudvalidation.block7crudvalidation.repository;
import block7crudvalidation.block7crudvalidation.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.w3c.dom.ls.LSInput;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findByPersonaName(String name);//ojo con el nombre que se pone
    //List<Student> findByPersonaId(int idProfesorAsignado);
}
