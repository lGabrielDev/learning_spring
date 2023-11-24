package br.com.leekbiel.projetinhoFellas.exceptions;

public class NameCannotBeNullException extends RuntimeException{

    //constructors
    public NameCannotBeNullException(String errorMessage){
        super(errorMessage);
    }
}
