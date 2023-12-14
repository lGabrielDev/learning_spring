package br.com.lGabrielDev.tests_bolados.models.Person.dtos;

public class PersonCreateDTO {
    
    //attributes
    private String name;
    private String email;

    //constructors
    public PersonCreateDTO(){}


    public PersonCreateDTO(String name, String email){
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    //getters and setters
    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
