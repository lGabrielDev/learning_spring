package br.com.lGabrielDev.projeto_relacionamento.pokemon.validations;

import br.com.lGabrielDev.projeto_relacionamento.pokemon.PokemonRepository;

public abstract class PokemonNameValidations {
    

    //check pokemon name is not null
    public static Boolean pokemonNameisNotNull(String name){
        if(name == null || name.isBlank()){
            throw new RuntimeException("Pokemon 'name' is null or has only white spaces");
        }
        return true;
    }

    //check pokemon name is unique
    public static Boolean pokemonNameisUnique(String name, PokemonRepository pr){
        if(pr.findByName(name).isPresent()){
            throw new RuntimeException("Pokemon already exists!!!");
        } 
        return true;
    }
}
