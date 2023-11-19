package br.com.lGabrielDev.projetinhoFelas.exceptions;

public class EmailCannotBeNull extends RuntimeException{
    
    //constructors
    public EmailCannotBeNull(String errorMessage){
        super(errorMessage);
    }
}
