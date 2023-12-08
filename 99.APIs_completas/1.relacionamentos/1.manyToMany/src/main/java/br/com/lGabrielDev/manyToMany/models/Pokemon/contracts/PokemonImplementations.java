package br.com.lGabrielDev.manyToMany.models.Pokemon.contracts;
import java.util.List;

import br.com.lGabrielDev.manyToMany.models.Pokemon.DTOs.PokemonDTOCreate;
import br.com.lGabrielDev.manyToMany.models.Pokemon.DTOs.PokemonDTOFull;
import br.com.lGabrielDev.manyToMany.models.Pokemon.DTOs.PokemonDTOQuantidadeTreiadores;

public interface PokemonImplementations {
    //methods para implementar

    // ============================== CREATE ==============================
    public abstract PokemonDTOFull createPokemon(PokemonDTOCreate novoPokemon);


    // ============================== READ ==============================
    //FindBy #ID
    public abstract PokemonDTOFull getPokemon(Long id);

    //FindBy All
    public abstract List<PokemonDTOQuantidadeTreiadores> getAllPokemons();



    
    
}
