package Classes.exceptions;

public class ToManyCharacters extends Exception {
    
    //attributes
    private String errorMessageInsane;

    //constructor
    public ToManyCharacters(String errorMessageInsane){
        this.errorMessageInsane = errorMessageInsane;
    }


    //getters and setters
    public String getErrorMessageInsane() {
        return this.errorMessageInsane;
    }

    public void setErrorMessageInsane(String errorMessageInsane) {
        this.errorMessageInsane = errorMessageInsane;
    }
}
