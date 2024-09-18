package br.com.lGabrielDev.oneToOne.person;

import br.com.lGabrielDev.oneToOne.person.DTOs.PersonCreateDTO;
import br.com.lGabrielDev.oneToOne.ticket.Ticket;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_person")
public class Person {
    
    //attributes

    @Id //Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increment
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @OneToOne(mappedBy = "owner")
    private Ticket ticket;

    //constructors
    public Person(){}

    public Person(PersonCreateDTO personCreateDTO){
        this.name = personCreateDTO.getName();
    }

    public Long getId() {
        return id;
    }
    
    //getters and setters
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
}
