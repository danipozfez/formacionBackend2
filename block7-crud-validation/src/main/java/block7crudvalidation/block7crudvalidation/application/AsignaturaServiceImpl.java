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
import java.util.Optional;

@Service
public class AsignaturaServiceImpl implements AsignaturaService {

    @Autowired
    StudentRepository studentRepository;
    @Autowired
    AsignaturaRepository asignaturaRepository;

    @Override
    public AsignaturaOutDto addAsignatura(AsignaturaInputDto asignaturaInputDto) {
        return asignaturaRepository.save(new Asignatura(asignaturaInputDto)).asignaturaToOutDto();
    }

    @Override
    public AsignaturaOutDto updateAsignatura(AsignaturaInputDto asignaturaInputDto, int id) {
        Optional<Asignatura>asignaturaExistente = asignaturaRepository.findById(id);
        Asignatura asignaturaActualizada = asignaturaExistente.get();
        if (asignaturaInputDto.getNombreAsignatura().length()==0)
            throw new EntityNotEncontradaException("la asignatura no existe");
        else
            asignaturaActualizada.setNombreAsignatura(asignaturaInputDto.getNombreAsignatura());
            asignaturaActualizada.setComment(asignaturaInputDto.getComment());
            asignaturaActualizada.setInitial_date(asignaturaInputDto.getInitial_date());
            asignaturaActualizada.setFinish_date(asignaturaInputDto.getFinish_date());
        return asignaturaRepository.save(asignaturaActualizada).asignaturaToOutDto();
    }

    @Override
    public void deleteAsignaturaById(int id) {
        if (asignaturaRepository.findById(id).isEmpty())
            throw new EntityNotEncontradaException("asignatura no encontrada");
        else
            asignaturaRepository.deleteById(id);

    }

    @Override
    public AsignaturaOutDto getAsignaturaById(int id) {
        return asignaturaRepository.findById(id).orElseThrow().asignaturaToOutDto();
    }

    @Override
    public List<AsignaturaOutDto> getListaAsignaturas() {

        List<AsignaturaOutDto> listaAsignaturas = asignaturaRepository.findAll().stream()
                .map(Asignatura::asignaturaToOutDto).toList();
        if (listaAsignaturas.size() == 0)
            throw new EntityNotEncontradaException("no hay asignaturas creadas");
        return listaAsignaturas;


    }
}
