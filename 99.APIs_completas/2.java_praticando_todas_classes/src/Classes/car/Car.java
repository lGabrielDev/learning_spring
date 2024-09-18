package Classes.car;

public class Car {
    //attributes
    private String marca;
    private String modelo;
    private String color;
    private Integer year;
    private Double price;

    //constructor
    public Car(){}

    public Car(String marca, String modelo, String color, Integer year, Double price){
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.year = year;
        this.price = price;
    }

    //getters and setters
    public String getMarca(){
        return this.marca;
    }

    public void setMarca(String marca){
        this.marca = marca;
    }

    public String getModelo() {
        return this.modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getYear() {
        return this.year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Double getPrice(){
        return this.price;
    }

    public void setPrice(Double price){
        this.price = price;
    }


    //toString()
    @Override
    public String toString(){
        return String.format(
            "Marca: %s\n" +
            "Modelo: %s\n" +
            "Color: %s\n" +
            "Year: %d\n" +
            "Double: %.0f\n", this.marca, this.modelo, this.color, this.year, this.price
        );
    }

    //run
    public void run(){
        System.out.println("car is running");
    }

    //brake
    public void brake(){
        System.out.println("car is breaking");
    }
}