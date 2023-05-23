package block11uploaddownloadfilesBIS.block11uploaddownloadfilesBIS.service;

import block11uploaddownloadfilesBIS.block11uploaddownloadfilesBIS.FicheroRepository;
import block11uploaddownloadfilesBIS.block11uploaddownloadfilesBIS.clases.Fichero;
import block11uploaddownloadfilesBIS.block11uploaddownloadfilesBIS.clases.dto.FicheroInputDto;
import block11uploaddownloadfilesBIS.block11uploaddownloadfilesBIS.clases.dto.FicheroOutDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FicheroServiceImpl implements FicheroService {
    @Autowired
    FicheroRepository ficheroRepository;
    @Override
    public FicheroOutDto saveFichero(FicheroInputDto ficheroInputDto) {
        return ficheroRepository.save(new Fichero(ficheroInputDto)).ficheroToOutDto();
    }

    @Override
    public List<FicheroOutDto> getListFicheros() {
        return null;
    }
}
