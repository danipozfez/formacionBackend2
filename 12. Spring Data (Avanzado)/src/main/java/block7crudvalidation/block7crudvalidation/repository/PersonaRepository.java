package block7crudvalidation.block7crudvalidation.repository;
import block7crudvalidation.block7crudvalidation.controller.dto.PersonaOutDto;
import block7crudvalidation.block7crudvalidation.domain.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.HashMap;
import java.util.List;


public interface PersonaRepository extends JpaRepository<Persona, Integer> {
    List<Persona> findByName(String nombre);

    //@Query("\"select s from Persona s where s.name = ?1\"")
    Persona getPersonaByName(String param);

    Iterable<PersonaOutDto> getCustomQuery(HashMap<String, Object> data,String order, int pageNumer, int pageSize);
}
