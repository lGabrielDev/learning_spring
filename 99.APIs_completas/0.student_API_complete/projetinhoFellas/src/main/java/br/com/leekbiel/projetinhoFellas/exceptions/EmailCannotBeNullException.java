package br.com.leekbiel.projetinhoFellas.exceptions;

public class EmailCannotBeNullException extends RuntimeException{
    
    //constructors
    public EmailCannotBeNullException(String errorMessage){
        super(errorMessage);
    }
}
