package br.com.lGabrielDev.CepProject.errors.exceptions;

public class CepMustContainEightCharacters extends RuntimeException{
    
    //constructors
    public CepMustContainEightCharacters(String errorMessage){
        super(errorMessage);
    }
}
