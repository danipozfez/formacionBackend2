package block11uploaddownloadfilesBIS.block11uploaddownloadfilesBIS.service;

import block11uploaddownloadfilesBIS.block11uploaddownloadfilesBIS.clases.Fichero;
import block11uploaddownloadfilesBIS.block11uploaddownloadfilesBIS.clases.dto.FicheroOutDto;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class FicheroServiceImpl implements FicheroService {

    @Override
    public Fichero saveFichero(MultipartFile file, String uploadPath) throws IOException {


        if (!file.isEmpty()) {

            if (uploadPath != null && !uploadPath.isEmpty()) {
                File uploadDirectory = new File(uploadPath);
                if (!uploadDirectory.exists()) {
                    uploadDirectory.mkdirs();
                }

                String originalFilename = file.getOriginalFilename();
                String extension = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);

                file.transferTo(Path.of(uploadDirectory + "/" + file.getOriginalFilename()));

                Fichero fileMetadata = new Fichero();
                fileMetadata.setName(originalFilename);
                fileMetadata.setUpload_date(new Date());
                fileMetadata.setCategory(extension);


                return fileMetadata;
            } else {
                throw new IllegalArgumentException("La ruta de carga no está configurada.");
            }
        } else {
            throw new IllegalArgumentException("El archivo está vacío.");
        }
    }
    // Métodos para buscar y descargar el archivo por ID o nombre
    // ...


    @Override
    public List<FicheroOutDto> getListFicheros() {
        return null;
    }
}
