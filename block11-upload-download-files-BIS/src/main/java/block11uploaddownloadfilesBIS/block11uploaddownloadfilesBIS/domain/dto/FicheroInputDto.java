package block11uploaddownloadfilesBIS.block11uploaddownloadfilesBIS.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
