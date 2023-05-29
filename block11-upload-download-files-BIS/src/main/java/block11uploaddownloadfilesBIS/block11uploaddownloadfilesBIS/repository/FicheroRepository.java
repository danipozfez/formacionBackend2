package block11uploaddownloadfilesBIS.block11uploaddownloadfilesBIS.repository;

import block11uploaddownloadfilesBIS.block11uploaddownloadfilesBIS.domain.Fichero;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FicheroRepository extends JpaRepository<Fichero,Integer> {

    List<Fichero> findByName(String nombre);

}
