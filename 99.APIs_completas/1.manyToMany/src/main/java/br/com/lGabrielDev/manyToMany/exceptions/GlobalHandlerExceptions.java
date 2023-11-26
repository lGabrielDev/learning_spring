package br.com.lGabrielDev.manyToMany.exceptions;
import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalHandlerExceptions {
    

    //customizando as RuntimeExceptions

    //PokemonPowerNotFound
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErroPadrao> PokemonPowerNotFound(HttpMessageNotReadableException e){
        ErroPadrao e1 = new ErroPadrao(
            LocalDateTime.now(),
            HttpStatus.NOT_ACCEPTABLE.value(),
            "Informe a List de 'pokemon #Ids' no body da requisicao"
        );

        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(e1);
    }
}
