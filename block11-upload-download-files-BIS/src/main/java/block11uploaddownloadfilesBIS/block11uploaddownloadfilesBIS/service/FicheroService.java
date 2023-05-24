package block11uploaddownloadfilesBIS.block11uploaddownloadfilesBIS.service;

import block11uploaddownloadfilesBIS.block11uploaddownloadfilesBIS.clases.Fichero;
import block11uploaddownloadfilesBIS.block11uploaddownloadfilesBIS.clases.dto.FicheroInputDto;
import block11uploaddownloadfilesBIS.block11uploaddownloadfilesBIS.clases.dto.FicheroOutDto;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


public interface FicheroService {


    Fichero saveFichero(MultipartFile file, String ruta) throws IOException;

    List<FicheroOutDto> getListFicheros();

    FicheroOutDto getFicheroById(int id);

    List<FicheroOutDto> getFicheroByName(String nombre);
}
