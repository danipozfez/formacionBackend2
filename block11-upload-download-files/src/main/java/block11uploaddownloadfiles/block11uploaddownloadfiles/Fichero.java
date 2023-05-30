package block11uploaddownloadfiles.block11uploaddownloadfiles;


import com.fasterxml.jackson.annotation.JsonTypeId;
import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Fichero {
    //@Id
    //@GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String name;
    private Date fechaSubida;
   // private String categoria;
}
