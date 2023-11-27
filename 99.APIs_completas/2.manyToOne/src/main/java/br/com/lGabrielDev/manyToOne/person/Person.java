package br.com.lGabrielDev.manyToOne.person;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.lGabrielDev.manyToOne.Address.Address;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", length = 50)
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "owner") //Confirmamos/mapeamos a relação, informando o campo da outra entidade que solicitou a relacao.
    Set<Address> addresses = new HashSet<>(); //Uma pessoa pode ter VÁRIOS addresses... Entao, criamos uma lista.


    //constructors  
    public Person(){}

    public Person(String name){
        this.name = name;
    }

    

    //getters and setters
    public Long getId() {
        return id;
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


    //toString()
    @Override
    public String toString() {
        return "Person [id=" + id + ", name=" + name + ", addresses=" + addresses + "]";
    }

}
