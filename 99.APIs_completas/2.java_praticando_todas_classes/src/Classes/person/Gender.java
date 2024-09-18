package Classes.person;

public enum Gender {
    //CONSTANTS
    MALE("male"),
    FEMALE("female");

    //attributes
    private String name;

    //constructors
    private Gender(String name){
        this.name = name;
    }

    //getters and setters
    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }
}
