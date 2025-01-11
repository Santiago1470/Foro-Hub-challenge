package api.alura.forohub.infra.errores;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;

@RestControllerAdvice
public class TratarErrores {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity tratarError400camposInvalidos(MethodArgumentNotValidException exception) {
        var camposErrores = exception.getFieldErrors().stream().map(f -> new DatosErrorValidacion(f.getField(), f.getDefaultMessage())).toList();
        return ResponseEntity.badRequest().body(camposErrores);
    }

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseEntity tratarError400topicoExistente(SQLIntegrityConstraintViolationException exception) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(exception.getMessage());
    }

    private record DatosErrorValidacion(String campo, String mensaje) {

    }

}
