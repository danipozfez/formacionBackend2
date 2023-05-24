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

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import java.util.UUID;

@RestController
public class FicheroController {

    @Autowired
    FicheroServiceImpl ficheroService;

    @PostMapping("/upload")
    public Fichero uploadFile(
            @RequestParam("file") MultipartFile file,
            @RequestParam("path") String path

    ) throws IOException {
        if (!file.isEmpty()) {
            if (!path.isEmpty()) {
                File uploadDirectory = new File(path);
                if (!uploadDirectory.exists()) {
                    uploadDirectory.mkdirs();
                }

                String originalFilename = file.getOriginalFilename();
                String extension = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);

                String filename = UUID.randomUUID().toString() + "." + extension;
                String filePath = path + File.separator + filename;

                Path destination = new File(filePath).toPath();
                Files.copy(file.getInputStream(), destination, StandardCopyOption.REPLACE_EXISTING);

                Fichero fileMetadata = new Fichero();
                fileMetadata.setName(filename);
                fileMetadata.setUpload_date(new Date());
                fileMetadata.setCategory("");

                // Guardar en la base de datos (H2)
                // ...

                return fileMetadata;
            } else {
                throw new IllegalArgumentException("La ruta de carga no puede estar vacía.");
            }
        } else {
            throw new IllegalArgumentException("El archivo no puede estar vacío.");
        }
    }
}
