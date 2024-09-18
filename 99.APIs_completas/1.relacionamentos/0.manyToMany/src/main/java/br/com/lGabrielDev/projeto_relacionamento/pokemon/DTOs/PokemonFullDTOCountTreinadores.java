package br.com.lGabrielDev.projeto_relacionamento.pokemon.DTOs;

import br.com.lGabrielDev.projeto_relacionamento.pokemon.Pokemon;
import br.com.lGabrielDev.projeto_relacionamento.pokemon.enums.PokemonPower;

public class PokemonFullDTOCountTreinadores {
    
    //attributes
    private Long id;
    private String name;
    private PokemonPower power;
    private Integer treinadoresQuantity;

    //constructors
    public PokemonFullDTOCountTreinadores(){}

    public PokemonFullDTOCountTreinadores(Long id, String name, PokemonPower power, Integer treinadoresQuantity){
        this.id = id;
        this.name = name;
        this.power = power;
        this.treinadoresQuantity = treinadoresQuantity;
    }

    public PokemonFullDTOCountTreinadores(Pokemon pokemonCru){
        this.id = pokemonCru.getId();
        this.name = pokemonCru.getName();
        this.power = pokemonCru.getPower();
        this.treinadoresQuantity = pokemonCru.getTreinadores().size();
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

    public Integer getTreinadoresQuantity() {
        return treinadoresQuantity;
    }

    public void setTreinadoresQuantity(Integer treinadoresQuantity) {
        this.treinadoresQuantity = treinadoresQuantity;
    }
}
