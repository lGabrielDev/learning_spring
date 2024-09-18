package br.com.lGabrielDev.manyToOnePraticando.address.DTOs;

public class AddressCreateDTO {
    
    //attributes
    private String street;
    private Integer number;
    private Long ownerId;

    //constructors
    public AddressCreateDTO(){}

    public String getStreet() {
        return street;
    }

    //getters and setters
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
