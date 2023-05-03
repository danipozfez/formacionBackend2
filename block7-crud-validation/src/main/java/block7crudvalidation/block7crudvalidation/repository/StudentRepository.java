package block7crudvalidation.block7crudvalidation.repository;

import block7crudvalidation.block7crudvalidation.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Integer> {
    //List<Student> buscaPorNombre(String nombre);
}
