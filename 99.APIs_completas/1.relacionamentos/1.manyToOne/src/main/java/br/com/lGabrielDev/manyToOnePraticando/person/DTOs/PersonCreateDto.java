package br.com.lGabrielDev.manyToOnePraticando.person.DTOs;

public class PersonCreateDto {
    
    //attributes
    private String name;

    //constructors
    public PersonCreateDto(){}

    public PersonCreateDto(String name){
        this.name = name;
    }

    //getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
