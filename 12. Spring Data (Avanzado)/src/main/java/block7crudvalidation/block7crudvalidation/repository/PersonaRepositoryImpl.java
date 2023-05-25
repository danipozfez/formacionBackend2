package block7crudvalidation.block7crudvalidation.repository;

import block7crudvalidation.block7crudvalidation.controller.dto.PersonaOutDto;
import block7crudvalidation.block7crudvalidation.domain.Persona;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
@Service
public class PersonaRepositoryImpl {
    @PersistenceContext
    private EntityManager entityManager;

    public List<PersonaOutDto> getCustomQuery(
            HashMap<String, Object> conditions, String order) {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Persona> query = cb.createQuery(Persona.class);
        Root<Persona> root = query.from(Persona.class);

        List<Predicate> predicates = new ArrayList<>();

        conditions.forEach((field, value) -> {
            switch (field) {
                case "name":
                    predicates.add(cb.like(root.get(field),
                            "%" + (String) value + "%"));
                    break;
                case "surname":
                    predicates.add(cb.like(root.get(field),
                            "%" + (String) value + "%"));
                    break;
                case "usuario":
                    predicates.add(cb.like(root.get(field),
                            "%" + (String) value + "%"));
                    break;
                case "created_date":
                    predicates.add(cb.like(root.get(field),
                            "%" + (String) value + "%"));
                    break;



                }

            switch (order){
                case "nameAsc":
                    query.orderBy(cb.asc(root.get("name")));
                    break;
                case "nameDesc":
                    query.orderBy(cb.desc(root.get("name")));
                    break;
                case "usuarioAsc":
                    query.orderBy(cb.asc(root.get("usuario")));
                    break;
                case "usuarioDesc":
                    query.orderBy(cb.desc(root.get("usuario")));
                    break;
               /* case "desc":
                    query.orderBy(cb.desc(root.get(field)));
*/
                default:
                    break;

            }

        });
        query.select(root)
                .where(predicates.toArray(new Predicate[predicates.size()]));
        return entityManager
                .createQuery(query)
                .getResultList()
                .stream()
                .map(Persona::personaToOutputDto)
                .toList();
    }
}
