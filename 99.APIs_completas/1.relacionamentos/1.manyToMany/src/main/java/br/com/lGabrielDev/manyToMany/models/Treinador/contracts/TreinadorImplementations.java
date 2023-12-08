package br.com.lGabrielDev.manyToMany.models.Treinador.contracts;

import java.util.List;

import br.com.lGabrielDev.manyToMany.models.Treinador.DTOs.TreinadorDTOCreateOnlyName;
import br.com.lGabrielDev.manyToMany.models.Treinador.DTOs.TreinadorDTOFull;
import br.com.lGabrielDev.manyToMany.models.Treinador.DTOs.TreinadorDTOQuantidadePokemons;

public interface TreinadorImplementations {
    
    //methods para implementar

    // ============================== READ ==============================
    //FindBy #ID
    public TreinadorDTOFull getTreinador(Long treinadorId);


    //FindBy All, filtrando por determinado "pokemon name"
    public abstract List<TreinadorDTOQuantidadePokemons> getTreinadores(String pokemonName, Integer quantidadePokemons);

    

    // ============================== CREATE ==============================
    public TreinadorDTOFull createTreinador(TreinadorDTOCreateOnlyName novoTreinador);


    // ============================== Adicionar Pokemons ==============================
    public TreinadorDTOFull addPokemons(Long treinadorId, List<Long> pokemonsIds);




    
    
}
