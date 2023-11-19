package br.com.lGabrielDev.projetinhoFelas.exceptions;

public class StudentNotFoundException extends RuntimeException{
    
    //constructors
    public StudentNotFoundException(String errorMessage){
        super(errorMessage);
    }

}
