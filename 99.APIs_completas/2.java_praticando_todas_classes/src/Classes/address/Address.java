package Classes.address;

public class Address {
    //attributes
    private String street;
    private Integer number;
    private Country country;

    //constructors
    public Address(String street, Integer number, Country country){
        this.street = street;
        this.number = number;
        this.country = country;
    }

    //getters and setters
    public String getStreet(){
        return this.street;
    }

    public void setStreet(String street){
        this.street = street;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Country getCountry() {
        return this.country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
    
    //toString()
    @Override
    public String toString(){
        return
            String.format(
                "Street: %s\n" + 
                "Number: %d\n" + 
                "Country: %s\n", this.street, this.number, this.country.getName() 
            );
    }
}
