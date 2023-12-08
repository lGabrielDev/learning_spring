package br.com.lGabrielDev.manyToOne.Address;

import java.util.HashSet;
import java.util.Set;

public class AddressDTOWithOutPersons {
    
    //attributes
    private Long id;
    private String street;
    private Integer houseNumber;


    //constructors
    public AddressDTOWithOutPersons(){}

    public AddressDTOWithOutPersons(Address adressCru){
        this.id = adressCru.getId();
        this.street = adressCru.getStreet();
        this.houseNumber = adressCru.getHouseNumber();
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

    public Integer getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(Integer houseNumber) {
        this.houseNumber = houseNumber;
    }
    
    

    //converter uma Lista crua de "Address" em uma lista de "AddressDTOWithOutPersons"
    public static Set<AddressDTOWithOutPersons> converterAddress(Set<Address> addressesCrus){
        
        Set<AddressDTOWithOutPersons> addressesConvertidos = new HashSet<>();

        for(Address i : addressesCrus){
            AddressDTOWithOutPersons a1 = new AddressDTOWithOutPersons(i);
            addressesConvertidos.add(a1);
        }
        
        return addressesConvertidos;
    }

}
