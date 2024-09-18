package br.com.lGabrielDev.projeto_relacionamento.pokemon.DTOs;

public class PokemonCreateDto {
    
    //attributes
    private String name;
    private String power;

    //constructor
    public PokemonCreateDto(){}


    // public PokemonCreate(String name, String power){
    //     this.name = name;
    //     this.power = power;
    // }

    //getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }
}
