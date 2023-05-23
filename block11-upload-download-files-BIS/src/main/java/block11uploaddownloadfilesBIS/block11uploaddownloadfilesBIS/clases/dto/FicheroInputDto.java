package block11uploaddownloadfilesBIS.block11uploaddownloadfilesBIS.clases.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FicheroInputDto {
    private int id;
    private String name;
    private Date upload_date;
    private String category;
    //private MultipartFile document;
}
