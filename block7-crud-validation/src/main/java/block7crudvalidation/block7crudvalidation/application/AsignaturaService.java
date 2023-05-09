package block7crudvalidation.block7crudvalidation.application;

import block7crudvalidation.block7crudvalidation.controller.dto.AsignaturaInputDto;
import block7crudvalidation.block7crudvalidation.controller.dto.AsignaturaOutDto;

import java.util.List;

public interface AsignaturaService {

    AsignaturaOutDto addAsignatura (AsignaturaInputDto asignaturaInputDto);

    AsignaturaOutDto updateAsignatura(AsignaturaInputDto asignaturaInputDto);

    void deleteAsignaturaById(int id);

    AsignaturaInputDto getAsignaturaById(int id);

    List<AsignaturaOutDto> getListaAsignaturas();
}
