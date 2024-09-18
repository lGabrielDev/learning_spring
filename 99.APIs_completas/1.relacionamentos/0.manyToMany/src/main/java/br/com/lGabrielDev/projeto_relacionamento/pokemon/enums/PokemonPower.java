package br.com.lGabrielDev.projeto_relacionamento.pokemon.enums;

public enum PokemonPower {
    
    //CONSTANTS
    FIRE("fire"),
    WATER("water"),
    GRASS("grass");

    //attributes
    private String name;

    //constructors
    private PokemonPower(String name){
        this.name = name;
    }

    //getters and settes
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    } 
}
