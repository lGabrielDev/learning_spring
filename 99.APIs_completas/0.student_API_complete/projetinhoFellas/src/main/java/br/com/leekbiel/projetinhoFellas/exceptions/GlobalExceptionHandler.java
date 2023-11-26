package br.com.leekbiel.projetinhoFellas.exceptions;
import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice //essa class é responsável em tratar todas as "RuntimeExceptions"
public class GlobalExceptionHandler {
    
    //Personalizando as RuntimeExceptions
    
    //StudentNotFoundException
    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<ErroPadrao> StudentNotFoundException(StudentNotFoundException e){
        ErroPadrao e1 = new ErroPadrao();
        e1.setTimestamp(LocalDateTime.now());
        e1.setStatus(HttpStatus.NOT_FOUND.value());
        e1.setError(e.getMessage());

        return ResponseEntity
            .status(HttpStatus.NOT_FOUND)
            .body(e1);
    }


    //NameCannotBeNullException
    @ExceptionHandler(NameCannotBeNullException.class)
    public ResponseEntity<Object> NameCannotBeNullException(NameCannotBeNullException e){
        ErroPadrao e1 = new ErroPadrao();
        e1.setTimestamp(LocalDateTime.now());
        e1.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
        e1.setError(e.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(e1);
    }


    //DateOfBirthCannotBeNullException
    @ExceptionHandler(DateOfBirthCannotBeNullException.class)
    public ResponseEntity<ErroPadrao> DateOfBirthCannotBeNullException(DateOfBirthCannotBeNullException e){
        ErroPadrao e1 = new ErroPadrao();
        e1.setTimestamp(LocalDateTime.now()); //2023-11-05  05:40:20 PM
        e1.setStatus(HttpStatus.NOT_ACCEPTABLE.value()); //Erro "404"
        e1.setError(e.getMessage()); 

        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(e1);
    }


    //EmailCannotBeNullException
    @ExceptionHandler(EmailCannotBeNullException.class)
    public ResponseEntity<ErroPadrao> EmailCannotBeNullException(EmailCannotBeNullException e){
        ErroPadrao e1 = new ErroPadrao();
        e1.setTimestamp(LocalDateTime.now());
        e1.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
        e1.setError(e.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(e1);
    }


    //EmailAlreadyExistsException
    @ExceptionHandler(EmailAlreadyExistsException.class)
    public ResponseEntity<ErroPadrao> EmailAlreadyExistsException(EmailAlreadyExistsException e){
        ErroPadrao e1 = new ErroPadrao(
            LocalDateTime.now(),
            HttpStatus.CONFLICT.value(),
            e.getMessage()
        );

        return ResponseEntity.status(HttpStatus.CONFLICT).body(e1);
    }


    //MethodArgumentTypeMismatchException --> Essa exception acontece quando colocamos uma String ao inves de um dataType Number (Integer, Long, etc..)
    //vamos tratar 2 possíveis erros:
    //1. Cliente tenta localizar/editar/deletar um Student pelo #ID, mas passa uma String
    //2. Cliente passa uma String no requestParam "rows"

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ErroPadrao> MethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e){

        String mensagemDeErro = "";
        
        if(e.getName().equals("id")){
            mensagemDeErro = "The Student #ID must be an Integer!";
        }
        else if(e.getName().equals("rows")){
            mensagemDeErro = "The parameter 'rows' must be an Integer";
        }
        
        
        //criamos o objeto que vamos enviar na resposta da requisicao
        ErroPadrao e1 = new ErroPadrao();
        e1.setTimestamp(LocalDateTime.now());
        e1.setStatus(HttpStatus.BAD_REQUEST.value());
        e1.setError(mensagemDeErro);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e1);
    }
}
