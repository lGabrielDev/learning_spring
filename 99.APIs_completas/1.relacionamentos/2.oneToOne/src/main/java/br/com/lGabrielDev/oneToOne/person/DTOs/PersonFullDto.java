package br.com.lGabrielDev.oneToOne.person.DTOs;

import br.com.lGabrielDev.oneToOne.person.Person;
import br.com.lGabrielDev.oneToOne.ticket.Ticket;
import br.com.lGabrielDev.oneToOne.ticket.DTOs.TicketFullDtoWithoutPerson;

public class PersonFullDto {
    
    //attributes
    private Long id;
    private String name;
    private TicketFullDtoWithoutPerson ticket;

    //constructors
    public PersonFullDto(){}

    public PersonFullDto(Person personCru){
        this.id = personCru.getId();
        this.name = personCru.getName();

        if(personCru.getTicket() != null){
            this.ticket = this.removerPersonDoTicket(personCru.getTicket());
        }
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

    public TicketFullDtoWithoutPerson getTicket() {
        return this.ticket;
    }

    public void setTicket(TicketFullDtoWithoutPerson ticket) {
        this.ticket = ticket;
    }

    //converter um "ticket" em um "TicketFullDtoWithoutPerson"
    public TicketFullDtoWithoutPerson removerPersonDoTicket(Ticket ticket){
        return new TicketFullDtoWithoutPerson(ticket);
    }
}
