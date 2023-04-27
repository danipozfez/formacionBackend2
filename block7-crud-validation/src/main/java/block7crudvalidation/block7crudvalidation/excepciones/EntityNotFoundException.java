package block7crudvalidation.block7crudvalidation.excepciones;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Data
@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class EntityNotFoundException extends RuntimeException{//no encuentra registros 404
    public EntityNotFoundException (String message){
        super(message);
    }

}
