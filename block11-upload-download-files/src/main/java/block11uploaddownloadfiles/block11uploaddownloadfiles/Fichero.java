package block11uploaddownloadfiles.block11uploaddownloadfiles;


import com.fasterxml.jackson.annotation.JsonTypeId;
import jakarta.annotation.Generated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

import java.util.Date;
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Fichero {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private Date fechaSubida;
   // private String categoria;
}
