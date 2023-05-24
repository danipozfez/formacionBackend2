package block11uploaddownloadfilesBIS.block11uploaddownloadfilesBIS.controller;

import block11uploaddownloadfilesBIS.block11uploaddownloadfilesBIS.FicheroRepository;
import block11uploaddownloadfilesBIS.block11uploaddownloadfilesBIS.clases.Fichero;
import block11uploaddownloadfilesBIS.block11uploaddownloadfilesBIS.clases.dto.FicheroInputDto;
import block11uploaddownloadfilesBIS.block11uploaddownloadfilesBIS.clases.dto.FicheroOutDto;
import block11uploaddownloadfilesBIS.block11uploaddownloadfilesBIS.service.FicheroService;
import block11uploaddownloadfilesBIS.block11uploaddownloadfilesBIS.service.FicheroServiceImpl;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
public class FicheroController {

    @Autowired
    FicheroServiceImpl ficheroService;

    @Autowired
    FicheroRepository ficheroRepository;

    @PostMapping("/upload")
    public FicheroOutDto uploadFile(@RequestParam("file") MultipartFile file, @RequestParam("path") String path) throws IOException {
        if (!file.isEmpty()) {
            if (!path.isEmpty()) {
                Fichero fichero = ficheroService.saveFichero(file, path);
                ficheroRepository.save(fichero);

                return fichero.ficheroToOutDto();
            } else {
                throw new IllegalArgumentException("La ruta de carga no puede estar vacía.");
            }
        } else {
            throw new IllegalArgumentException("El archivo no puede estar vacío.");
        }
    }
    @GetMapping("/list")
    public List<FicheroOutDto> getAll() {
        return ficheroService.getListFicheros();
    }

    @GetMapping("id/{id}")
    public ResponseEntity<FicheroOutDto> getPersonaById(@PathVariable int id) {
        try {
            return ResponseEntity.ok().body(ficheroService.getFicheroById(id));

        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("nombre/{nombre}")
    public List<FicheroOutDto> getByName(@PathVariable String nombre) {
        return ficheroService.getFicheroByName(nombre);
    }

}
