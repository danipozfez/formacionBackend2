package block11uploaddownloadfilesBIS.block11uploaddownloadfilesBIS.service;

import block11uploaddownloadfilesBIS.block11uploaddownloadfilesBIS.clases.dto.FicheroInputDto;
import block11uploaddownloadfilesBIS.block11uploaddownloadfilesBIS.clases.dto.FicheroOutDto;

import java.util.List;


public interface FicheroService {

    FicheroOutDto saveFichero(FicheroInputDto ficheroInputDto);
    List<FicheroOutDto> getListFicheros();
}
