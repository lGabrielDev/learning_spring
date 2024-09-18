package br.com.lGabrielDev.oneToOne.ticket.DTOs;

import br.com.lGabrielDev.oneToOne.person.Person;
import br.com.lGabrielDev.oneToOne.person.DTOs.PersonFullDtoWithoutTicket;
import br.com.lGabrielDev.oneToOne.ticket.Ticket;

public class TicketFullDto {
    
    //attributes
    private Long id;
    private Integer chairNumber;
    private PersonFullDtoWithoutTicket owner;

    //constructors
    public TicketFullDto(){}

    public TicketFullDto(Ticket ticketCru){
        this.id = ticketCru.getId();
        this.chairNumber = ticketCru.getChairNumber();
        this.owner = this.converterPersonParaUmDto(ticketCru.getOwner());
    }

    public Long getId() {
        return id;
    }

    //getters and setters
    public void setId(Long id) {
        this.id = id;
    }

    public Integer getChairNumber() {
        return chairNumber;
    }

    public void setChairNumber(Integer chairNumber) {
        this.chairNumber = chairNumber;
    }

    public PersonFullDtoWithoutTicket getOwner() {
        return owner;
    }

    public void setOwner(PersonFullDtoWithoutTicket owner) {
        this.owner = owner;
    }

    //converter uma "Person" em uma "PersonFullDtoWithoutTicket"
    public PersonFullDtoWithoutTicket converterPersonParaUmDto(Person personCru){
        return new PersonFullDtoWithoutTicket(personCru);
    }
}
