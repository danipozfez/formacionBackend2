package block13mongodb.block13mongodb.excepciones;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Data
@ResponseStatus(HttpStatus.NOT_FOUND)
public class EntityNotEncontradaException extends RuntimeException{//no encuentra registros 404
    public EntityNotEncontradaException(String message){
        super(message);
    }

}
