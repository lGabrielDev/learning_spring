package br.com.leekbiel.projetinhoFellas.exceptions;

public class EmailAlreadyExistsException extends RuntimeException{
    
    //constructors
    public EmailAlreadyExistsException(String errorMessage){
        super(errorMessage);
    }
    
}
