package block7crud.repository;

import block7crud.domain.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonaRepository extends JpaRepository<Persona,Integer> {
    List<Persona> findByNombreContainingIgnoreCase(String nombre);
}
