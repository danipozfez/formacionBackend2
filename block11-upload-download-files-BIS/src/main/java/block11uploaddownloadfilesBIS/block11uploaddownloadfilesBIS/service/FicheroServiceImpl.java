package block11uploaddownloadfilesBIS.block11uploaddownloadfilesBIS.service;

import block11uploaddownloadfilesBIS.block11uploaddownloadfilesBIS.FicheroRepository;
import block11uploaddownloadfilesBIS.block11uploaddownloadfilesBIS.clases.Fichero;
import block11uploaddownloadfilesBIS.block11uploaddownloadfilesBIS.clases.dto.FicheroInputDto;
import block11uploaddownloadfilesBIS.block11uploaddownloadfilesBIS.clases.dto.FicheroOutDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class FicheroServiceImpl implements FicheroService {
   // public String setUploadPath;
    private String uploadPath;

    public void setUploadPath(String uploadPath) {
        this.uploadPath = uploadPath;
    }
    @Override
    public Fichero saveFichero(MultipartFile file, String category) throws IOException {
        String originalFilename = file.getOriginalFilename();
        String extension = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);

        if (!extension.equals("tipo")) {
            throw new IllegalArgumentException("El tipo de archivo no es válido.");
        }

        String filename = UUID.randomUUID() + "." + extension;
        String filePath = uploadPath + File.separator + filename;

        file.transferTo(new File(filePath));

        Fichero fichero = new Fichero();
        fichero.setName(filename);
        fichero.setUpload_date(new Date());
        fichero.setCategory(category);

        // Guardar en la base de datos (H2)
        // ...

        return fichero;
    }

    // Métodos para buscar y descargar el archivo por ID o nombre
    // ...




    @Override
    public List<FicheroOutDto> getListFicheros() {
        return null;
    }
}
