package br.com.empresaTal.spring_praticando.student.exception;

public class StudentNotFoundException extends RuntimeException{
    
    //constructors
    public StudentNotFoundException(String errorMessage){
        super(errorMessage);
    }
}
