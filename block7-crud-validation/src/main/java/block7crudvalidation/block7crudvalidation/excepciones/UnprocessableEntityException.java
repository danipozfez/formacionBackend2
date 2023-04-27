package block7crudvalidation.block7crudvalidation.excepciones;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Data
@ResponseStatus(HttpStatus.NOT_FOUND)
public class UnprocessableEntityException extends RuntimeException{//no cumple los requisitos 422

    public UnprocessableEntityException (String message) {
        super(message);
    }
}
