package br.com.lGabrielDev.manyToOne.Address;


//vamos usar esse DTO class para passar um Address simplificado no body
public class AddressDTOCreate {

    //attributes
    private String streetName;
    private Integer houseNumber;
    private Long ownerId;


    //constructor
    public AddressDTOCreate(){}

   

    public AddressDTOCreate(String streetName, Integer houseNumber, Long ownerId){
        this.streetName = streetName;
        this.houseNumber = houseNumber;
        this.ownerId = ownerId;
    }


    //getters and setters
    public String getStreetName() {
        return streetName;
    }


    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }


    public Integer getHouseNumber() {
        return houseNumber;
    }


    public void setHouseNumber(Integer houseNumber) {
        this.houseNumber = houseNumber;
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
        return "AddressDTOCreate [streetName=" + streetName + ", houseNumber=" + houseNumber + ", ownerId=" + ownerId
                + "]";
    }


}
