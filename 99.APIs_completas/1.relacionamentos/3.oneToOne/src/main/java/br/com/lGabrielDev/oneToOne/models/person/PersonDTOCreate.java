package br.com.lGabrielDev.oneToOne.models.person;

//usaremos essa class apenas para criar "persons"
public class PersonDTOCreate {
    
    //attributes
    private String name;

    //constructor
    public PersonDTOCreate(){}

    public PersonDTOCreate(String name){
        this.name = name;
    }

    //getters and setters
    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }


    //toString(){}
    @Override
    public String toString(){
        return String.format("Name: %s", this.name);
    }
}
