package block7crudvalidation.block7crudvalidation.repository;

import block7crudvalidation.block7crudvalidation.domain.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Arrays;
import java.util.List;

public interface ProfesorRepository extends JpaRepository<Profesor,Integer> {

    List<Profesor> findByPersonaName(String nombre);
}
