package br.com.lGabrielDev.oneToOne.person.DTOs;

import br.com.lGabrielDev.oneToOne.person.Person;

public class PersonFullDtoWithoutTicket {
 
    //attributes
    private Long id;
    private String name;

    //constructors
    public PersonFullDtoWithoutTicket(){}

    public PersonFullDtoWithoutTicket(Person personCru){
        this.id = personCru.getId();
        this.name = personCru.getName();
    }

    //getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
