package br.com.lGabrielDev.CepProject.errors.exceptions;

public class NameCannotBeNullException extends RuntimeException{
    
    //constructors
    public NameCannotBeNullException(String errorMessage){
        super(errorMessage);
    }
}
