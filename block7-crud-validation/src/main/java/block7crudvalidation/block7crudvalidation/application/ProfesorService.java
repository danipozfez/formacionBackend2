package block7crudvalidation.block7crudvalidation.application;

import block7crudvalidation.block7crudvalidation.controller.dto.ProfesorInputDto;
import block7crudvalidation.block7crudvalidation.controller.dto.ProfesorOutputDto;

import java.util.List;

public interface ProfesorService {

    ProfesorOutputDto addProfesor(ProfesorInputDto profesorInputDto);

    ProfesorOutputDto updateProfesor(ProfesorInputDto profesorInputDto, int id);

    void deleteProfesorById(int id);

    ProfesorOutputDto getProfesorById(int id);

    List<ProfesorOutputDto> getProfesorByName(String nombre);

    List<ProfesorOutputDto> getListaProfesores();

}
