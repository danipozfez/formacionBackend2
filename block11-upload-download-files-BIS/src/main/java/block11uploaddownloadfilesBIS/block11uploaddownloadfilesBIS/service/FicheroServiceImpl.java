package block11uploaddownloadfilesBIS.block11uploaddownloadfilesBIS.service;

import block11uploaddownloadfilesBIS.block11uploaddownloadfilesBIS.repository.FicheroRepository;
import block11uploaddownloadfilesBIS.block11uploaddownloadfilesBIS.domain.Fichero;
import block11uploaddownloadfilesBIS.block11uploaddownloadfilesBIS.domain.dto.FicheroOutDto;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FicheroServiceImpl implements FicheroService {
    @Autowired
    FicheroRepository ficheroRepository;
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


    @Override
    public List<FicheroOutDto> getListFicheros() {
        if (ficheroRepository.findAll().stream()
                .map(Fichero::ficheroToOutDto).toList().size() != 0)
            return ficheroRepository.findAll().stream().map(Fichero::ficheroToOutDto).toList();
        else
            throw new EntityNotFoundException("no hay ningun fichero");
    }

    @Override
    public FicheroOutDto getFicheroById(int id) {
        return ficheroRepository.findById(id).orElseThrow().ficheroToOutDto();
    }
    @Override
    public List<FicheroOutDto> getFicheroByName(String nombre) {
        List<FicheroOutDto> lista = ficheroRepository.findByName(nombre).stream().
                map(Fichero::ficheroToOutDto).collect(Collectors.toList());
        if (lista.size() != 0)
            return lista;
        else
            throw new EntityNotFoundException("no se ha encontrado ningun fichero con ese name");

    }
}
