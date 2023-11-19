package br.com.lGabrielDev.projetinhoFelas.exceptions;

public class DateOfBirthCannotBeNull extends RuntimeException{
    
    //constructors
    public DateOfBirthCannotBeNull(String errorMessage){
        super(errorMessage);
    }
}
