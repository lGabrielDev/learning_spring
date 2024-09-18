package br.com.lGabrielDev.projeto_relacionamento.pokemon.DTOs;

import java.util.HashSet;
import java.util.Set;
import br.com.lGabrielDev.projeto_relacionamento.pokemon.Pokemon;
import br.com.lGabrielDev.projeto_relacionamento.pokemon.enums.PokemonPower;
import br.com.lGabrielDev.projeto_relacionamento.treinador.DTOs.TreinadorOnlyIDAndNameDTO;

public class PokemonFullDTO {

    //attributes
    private Long id;
    private String name;
    private PokemonPower power;
    private Set<TreinadorOnlyIDAndNameDTO> treinadores;

    //constructor
    public PokemonFullDTO(){
        this.treinadores = new HashSet<>();
    }

    public PokemonFullDTO(Pokemon pokemonCru){
        this.id = pokemonCru.getId();
        this.name = pokemonCru.getName();
        this.power = pokemonCru.getPower();
        this.treinadores = TreinadorOnlyIDAndNameDTO.converterListaTreinadores(pokemonCru.getTreinadores());
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

    public PokemonPower getPower() {
        return power;
    }

    public void setPower(PokemonPower power) {
        this.power = power;
    }

    public Set<TreinadorOnlyIDAndNameDTO> getTreinadores() {
        return treinadores;
    }

    public void setTreinadores(Set<TreinadorOnlyIDAndNameDTO> treinadores) {
        this.treinadores = treinadores;
    }
}
