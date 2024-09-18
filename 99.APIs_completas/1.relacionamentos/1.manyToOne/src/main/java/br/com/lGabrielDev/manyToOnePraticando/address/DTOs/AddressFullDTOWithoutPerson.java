package br.com.lGabrielDev.manyToOnePraticando.address.DTOs;

import br.com.lGabrielDev.manyToOnePraticando.address.Address;

public class AddressFullDTOWithoutPerson {
    
    //attributes
    private Long id;
    private String street;
    private Integer number;

    //constructors
    public AddressFullDTOWithoutPerson(Address addressCru){
        this.id = addressCru.getId();
        this.street = addressCru.getStreet();
        this.number = addressCru.getNumber();
    }

    //getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
