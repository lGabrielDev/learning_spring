package br.com.lGabrielDev.projeto_relacionamento.treinador.DTOs;

import br.com.lGabrielDev.projeto_relacionamento.treinador.Treinador;

public class TreinadorFullDTOCountPokemons {

    //attributes
    private Long id;
    private String name;
    private Integer pokemonQuantity;

    //constructors
    public TreinadorFullDTOCountPokemons(){}


    public TreinadorFullDTOCountPokemons(Long id, String name, Integer pokemonQuantity){
        this.id = id;
        this.name = name;
        this.pokemonQuantity = pokemonQuantity;
    }

    public TreinadorFullDTOCountPokemons(Treinador treinadorCru){
        this.id = treinadorCru.getId();
        this.name = treinadorCru.getName();
        this.pokemonQuantity = treinadorCru.getPokemons().size();
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

    public Integer getPokemonQuantity() {
        return pokemonQuantity;
    }

    public void setPokemonQuantity(Integer pokemonQuantity) {
        this.pokemonQuantity = pokemonQuantity;
    } 
}
