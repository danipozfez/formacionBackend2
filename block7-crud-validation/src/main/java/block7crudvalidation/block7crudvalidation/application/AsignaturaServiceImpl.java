package block7crudvalidation.block7crudvalidation.application;

import block7crudvalidation.block7crudvalidation.controller.dto.AsignaturaInputDto;
import block7crudvalidation.block7crudvalidation.controller.dto.AsignaturaOutDto;
import block7crudvalidation.block7crudvalidation.domain.Asignatura;
import block7crudvalidation.block7crudvalidation.excepciones.EntityNotEncontradaException;
import block7crudvalidation.block7crudvalidation.repository.AsignaturaRepository;
import block7crudvalidation.block7crudvalidation.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AsignaturaServiceImpl implements AsignaturaService{

    @Autowired
    StudentRepository studentRepository;
    @Autowired
    AsignaturaRepository asignaturaRepository;
    @Override
    public AsignaturaOutDto addAsignatura(AsignaturaInputDto asignaturaInputDto) {
        return asignaturaRepository.save(new Asignatura(asignaturaInputDto)).asignaturaToOutDto();
    }

    @Override
    public AsignaturaOutDto updateAsignatura(AsignaturaInputDto asignaturaInputDto) {
        return null;
    }

    @Override
    public void deleteAsignaturaById(int id) {

    }

    @Override
    public AsignaturaInputDto getAsignaturaById(int id) {
        return null;
    }

    @Override
    public List<AsignaturaOutDto> getListaAsignaturas() {
        List<AsignaturaOutDto>listaAsignaturas= asignaturaRepository.findAll().stream()
                .map(Asignatura::asignaturaToOutDto).toList();
        if (listaAsignaturas.size()==0)
            throw new EntityNotEncontradaException("no hay asignaturas creadas");
        return listaAsignaturas;
    }
}
