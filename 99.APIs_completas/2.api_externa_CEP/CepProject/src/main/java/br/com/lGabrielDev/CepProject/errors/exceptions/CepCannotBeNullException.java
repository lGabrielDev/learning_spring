package br.com.lGabrielDev.CepProject.errors.exceptions;

public class CepCannotBeNullException  extends RuntimeException{
    
    //constructors
    public CepCannotBeNullException(String errorMessage){
        super(errorMessage);
    }
}
