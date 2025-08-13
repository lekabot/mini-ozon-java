package mini.bigtech.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<ErrorResponse> badRequest(MethodArgumentNotValidException ex) {
    return ResponseEntity.badRequest()
      .body(new ErrorResponse("VALIDATION_ERROR", ex.getMessage()));
  }

  @ExceptionHandler(IllegalArgumentException.class)
  public ResponseEntity<ErrorResponse> illegalArg(IllegalArgumentException ex) {
    return ResponseEntity.status(HttpStatus.CONFLICT)
      .body(new ErrorResponse("CONFLICT", ex.getMessage()));
  }
}
