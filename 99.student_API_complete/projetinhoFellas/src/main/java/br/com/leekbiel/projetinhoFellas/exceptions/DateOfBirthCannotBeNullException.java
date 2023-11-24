package br.com.leekbiel.projetinhoFellas.exceptions;

public class DateOfBirthCannotBeNullException extends RuntimeException{
    
    //constructors
    public DateOfBirthCannotBeNullException(String Errormessage){
        super(Errormessage);
    }
}
