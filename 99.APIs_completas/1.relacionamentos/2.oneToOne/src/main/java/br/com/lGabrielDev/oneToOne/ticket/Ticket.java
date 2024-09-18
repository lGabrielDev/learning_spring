package br.com.lGabrielDev.oneToOne.ticket;

import br.com.lGabrielDev.oneToOne.person.Person;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_ticket")
public class Ticket {
    
    //attributes
    @Id //Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increment
    @Column(name = "id")
    private Long id;

    @Column(name = "chair_number", nullable = false, unique = true)
    private Integer chairNumber;

    @OneToOne(targetEntity = Person.class)
    @JoinColumn(name = "owner_id", nullable = false, unique = true)
    private Person owner;

    //constructors
    public Ticket(){}

    //getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getChairNumber() {
        return chairNumber;
    }

    public void setChairNumber(Integer chairNumber) {
        this.chairNumber = chairNumber;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }
    
}
