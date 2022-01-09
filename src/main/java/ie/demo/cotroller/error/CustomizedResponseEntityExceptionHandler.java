package ie.demo.cotroller.error;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    /*
     * @see org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler#handleMethodArgumentNotValid(org.springframework.web.bind.MethodArgumentNotValidException, org.springframework.http.HttpHeaders, org.springframework.http.HttpStatus, org.springframework.web.context.request.WebRequest)
     */
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid( MethodArgumentNotValidException ex,
            HttpHeaders headers, HttpStatus status, WebRequest request ) {
        return ResponseEntity
                .badRequest()
                .body(
                    ErrorResponse.builder()
                        .timestamp( LocalDateTime.now() )
                        .messages( ex.getBindingResult().getFieldErrors().stream()
                                .map( fe -> fe.getField() + " - " + fe.getDefaultMessage() ).collect( Collectors.toList() ) )
                    .build()
                );
    }
}
