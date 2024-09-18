package Classes.enums;

public enum Vehicles {
    //CONSTANTS
    BIKE("bike", "bike é insana para ir ao trabalho sem gastar dinheiro", 60),
    CAR("car", "car é insano para ter conforto", 200),
    JATO("airplane", "airplane é insano para olhar para o céu", 400);

    //attributes
    private final String name; //como são variables que não vao mudar o valor, deixamos como final mesmo.
    private final String description;
    private final Integer maxSpeedInKmPerHr;

    //constructors
    private Vehicles(String name, String description, Integer maxSpeedInKmPerHr){
        this.name = name;
        this.description = description;
        this.maxSpeedInKmPerHr = maxSpeedInKmPerHr;
    }

    //getters and setters
    public String getName(){
        return this.name;
    }

    public String getDescription() {
        return description;
    }

    public Integer getMaxSpeedInKmPerHr() {
        return maxSpeedInKmPerHr;
    }

    //toString()
    @Override
    public String toString(){
        return
            String.format(
                "Vehicle name: %s\n" +
                "Description: %s\n" +
                "Max Speed in km/h: %d\n", this.name, this.description, this.maxSpeedInKmPerHr
            );
    }
}
