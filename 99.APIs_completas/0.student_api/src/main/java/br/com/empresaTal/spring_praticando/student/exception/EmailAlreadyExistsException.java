package br.com.empresaTal.spring_praticando.student.exception;

public class EmailAlreadyExistsException extends RuntimeException{
    
    //constructor
    public EmailAlreadyExistsException(String errorMessage){
        super(errorMessage);
    }
}
