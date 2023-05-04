package block7crudvalidation.block7crudvalidation.application;

import block7crudvalidation.block7crudvalidation.controller.dto.ProfesorInputDto;
import block7crudvalidation.block7crudvalidation.controller.dto.ProfesorOutputDto;

import java.util.List;

public class ProfesorServiceImpl implements ProfesorService{
    @Override
    public ProfesorOutputDto addProfesor(ProfesorInputDto profesorInputDto) {
        return null;
    }

    @Override
    public ProfesorOutputDto updateProfesor(ProfesorInputDto profesorInputDto, int id) {
        return null;
    }

    @Override
    public void deleteProfesorById(int id) {

    }

    @Override
    public ProfesorOutputDto getProfesorById(int id) {
        return null;
    }

    @Override
    public List<ProfesorOutputDto> getProfesorByName(String nombre) {
        return null;
    }

    @Override
    public List<ProfesorOutputDto> getListaProfesores() {
        return null;
    }
}
