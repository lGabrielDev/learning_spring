package br.com.lGabrielDev.praticandinho.person;

import br.com.lGabrielDev.praticandinho.address.Address;
import br.com.lGabrielDev.praticandinho.person.DTOs.PersonCreateDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity //transformamos essa Class em uma table no banco
@Table(name = "tb_person") //setamos o nome da table
public class Person {
    
    //attributes
    @Id // PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increment
    @Column(name = "id") //setamos as info dessa column (constraints etc..)
    private Long id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @OneToOne(targetEntity = Address.class) //criamos a relacao.
    @JoinColumn(name = "address_id", nullable = false, unique = true) //criamos um campo nessa entidade. Esse campo deve ser unico. 1 pessoa nao pode ter o mesmo endereco de outra pessoa
    private Address fullAddress;

    //constructors
    public Person(PersonCreateDto personCreateDto, Address addressCru){
        this.name = personCreateDto.getName();
        this.fullAddress = addressCru;
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

    public Address getFullAddress() {
        return fullAddress;
    }

    public void setFullAddress(Address fullAddress) {
        this.fullAddress = fullAddress;
    }

    //toString()
    @Override
    public String toString() {
        return "Person [id=" + id + ", name=" + name + ", fullAddress=" + fullAddress + "]";
    }  
}
