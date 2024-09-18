package Classes.exceptions;

public class DivideByZeroException extends Exception {
    
    //constructor
    public DivideByZeroException(String errorMessage){
        super(errorMessage);
    }
}
