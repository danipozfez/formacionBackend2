package block7crudvalidation.block7crudvalidation.application;

import block7crudvalidation.block7crudvalidation.controller.dto.AsignaturaInputDto;
import block7crudvalidation.block7crudvalidation.controller.dto.AsignaturaOutDto;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AlumnosEstudiosServiceImpl implements AsignaturaService{
    @Override
    public AsignaturaOutDto addAsignatura(AsignaturaInputDto asignaturaInputDto) {
        return null;
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
        return null;
    }
}
