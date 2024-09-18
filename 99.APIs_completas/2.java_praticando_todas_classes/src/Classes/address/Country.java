package Classes.address;

public class Country {
    //attributes
    private String name;
    private Integer countryCode;

    //constructors
    public Country(){}
    
    public Country(String name, Integer countryCode){
        this.name = name;
        this.countryCode = countryCode;
    }
    
    //getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(Integer countryCode) {
        this.countryCode = countryCode;
    }

    //toString()
    @Override
    public String toString() {
        return
            String.format(
                "Country name: %s\n" +
                "Country code: #%d\n", this.name, this.countryCode 
            );
    }
  
}
