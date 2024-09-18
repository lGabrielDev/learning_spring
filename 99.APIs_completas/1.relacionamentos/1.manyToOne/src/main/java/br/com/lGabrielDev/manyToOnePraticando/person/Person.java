package br.com.lGabrielDev.manyToOnePraticando.person;

import java.util.HashSet;
import java.util.Set;
import br.com.lGabrielDev.manyToOnePraticando.address.Address;
import br.com.lGabrielDev.manyToOnePraticando.person.DTOs.PersonCreateDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_person")
public class Person {
    
    //attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increment
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @OneToMany(mappedBy = "owner") //o campo da entidade A que criou a relação
    private Set<Address> addresses;

    //constructor
    public Person(){
        this.addresses = new HashSet<>();
    }

    public Person(PersonCreateDto personDto){
        this.name = personDto.getName();
        this.addresses = new HashSet<>();
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

    public Set<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }
}
