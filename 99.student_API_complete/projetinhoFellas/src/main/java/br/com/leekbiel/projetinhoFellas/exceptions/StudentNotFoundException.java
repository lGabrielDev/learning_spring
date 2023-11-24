package br.com.leekbiel.projetinhoFellas.exceptions;

public class StudentNotFoundException extends RuntimeException{

    //constructors
    public StudentNotFoundException(String errorMessage){
        super(errorMessage);
    }
}
