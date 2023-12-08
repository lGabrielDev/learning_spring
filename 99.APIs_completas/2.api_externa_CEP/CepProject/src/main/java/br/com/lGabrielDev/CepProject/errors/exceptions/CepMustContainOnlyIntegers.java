package br.com.lGabrielDev.CepProject.errors.exceptions;

public class CepMustContainOnlyIntegers extends RuntimeException {
    
    //constructors
    public CepMustContainOnlyIntegers(String errorMessage){
        super(errorMessage);
    }
}
