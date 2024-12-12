package foi.air.szokpt.transactionmng.exceptions;

import foi.air.szokpt.transactionmng.dtos.responses.ApiResponse;
import foi.air.szokpt.transactionmng.util.ApiResponseUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ApiResponse<Object>> handleTypeMismatchException(MethodArgumentTypeMismatchException ex) {
        if (ex.getRequiredType() != null && ex.getRequiredType().equals(LocalDateTime.class)) {
            return ResponseEntity.badRequest().body(ApiResponseUtil.failure("Invalid date format"));
        }
        return ResponseEntity.badRequest().body(ApiResponseUtil.failure("Invalid parameter value"));
    }
}
