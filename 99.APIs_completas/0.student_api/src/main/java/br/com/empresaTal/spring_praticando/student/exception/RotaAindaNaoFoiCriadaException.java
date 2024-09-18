package br.com.empresaTal.spring_praticando.student.exception;

public class RotaAindaNaoFoiCriadaException extends RuntimeException {
    
    //constructor
    public RotaAindaNaoFoiCriadaException(String errorMessage){
        super(errorMessage);
    }
}
