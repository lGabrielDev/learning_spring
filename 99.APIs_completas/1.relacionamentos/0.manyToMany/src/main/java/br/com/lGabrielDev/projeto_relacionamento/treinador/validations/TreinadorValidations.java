package br.com.lGabrielDev.projeto_relacionamento.treinador.validations;

import java.util.List;
import java.util.Set;
import br.com.lGabrielDev.projeto_relacionamento.pokemon.Pokemon;
import br.com.lGabrielDev.projeto_relacionamento.pokemon.PokemonRepository;
import br.com.lGabrielDev.projeto_relacionamento.treinador.Treinador;
import br.com.lGabrielDev.projeto_relacionamento.treinador.TreinadorRepository;

public abstract class TreinadorValidations {
    

    //check if the 'treinador' exists
    public static Boolean treinadorExists(Long treinadorId, TreinadorRepository tr){
        tr.findById(treinadorId)
            .orElseThrow(() -> new RuntimeException(String.format("Treinador #%d not found!", treinadorId)));
        
            return true;
    }


    //check if the 'pokemons' #IDs exists
    public static Boolean pokemonsExists(List<Long> pokemonIds, PokemonRepository pr){

        pokemonIds.stream()
            .forEach((pokemonId) -> {
                pr.findById(pokemonId)
                    .orElseThrow(() -> new RuntimeException(String.format("Pokemon #%d doesn't exists", pokemonId)));
            } );

        return true;
    }


    //check if the 'treinador' already has those pokemons
    public static Boolean treinadorDoesNotHaveThesePokemons(Set<Pokemon> pokemons, Treinador treinador){
        pokemons.stream()
            .forEach((pokemon) -> {
                if(treinador.getPokemons().contains(pokemon)){
                    throw new RuntimeException(String.format("Treinador ja possui o pokemon '%s'", pokemon.getName()));
                }
            });
        return true;
    }
}
