package block7crudvalidation.block7crudvalidation.excepciones;

import lombok.Data;
import lombok.Generated;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@Generated
@Data
@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class UnprocessableEntityException extends RuntimeException{//no cumple los requisitos 422

    public UnprocessableEntityException (String message) {
        super(message);
    }
}
