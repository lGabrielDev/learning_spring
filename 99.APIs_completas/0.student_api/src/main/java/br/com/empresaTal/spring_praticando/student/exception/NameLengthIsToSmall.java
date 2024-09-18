package br.com.empresaTal.spring_praticando.student.exception;

public class NameLengthIsToSmall extends RuntimeException {
    
    //constructors
    public NameLengthIsToSmall(String ErrorMessage){
        super(ErrorMessage);
    }
}
