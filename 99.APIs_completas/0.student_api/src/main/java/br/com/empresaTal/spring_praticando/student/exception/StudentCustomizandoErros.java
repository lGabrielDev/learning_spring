package br.com.empresaTal.spring_praticando.student.exception;

import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import br.com.empresaTal.spring_praticando.exceptions.ErroPadrao;

@ControllerAdvice
public class StudentCustomizandoErros {
    
    //student not found
    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<ErroPadrao> handleStudentNotFoundException(StudentNotFoundException e){
        
        //criamos um objeto "ErroPadrao"
        ErroPadrao ep = new ErroPadrao();
        ep.setTimestamp(LocalDateTime.now());
        ep.setStatus(HttpStatus.NOT_FOUND.value());
        ep.setErrorMessage(e.getMessage());
        ep.setTrace(e.getSuppressed().toString());
   
        return ResponseEntity
            .status(HttpStatus.NOT_FOUND)
            .body(ep);
    }


    //body nao possui objeto
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErroPadrao> handleHttpMessageNotReadableException(HttpMessageNotReadableException e){
        ErroPadrao ep = new ErroPadrao();
        ep.setTimestamp(LocalDateTime.now());
        ep.setStatus(HttpStatus.BAD_REQUEST.value());
        ep.setErrorMessage("You forgot the JSON object inside the RequestBody");
        ep.setTrace(e.getStackTrace().toString());

        return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(ep);
    }

    // ========== attributes validations ==========
    

    //name
    @ExceptionHandler(AttributeIsNullException.class)
    public ResponseEntity<ErroPadrao> handleAttributeIsNullException(AttributeIsNullException e){
        ErroPadrao ep = new ErroPadrao();
        ep.setTimestamp(LocalDateTime.now());
        ep.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
        ep.setErrorMessage(e.getMessage());
        ep.setTrace(e.getStackTrace().toString());

        return ResponseEntity
            .status(HttpStatus.NOT_ACCEPTABLE)
            .body(ep);
    }

    @ExceptionHandler(NameLengthIsToSmall.class)
    public ResponseEntity<ErroPadrao> handleNameLengthIsToSmall(NameLengthIsToSmall e){
        ErroPadrao ep = new ErroPadrao();
        ep.setTimestamp(LocalDateTime.now());
        ep.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
        ep.setErrorMessage(e.getMessage());
        ep.setTrace(e.getStackTrace().toString());

        return ResponseEntity
            .status(HttpStatus.NOT_ACCEPTABLE)
            .body(ep);
    }

    //email
    @ExceptionHandler(EmailAlreadyExistsException.class)
    public ResponseEntity<ErroPadrao> handleEmailAlreadyExistsException(EmailAlreadyExistsException e){
        ErroPadrao ep = new ErroPadrao();
        ep.setTimestamp(LocalDateTime.now());
        ep.setStatus(HttpStatus.CONFLICT.value());
        ep.setErrorMessage(e.getMessage());
        ep.setTrace(e.getStackTrace().toString());

        return ResponseEntity
            .status(HttpStatus.CONFLICT)
            .body(ep);
    }


    // ========== @QueryParams ==========
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ErroPadrao> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e){
        
        ErroPadrao ep = new ErroPadrao();
        ep.setTimestamp(LocalDateTime.now());
        ep.setStatus(HttpStatus.EXPECTATION_FAILED.value());
        ep.setErrorMessage(String.format("The @RequestParam '%s' must be an %s", e.getPropertyName(), e.getRequiredType().getSimpleName()));
        ep.setTrace(e.getStackTrace().toString());
        
        return ResponseEntity
            .status(HttpStatus.EXPECTATION_FAILED)
            .body(ep);

        //getPropertyName --> Nome do RequestParam que foi digitado errado
        //getRequiredType().getSimpleName() --> Nome da Class correta
    }
}
