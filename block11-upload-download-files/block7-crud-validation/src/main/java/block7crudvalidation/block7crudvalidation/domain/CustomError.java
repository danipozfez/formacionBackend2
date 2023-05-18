package block7crudvalidation.block7crudvalidation.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomError {
    Date timestamp;
    int httpCode;
    String mensaje;

    public CustomError( int httpCode, String mensaje) {
        this.timestamp = new Date();
        this.httpCode = httpCode;
        this.mensaje = mensaje;
    }
}
