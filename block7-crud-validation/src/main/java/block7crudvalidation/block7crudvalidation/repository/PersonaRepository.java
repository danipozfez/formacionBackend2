package block7crudvalidation.block7crudvalidation.repository;

import block7crudvalidation.block7crudvalidation.domain.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository <Persona,Integer> {
}
