package block7crudvalidation.block7crudvalidation.controller;

import block7crudvalidation.block7crudvalidation.application.AsignaturaServiceImpl;
import block7crudvalidation.block7crudvalidation.controller.dto.AsignaturaInputDto;
import block7crudvalidation.block7crudvalidation.controller.dto.AsignaturaOutDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/asignatura")
public class ControllerAsignatura {
    @Autowired
    AsignaturaServiceImpl asignaturaService;

    @PostMapping
    public ResponseEntity<AsignaturaOutDto>addAsignatura(@RequestBody AsignaturaInputDto asignaturaInputDto){
        URI location = URI.create("/asignatura");
        return ResponseEntity.created(location).body(asignaturaService.addAsignatura((asignaturaInputDto)));
    }
    @GetMapping("lista")
    public List<AsignaturaOutDto>getAll(){
        return asignaturaService.getListaAsignaturas();
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String>deleteAsignaturaById(@PathVariable int id){
        asignaturaService.deleteAsignaturaById(id);
        return ResponseEntity.ok().body("asignatura con id:"+id +" borrada");
    }

    @PutMapping("/modificar/{id}")
    public ResponseEntity<AsignaturaOutDto> modAsignatura(@RequestBody AsignaturaInputDto asignaturaInputDto, @PathVariable int id){
        return ResponseEntity.ok().body(asignaturaService.updateAsignatura(asignaturaInputDto, id));
    }
}
