package block13mongodb.block13mongodb.excepciones;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Data
@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class UnprocessableEntityException extends RuntimeException{//no cumple los requisitos 422

    public UnprocessableEntityException (String message) {
        super(message);
    }
}
