package br.com.lGabrielDev.oneToOne.ticket.DTOs;

public class TicketCreateDto {

    //attributes
    private Integer chairNumber;
    private Long ownerId;

    //constructors
    public TicketCreateDto(){}

    //getters and setters
    public Integer getChairNumber() {
        return chairNumber;
    }

    public void setChairNumber(Integer chairNumber) {
        this.chairNumber = chairNumber;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    } 
}
