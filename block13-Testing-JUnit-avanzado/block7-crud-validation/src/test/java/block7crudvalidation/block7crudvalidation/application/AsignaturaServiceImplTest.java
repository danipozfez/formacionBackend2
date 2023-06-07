package block7crudvalidation.block7crudvalidation.application;

import block7crudvalidation.block7crudvalidation.controller.dto.AsignaturaInputDto;
import block7crudvalidation.block7crudvalidation.controller.dto.AsignaturaOutDto;
import block7crudvalidation.block7crudvalidation.controller.dto.StudentOutDtoSimple;
import block7crudvalidation.block7crudvalidation.domain.Asignatura;
import block7crudvalidation.block7crudvalidation.excepciones.EntityNotEncontradaException;
import block7crudvalidation.block7crudvalidation.repository.AsignaturaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class AsignaturaServiceImplTest {

    @Mock
    private AsignaturaRepository asignaturaRepository;

    @InjectMocks
    private AsignaturaServiceImpl asignaturaService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddAsignatura() {

        AsignaturaInputDto asignaturaInputDto = new AsignaturaInputDto(1,"Matemáticas", "Comentario", null, null);


        Asignatura asignaturaGuardada = new Asignatura(asignaturaInputDto);
        when(asignaturaRepository.save(any(Asignatura.class))).thenReturn(asignaturaGuardada);


        AsignaturaOutDto result = asignaturaService.addAsignatura(asignaturaInputDto);


        assertNotNull(result);
        assertEquals(asignaturaGuardada.getIdAsignatura(), result.getIdAsignatura());
        assertEquals(asignaturaGuardada.getNombreAsignatura(), result.getNombreAsignatura());
        assertEquals(asignaturaGuardada.getComment(), result.getComment());
        assertEquals(asignaturaGuardada.getInitial_date(), result.getInitial_date());
        assertEquals(asignaturaGuardada.getFinish_date(), result.getFinish_date());
    }

    @Test
    public void testUpdateAsignatura() {
        // Datos de entrada
        int id = 1;
        AsignaturaInputDto asignaturaInputDto = new AsignaturaInputDto(1,"Matemáticas", "Comentario", null,null);


        Asignatura asignaturaExistente = new Asignatura(asignaturaInputDto);
        when(asignaturaRepository.findById(id)).thenReturn(Optional.of(asignaturaExistente));
        when(asignaturaRepository.save(any(Asignatura.class))).thenReturn(asignaturaExistente);


        AsignaturaOutDto result = asignaturaService.updateAsignatura(asignaturaInputDto, id);


        assertNotNull(result);
        assertEquals(asignaturaExistente.getIdAsignatura(), result.getIdAsignatura());
        assertEquals(asignaturaInputDto.getNombreAsignatura(), result.getNombreAsignatura());
        assertEquals(asignaturaInputDto.getComment(), result.getComment());
        assertEquals(asignaturaInputDto.getInitial_date(), result.getInitial_date());
        assertEquals(asignaturaInputDto.getFinish_date(), result.getFinish_date());
    }

    @Test
    public void testDeleteAsignaturaById() {

        int id = 1;


        when(asignaturaRepository.findById(id)).thenReturn(Optional.empty());


        assertThrows(EntityNotEncontradaException.class, () -> asignaturaService.deleteAsignaturaById(id));


        verify(asignaturaRepository, times(1)).findById(id);
        verify(asignaturaRepository, never()).deleteById(anyInt());
    }

    @Test
    public void testGetAsignaturaById() {

        int id = 1;

        AsignaturaInputDto asignaturaInputDto = new AsignaturaInputDto(1,"Matemáticas", "Comentario", null,null);


        Asignatura asignaturaExistente = new Asignatura(asignaturaInputDto);;
        when(asignaturaRepository.findById(id)).thenReturn(Optional.of(asignaturaExistente));


        AsignaturaOutDto result = asignaturaService.getAsignaturaById(id);

        assertNotNull(result);
        assertEquals(asignaturaExistente.getIdAsignatura(), result.getIdAsignatura());
        assertEquals(asignaturaExistente.getNombreAsignatura(), result.getNombreAsignatura());
        assertEquals(asignaturaExistente.getComment(), result.getComment());
        assertEquals(asignaturaExistente.getInitial_date(), result.getInitial_date());
        assertEquals(asignaturaExistente.getFinish_date(), result.getFinish_date());
    }

    @Test
    public void testGetListaAsignaturas() {

        List<Asignatura> asignaturas = new ArrayList<>();
        AsignaturaInputDto asignaturaInputDto = new AsignaturaInputDto(1,"Matemáticas", "Comentario", null,null);

        AsignaturaInputDto asignaturaInputDto2 = new AsignaturaInputDto(2,"Matemáticas", "Comentario", null,null);

        asignaturas.add(new Asignatura(asignaturaInputDto));
        asignaturas.add(new Asignatura(asignaturaInputDto2));
        when(asignaturaRepository.findAll()).thenReturn(asignaturas);

        List<AsignaturaOutDto> result = asignaturaService.getListaAsignaturas();


        assertNotNull(result);
        assertEquals(asignaturas.size(), result.size());
    }

    @Test
    public void testGetStudentByAsignatura() {

        int idAsignatura = 1;
        AsignaturaInputDto asignaturaInputDto = new AsignaturaInputDto(1,"Matemáticas", "Comentario", null,null);


        Asignatura asignatura = new Asignatura(asignaturaInputDto);
        when(asignaturaRepository.findById(idAsignatura)).thenReturn(Optional.of(asignatura));


        List<StudentOutDtoSimple> result = asignaturaService.getStudentByAsignatura(idAsignatura);

        assertNotNull(result);

    }
}
