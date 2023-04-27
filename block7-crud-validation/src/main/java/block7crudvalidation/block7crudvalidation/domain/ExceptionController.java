package block7crudvalidation.block7crudvalidation.domain;

import block7crudvalidation.block7crudvalidation.excepciones.UnprocessableEntityException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@RestControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler {
    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<CustomError>hadlerEntityNotFoundException(EntityNotFoundException exception){
        CustomError error = new CustomError(new Date(),HttpStatus.NOT_FOUND.value(),exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }


    @ExceptionHandler(UnprocessableEntityException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ResponseEntity<CustomError>hadlerUnprocessableEntity(UnprocessableEntityException exception){
        CustomError customError = new CustomError(new Date(),HttpStatus.BAD_REQUEST.value(), exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(customError);
    }
}
