package block11uploaddownloadfilesBIS.block11uploaddownloadfilesBIS.controller;

import block11uploaddownloadfilesBIS.block11uploaddownloadfilesBIS.clases.Fichero;
import block11uploaddownloadfilesBIS.block11uploaddownloadfilesBIS.clases.dto.FicheroInputDto;
import block11uploaddownloadfilesBIS.block11uploaddownloadfilesBIS.clases.dto.FicheroOutDto;
import block11uploaddownloadfilesBIS.block11uploaddownloadfilesBIS.service.FicheroService;
import block11uploaddownloadfilesBIS.block11uploaddownloadfilesBIS.service.FicheroServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class FicheroController {

    @Autowired
    FicheroServiceImpl ficheroService;
    @PostMapping("/upload")
    public Fichero uploadFile(
            @RequestParam("file") MultipartFile file,
            @PathVariable("tipo") String tipo,
            @RequestParam("categoria") String categoria
    ) throws IOException {
        ficheroService.setUploadPath(tipo);

        return ficheroService.saveFichero(file, categoria);
    }
}
