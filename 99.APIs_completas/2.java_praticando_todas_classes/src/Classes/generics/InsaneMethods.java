package Classes.generics;

public class InsaneMethods <T> {

    //attributes
    private T name;
    
    //constructors
    public InsaneMethods(){}

    public InsaneMethods(T name){
        this.name = name;
    }

    //getters and setters
    public T getName() {
        return name;
    }

    public void setName(T name) {
        this.name = name;
    }

    // ############### methods genericos ###############
    public static <T> void print(T thing){
        System.out.println(thing);
    }

    // printar array
    
}
