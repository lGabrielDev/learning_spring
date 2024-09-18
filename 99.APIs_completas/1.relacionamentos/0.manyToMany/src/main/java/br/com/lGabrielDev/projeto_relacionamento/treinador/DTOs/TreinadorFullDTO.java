package br.com.lGabrielDev.projeto_relacionamento.treinador.DTOs;

import java.util.*;

import br.com.lGabrielDev.projeto_relacionamento.pokemon.Pokemon;
import br.com.lGabrielDev.projeto_relacionamento.pokemon.DTOs.PokemonFullWithoutTreinadoresDTO;
import br.com.lGabrielDev.projeto_relacionamento.treinador.Treinador;

public class TreinadorFullDTO {

    //attributes
    private Long id;
    private String name;
    private Set<PokemonFullWithoutTreinadoresDTO> pokemons;

    //constructors
    public TreinadorFullDTO(){
        this.pokemons = new HashSet<>();
    }


    public TreinadorFullDTO(Long id, String name, Set<PokemonFullWithoutTreinadoresDTO> pokemons){
        this.id = id;
        this.name = name;
        this.pokemons = pokemons;
    }

    public TreinadorFullDTO(Treinador treinadorCru){
        this.id = treinadorCru.getId();
        this.name = treinadorCru.getName();
        this.pokemons = this.converterListaPokemon(treinadorCru.getPokemons());
    }

    //getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<PokemonFullWithoutTreinadoresDTO> getPokemons() {
        return pokemons;
    }

    public void setPokemons(Set<PokemonFullWithoutTreinadoresDTO> pokemons) {
        this.pokemons = pokemons;
    }


    //transformar lista de pokemons CRUS para uma lista de pokemonsFullDto. 
    public Set<PokemonFullWithoutTreinadoresDTO> converterListaPokemon(Set<Pokemon> pokemonsCrus){
        
        Set<PokemonFullWithoutTreinadoresDTO> pokemonsFullDto = new HashSet<>();

        pokemonsCrus.stream()
            .forEach((pokemon) -> {
                PokemonFullWithoutTreinadoresDTO pokemonDto = new PokemonFullWithoutTreinadoresDTO(pokemon);
                pokemonsFullDto.add(pokemonDto);
            });

        return pokemonsFullDto;
    }
}
