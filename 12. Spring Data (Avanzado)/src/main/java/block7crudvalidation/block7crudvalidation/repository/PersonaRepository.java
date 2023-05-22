package block7crudvalidation.block7crudvalidation.repository;
import block7crudvalidation.block7crudvalidation.domain.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface PersonaRepository extends JpaRepository<Persona, Integer> {
    List<Persona> findByName(String nombre);

    @Query("\"select s from Student s where s.lastname = ?1\"")
    Persona getPersonaByLastName(String param);

}
