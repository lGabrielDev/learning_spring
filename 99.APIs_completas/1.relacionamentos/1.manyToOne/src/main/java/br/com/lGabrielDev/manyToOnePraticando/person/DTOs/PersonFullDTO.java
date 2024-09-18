package br.com.lGabrielDev.manyToOnePraticando.person.DTOs;

import java.util.HashSet;
import java.util.Set;
import br.com.lGabrielDev.manyToOnePraticando.address.DTOs.AddressFullDTOWithoutPerson;
import br.com.lGabrielDev.manyToOnePraticando.address.methodsInsanos.AddressMethodsInsanos;
import br.com.lGabrielDev.manyToOnePraticando.person.Person;

public class PersonFullDTO {
    
    //attributes
    private Long id;
    private String name;
    private Set<AddressFullDTOWithoutPerson> addresses;

    //constructors
    public PersonFullDTO(){
        this.addresses = new HashSet<>();
    }

    public PersonFullDTO(Person personCru){
        this.id = personCru.getId();
        this.name = personCru.getName();
        this.addresses = AddressMethodsInsanos.converterLista(personCru.getAddresses());
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

    public Set<AddressFullDTOWithoutPerson> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<AddressFullDTOWithoutPerson> addresses) {
        this.addresses = addresses;
    }
}
