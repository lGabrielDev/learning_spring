package br.com.lGabrielDev.projetinhoFelas.exceptions;

public class EmailAlreadyExists extends RuntimeException{
    
    //constructors
    public EmailAlreadyExists(String errorMessage){
        super(errorMessage);
    }
}
