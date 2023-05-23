package block11uploaddownloadfilesBIS.block11uploaddownloadfilesBIS;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Fichero {
    private int id;
    private String name;
    private Date upload_date;
    private String category;
    private MultipartFile document;
}
