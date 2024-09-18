package br.com.lGabrielDev.projeto_relacionamento.pokemon.validations;

import br.com.lGabrielDev.projeto_relacionamento.pokemon.PokemonRepository;

public abstract class PokemonValidations {
    
    //check if pokemon #ID exists
    public static Boolean pokemonExists(PokemonRepository pr, Long pokemonID){
        if(pr.findById(pokemonID).isEmpty()){
            throw new RuntimeException(String.format("Pokemon #%d doesn't exists", pokemonID));
        }
        return true;
    }
}
