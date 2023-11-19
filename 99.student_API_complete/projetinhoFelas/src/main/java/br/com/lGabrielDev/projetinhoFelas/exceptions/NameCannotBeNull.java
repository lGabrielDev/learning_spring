package br.com.lGabrielDev.projetinhoFelas.exceptions;

public class NameCannotBeNull extends RuntimeException{
    
    //constructors
    public NameCannotBeNull(String errorMessage){
        super(errorMessage);
    }
}
