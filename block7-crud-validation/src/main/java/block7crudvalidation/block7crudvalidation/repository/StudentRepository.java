package block7crudvalidation.block7crudvalidation.repository;

import block7crudvalidation.block7crudvalidation.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {
}
