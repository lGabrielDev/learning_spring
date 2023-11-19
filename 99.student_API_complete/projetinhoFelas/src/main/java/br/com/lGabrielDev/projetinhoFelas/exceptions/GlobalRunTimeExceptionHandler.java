package br.com.lGabrielDev.projetinhoFelas.exceptions;
import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice // Essa class será responsável em customizar a resposta de todas as RuntimeExceptions
public class GlobalRunTimeExceptionHandler {
    
    //RuntimeExceptions

    //StudentNotFound
    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<ErrosPadronizados> StudentNotFoundException(StudentNotFoundException e){
        ErrosPadronizados ep = new ErrosPadronizados();
        ep.setTimestamp(LocalDateTime.now());
        ep.setStatus(HttpStatus.NOT_FOUND.value());
        ep.setError(e.getMessage());
        ep.setTrace(e.getStackTrace().toString());

        return ResponseEntity
            .status(HttpStatus.NOT_FOUND)
            .body(ep);
    }


    //DateOfBirthCannotBeNull
    @ExceptionHandler(DateOfBirthCannotBeNull.class)
    public ResponseEntity<ErrosPadronizados> DateOfBirthCannotBeNull(DateOfBirthCannotBeNull e){
        ErrosPadronizados ep = new ErrosPadronizados(
            LocalDateTime.now(),
            HttpStatus.NOT_ACCEPTABLE.value(),
            e.getMessage(),
            e.getStackTrace().toString()
        );

        return ResponseEntity
            .status(HttpStatus.NOT_ACCEPTABLE)
            .body(ep);
    }


    //NameCannotBeNull
    @ExceptionHandler(NameCannotBeNull.class)
    public ResponseEntity<ErrosPadronizados> NameCannotBeNull(NameCannotBeNull e){
        ErrosPadronizados ep = new ErrosPadronizados(
            LocalDateTime.now(),
            HttpStatus.NOT_ACCEPTABLE.value(),
            e.getMessage(),
            e.getStackTrace().toString()
        );

        return ResponseEntity
            .status(HttpStatus.NOT_ACCEPTABLE)
            .body(ep);
    }


    //EmailCannotBeNull
    @ExceptionHandler(EmailCannotBeNull.class)
    public ResponseEntity<ErrosPadronizados> EmailCannotBeNull(EmailCannotBeNull e){
        ErrosPadronizados ep = new ErrosPadronizados(
            LocalDateTime.now(),
            HttpStatus.BAD_REQUEST.value(),
            e.getMessage(),
            e.getStackTrace().toString()
        );

        return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(ep);
    }


    //EmailAlreadyExists
    @ExceptionHandler(EmailAlreadyExists.class)
    public ResponseEntity<ErrosPadronizados> EmailAlreadyExists(EmailAlreadyExists e){
        ErrosPadronizados ep = new ErrosPadronizados(
            LocalDateTime.now(),
            HttpStatus.CONFLICT.value(),
            e.getMessage(),
            e.getStackTrace().toString()
        );

        return ResponseEntity
            .status(HttpStatus.CONFLICT)
            .body(ep);
    }
}
