package br.com.empresaTal.spring_praticando.student.exception;

public class AttributeIsNullException extends RuntimeException {
    
    //constructors
    public AttributeIsNullException(String ErrorMessage){
        super(ErrorMessage);
    }
}
