package br.com.lGabrielDev.CepProject.errors;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.lGabrielDev.CepProject.errors.exceptions.CepCannotBeNullException;
import br.com.lGabrielDev.CepProject.errors.exceptions.CepMustContainEightCharacters;
import br.com.lGabrielDev.CepProject.errors.exceptions.CepMustContainOnlyIntegers;
import br.com.lGabrielDev.CepProject.errors.exceptions.CepNotFoundException;
import br.com.lGabrielDev.CepProject.errors.exceptions.NameCannotBeNullException;

//class que vamos usar para customizar nossas exceptions
@ControllerAdvice
public class GlobalExceptionHandler {
    

    //Name Cannot Be Null
    @ExceptionHandler(NameCannotBeNullException.class)
    public ResponseEntity<EstruturaErroPadrao> NameCannotBeNullException(NameCannotBeNullException e){
        
        EstruturaErroPadrao e1 = new EstruturaErroPadrao(
            LocalDateTime.now(),
            HttpStatus.BAD_REQUEST.value(),
            e.getMessage()
        );

        return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(e1);
    }


    //Cep Cannot Be Null
    @ExceptionHandler(CepCannotBeNullException.class)
    public ResponseEntity<EstruturaErroPadrao> CepCannotBeNNullException(CepCannotBeNullException e){
        
        EstruturaErroPadrao e1 = new EstruturaErroPadrao(
            LocalDateTime.now(),
            HttpStatus.BAD_REQUEST.value(),
            e.getMessage()
        );

        return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(e1);
    }


    //Cep Mus tContains Eight Characters
    @ExceptionHandler(CepMustContainEightCharacters.class)
    public ResponseEntity<Object> CepMustContainEightCharacters(CepMustContainEightCharacters e){

        EstruturaErroPadrao e1 = new EstruturaErroPadrao();
        e1.setTimestamp(LocalDateTime.now());
        e1.setStatus(HttpStatus.CONFLICT.value());
        e1.setErrorMessage(e.getMessage());

        return ResponseEntity
            .status(HttpStatus.CONFLICT)
            .body(e1);
    }


    //Cep Not Found Exception
    @ExceptionHandler(CepNotFoundException.class)
    public ResponseEntity<Object> CepNotFoundException(CepNotFoundException e){

        EstruturaErroPadrao e1 = new EstruturaErroPadrao();
        e1.setTimestamp(LocalDateTime.now());
        e1.setStatus(HttpStatus.NOT_FOUND.value());
        e1.setErrorMessage(e.getMessage());

        return ResponseEntity
            .status(HttpStatus.NOT_FOUND)
            .body(e1);
    }


    //Cep Must Contain Only Integers
    @ExceptionHandler(CepMustContainOnlyIntegers.class)
    public ResponseEntity<EstruturaErroPadrao> CepMustContainOnlyIntegers(CepMustContainOnlyIntegers e){

        EstruturaErroPadrao e1 = new EstruturaErroPadrao();
        e1.setTimestamp(LocalDateTime.now());
        e1.setStatus(HttpStatus.CONFLICT.value());
        e1.setErrorMessage(e.getMessage());

        return ResponseEntity
            .status(HttpStatus.CONFLICT)
            .body(e1);
    }
}
