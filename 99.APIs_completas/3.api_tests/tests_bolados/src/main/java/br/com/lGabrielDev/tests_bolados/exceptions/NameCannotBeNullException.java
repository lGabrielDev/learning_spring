package br.com.lGabrielDev.tests_bolados.exceptions;

public class NameCannotBeNullException extends RuntimeException{
        
    //constructors
    public NameCannotBeNullException(String errorMessage){
        super(errorMessage);
    }
}
