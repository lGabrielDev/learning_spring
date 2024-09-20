package br.com.lGabrielDev.pokemon.DTOs;

import java.util.List;

import br.com.lGabrielDev.pokemon.DTOs.abilities.AbilityDto;
import br.com.lGabrielDev.pokemon.DTOs.moves.MoveDto;
import br.com.lGabrielDev.pokemon.DTOs.sprites.SpriteDto;
import br.com.lGabrielDev.pokemon.DTOs.type.TypeDto;

public class PokemonFullDtoApiExterna {
    
    //attributes
    private Long id;
    private String name;
    private Integer weight;
    private Integer height;
    private List<TypeDto> types;
    private SpriteDto sprites;
    private List<AbilityDto> abilities;
    private List<MoveDto> moves;

    //constructors
    public PokemonFullDtoApiExterna(){}

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

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public List<TypeDto> getTypes() {
        return types;
    }

    public void setTypes(List<TypeDto> types) {
        this.types = types;
    }

    public SpriteDto getSprites() {
        return sprites;
    }

    public void setSprites(SpriteDto sprites) {
        this.sprites = sprites;
    }

    public List<AbilityDto> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<AbilityDto> abilities) {
        this.abilities = abilities;
    }

    public List<MoveDto> getMoves() {
        return moves;
    }

    public void setMoves(List<MoveDto> moves) {
        this.moves = moves;
    }
}
