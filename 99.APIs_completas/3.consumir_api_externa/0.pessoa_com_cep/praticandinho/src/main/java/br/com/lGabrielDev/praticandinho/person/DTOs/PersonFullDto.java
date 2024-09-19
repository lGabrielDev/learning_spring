package br.com.lGabrielDev.praticandinho.person.DTOs;

import br.com.lGabrielDev.praticandinho.address.DTOs.AddressWithoutPerson;
import br.com.lGabrielDev.praticandinho.address.converterAddress.ConverterAddress;
import br.com.lGabrielDev.praticandinho.person.Person;

public class PersonFullDto {
    
    //attributes
    private Long id;
    private String name;
    private AddressWithoutPerson fullAddress;

    //constructors
    public PersonFullDto(){}

    public PersonFullDto(Person personCru){
        this.id = personCru.getId();
        this.name = personCru.getName();
        this.fullAddress = ConverterAddress.converter(personCru.getFullAddress());
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

    public AddressWithoutPerson getFullAddress() {
        return fullAddress;
    }

    public void setFullAddress(AddressWithoutPerson fullAddress) {
        this.fullAddress = fullAddress;
    }

    //toString()
    @Override
    public String toString() {
        return "PersonFullDto [id=" + id + ", name=" + name + ", fullAddress=" + fullAddress + "]";
    }
}
