package br.com.lGabrielDev.manyToOnePraticando.address;

import br.com.lGabrielDev.manyToOnePraticando.person.Person;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_address")
public class Address {
    
    //attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increment
    @Column(name = "id")
    private Long id;

    @Column(name = "street", nullable = false, length = 100)
    private String street;

    @Column(name = "number", nullable = false)
    private Integer number;

    @ManyToOne(targetEntity = Person.class)
    @JoinColumn(name = "person_id")
    private Person owner;

    //constructors
    public Address(){};

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

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }
  
}
