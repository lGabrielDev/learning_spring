package br.com.lGabrielDev.praticandinho.person.DTOs;

public class PersonCreateDto {
    
    //attributes
    private String name;
    private String cep;
    private Integer numeroCasa;

    //constructors
    public PersonCreateDto(){}

    //getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Integer getNumeroCasa() {
        return numeroCasa;
    }

    public void setNumeroCasa(Integer numeroCasa) {
        this.numeroCasa = numeroCasa;
    }
}
