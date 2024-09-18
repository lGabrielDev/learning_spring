package br.com.lGabrielDev.oneToOne.ticket.DTOs;

import br.com.lGabrielDev.oneToOne.ticket.Ticket;

public class TicketFullDtoWithoutPerson {

    //attributes
    private Long id;
    private Integer chairNumber;

    //constructors
    public TicketFullDtoWithoutPerson(){}

    public TicketFullDtoWithoutPerson(Ticket ticket){
        this.id = ticket.getId();
        this.chairNumber = ticket.getChairNumber();
    }

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
}
