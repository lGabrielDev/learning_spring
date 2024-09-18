package br.com.lGabrielDev.manyToOnePraticando.address.DTOs;

import br.com.lGabrielDev.manyToOnePraticando.address.Address;

public class AddressFullDtoOwnerId {
    
    //attributes
    private Long id;
    private String street;
    private Integer number;
    private Long ownerId;

    //constructors
    public AddressFullDtoOwnerId(){}

    public AddressFullDtoOwnerId(Address addressCru){
        this.id = addressCru.getId();
        this.street = addressCru.getStreet();
        this.number = addressCru.getNumber();
        this.ownerId = addressCru.getOwner().getId();
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

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }
}
