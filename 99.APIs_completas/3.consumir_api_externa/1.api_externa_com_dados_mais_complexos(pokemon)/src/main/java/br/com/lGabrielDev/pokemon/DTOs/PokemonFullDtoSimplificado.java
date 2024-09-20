package br.com.lGabrielDev.pokemon.DTOs;

import java.util.List;
import br.com.lGabrielDev.pokemon.DTOs.simplificado.SimpleAbilityDto;
import br.com.lGabrielDev.pokemon.DTOs.simplificado.SimpleMoveDto;


public class PokemonFullDtoSimplificado {
    
    //attributes
    private Long id;
    private String name;
    private Integer weight;
    private Integer height;
    private String type;
    private String spriteImage;
    private List<SimpleAbilityDto> abilities;
    private List<SimpleMoveDto> moves;

    //constructors
    public PokemonFullDtoSimplificado(){}

    
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSpriteImage() {
        return spriteImage;
    }

    public void setSpriteImage(String spriteImage) {
        this.spriteImage = spriteImage;
    }

    public List<SimpleAbilityDto> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<SimpleAbilityDto> abilities) {
        this.abilities = abilities;
    }

    public List<SimpleMoveDto> getMoves() {
        return moves;
    }

    public void setMoves(List<SimpleMoveDto> moves) {
        this.moves = moves;
    }
}
