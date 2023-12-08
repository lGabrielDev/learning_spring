package br.com.lGabrielDev.CepProject.errors.exceptions;

public class CepNotFoundException extends RuntimeException{
    
    //constructors
    public CepNotFoundException(String errorMessage){
        super(errorMessage);
    }
}
