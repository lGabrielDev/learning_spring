package br.com.lGabrielDev.oneToOne.models.ticket;

public class TicketDtoCreate {
    
    //attributes
    private Integer cadeiraNumber;
    private Long ownerId;


    //constructor
    public TicketDtoCreate(){}


    //getters and setters
    public Integer getCadeiraNumber() {
        return cadeiraNumber;
    }

    public void setCadeiraNumbers(Integer cadeiraNumber) {
        this.cadeiraNumber = cadeiraNumber;
    }


    public Long getOwnerId() {
        return ownerId;
    }


    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }


    //toString()
    @Override
    public String toString() {
        return "TicketDtoCreate [cadeiraNumbers=" + cadeiraNumber + ", owner=" + ownerId + "]";
    }

}
