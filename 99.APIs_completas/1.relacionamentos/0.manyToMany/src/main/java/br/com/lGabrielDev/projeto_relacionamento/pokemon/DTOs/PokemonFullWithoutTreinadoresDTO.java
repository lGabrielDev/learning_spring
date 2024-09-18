package br.com.lGabrielDev.projeto_relacionamento.pokemon.DTOs;

import br.com.lGabrielDev.projeto_relacionamento.pokemon.Pokemon;
import br.com.lGabrielDev.projeto_relacionamento.pokemon.enums.PokemonPower;

public class PokemonFullWithoutTreinadoresDTO {
    
    //attributes
    private Long id;
    private String name;
    private PokemonPower power;

    //constructors
    public PokemonFullWithoutTreinadoresDTO(){}

    public PokemonFullWithoutTreinadoresDTO(Long id, String name, PokemonPower power){
        this.id = id;
        this.name = name;
        this.power = power;
    }

    public PokemonFullWithoutTreinadoresDTO(Pokemon pokemonCru){
        this.id = pokemonCru.getId();
        this.name = pokemonCru.getName();
        this.power = pokemonCru.getPower();
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
}
