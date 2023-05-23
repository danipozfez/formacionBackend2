package block11uploaddownloadfilesBIS.block11uploaddownloadfilesBIS.clases;

import block11uploaddownloadfilesBIS.block11uploaddownloadfilesBIS.clases.dto.FicheroInputDto;
import block11uploaddownloadfilesBIS.block11uploaddownloadfilesBIS.clases.dto.FicheroOutDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Fichero {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String name;
    private Date upload_date;
    private String category;
    //private MultipartFile document;

    public Fichero(FicheroInputDto ficheroInputDto) {
        this.id = ficheroInputDto.getId();
        this.name = ficheroInputDto.getName();
        this.upload_date = ficheroInputDto.getUpload_date();
        this.category = ficheroInputDto.getCategory();
    }
    public FicheroOutDto ficheroToOutDto(){
        return new FicheroOutDto(
          this.id,
          this.name,
          this.upload_date,
          this.category
        );
    }
}
