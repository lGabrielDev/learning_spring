package br.com.lGabrielDev.tests_bolados.exceptions.globalExceptionHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import br.com.lGabrielDev.tests_bolados.exceptions.NameCannotBeNullException;
import br.com.lGabrielDev.tests_bolados.exceptions.PersonNotFoundException;

@ControllerAdvice //essa class vai tratar/personalizar as exceptions
public class GlobalExceptionHandler {
    

    
    @ExceptionHandler(PersonNotFoundException.class)
    public ResponseEntity<String> PersonNotFoundException(PersonNotFoundException e){

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }


    @ExceptionHandler(NameCannotBeNullException.class)
    public ResponseEntity<String> NameCannotBeNullException(NameCannotBeNullException e){

        return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
    }
}
