package block7crudvalidation.block7crudvalidation.excepciones;

import lombok.Data;
import lombok.Generated;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@Generated
@Data
@ResponseStatus(HttpStatus.NOT_FOUND)
public class EntityNotEncontradaException extends RuntimeException{//no encuentra registros 404
    public EntityNotEncontradaException(String message){
        super(message);
    }

}
