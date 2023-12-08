package br.com.lGabrielDev.manyToMany.exceptions;


public class PokemonPowerNotFound extends RuntimeException{
    
    //constructors
    public PokemonPowerNotFound(String errorMessage){
        super(errorMessage);
    }

}
