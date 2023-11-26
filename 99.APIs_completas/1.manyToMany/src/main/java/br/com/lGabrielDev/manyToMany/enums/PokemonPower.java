package br.com.lGabrielDev.manyToMany.enums;

public enum PokemonPower {
    
    //constants
    ELECTRICITY("Electricity"),
    FIRE("Fire"),
    WATER("Water"),
    GRASS("Grass");

    //attributes
    private String name;


    //constructors
    private PokemonPower(String name){
        this.name = name;
    }


    public String getName() {
        return name;
    }
}
