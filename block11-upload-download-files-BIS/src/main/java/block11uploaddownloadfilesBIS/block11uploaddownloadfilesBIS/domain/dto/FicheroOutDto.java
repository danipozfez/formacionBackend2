package block11uploaddownloadfilesBIS.block11uploaddownloadfilesBIS.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FicheroOutDto {
    private int id;
    private String name;
    private Date upload_date;
    private String category;
}
