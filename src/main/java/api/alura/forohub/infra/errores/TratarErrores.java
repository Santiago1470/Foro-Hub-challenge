package api.alura.forohub.infra.errores;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;

@RestControllerAdvice
public class TratarErrores {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity tratarError400CamposInvalidos(MethodArgumentNotValidException exception) {
        var camposErrores = exception.getFieldErrors().stream().map(f -> new DatosErrorValidacion(f.getField(), f.getDefaultMessage())).toList();
        return ResponseEntity.badRequest().body(camposErrores);
    }

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseEntity tratarError409TopicoExistente(SQLIntegrityConstraintViolationException exception) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(exception.getMessage());
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity tratarError404TopicoNoExistente(EntityNotFoundException exception) {
        return ResponseEntity.notFound().build();
    }

    private record DatosErrorValidacion(String campo, String mensaje) {

    }

}
