package br.com.lGabrielDev.tests_bolados.exceptions;

public class PersonNotFoundException extends RuntimeException{
    
    //constructors
    public PersonNotFoundException(String errorMessage){
        super(errorMessage);
    }


}
