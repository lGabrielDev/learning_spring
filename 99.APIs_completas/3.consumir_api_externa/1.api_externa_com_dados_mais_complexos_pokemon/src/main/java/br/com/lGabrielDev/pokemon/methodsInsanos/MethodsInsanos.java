package br.com.lGabrielDev.pokemon.methodsInsanos;

import java.util.ArrayList;
import java.util.List;

import br.com.lGabrielDev.pokemon.DTOs.PokemonFullDtoApiExterna;
import br.com.lGabrielDev.pokemon.DTOs.PokemonFullDtoSimplificado;
import br.com.lGabrielDev.pokemon.DTOs.abilities.AbilityDto;
import br.com.lGabrielDev.pokemon.DTOs.moves.MoveDto;
import br.com.lGabrielDev.pokemon.DTOs.simplificado.SimpleAbilityDto;
import br.com.lGabrielDev.pokemon.DTOs.simplificado.SimpleMoveDto;

public abstract class MethodsInsanos {
    
    //converter um "pokemon da API externa" para um "pokemon simplificado"
    public static PokemonFullDtoSimplificado simplificarPokemon(PokemonFullDtoApiExterna pokemonApiExterna){
        PokemonFullDtoSimplificado pokemonSimplificado = new PokemonFullDtoSimplificado();
        pokemonSimplificado.setId(pokemonApiExterna.getId());
        pokemonSimplificado.setName(pokemonApiExterna.getName());
        pokemonSimplificado.setWeight(pokemonApiExterna.getWeight());
        pokemonSimplificado.setHeight(pokemonApiExterna.getHeight());
        pokemonSimplificado.setType(pokemonApiExterna.getTypes().get(0).getType().getName());
        pokemonSimplificado.setSpriteImage(pokemonApiExterna.getSprites().getFront_shiny());
        
        pokemonSimplificado.setAbilities(simplificarHabilidades(pokemonApiExterna.getAbilities()));
        pokemonSimplificado.setMoves(simplificarMoves(pokemonApiExterna.getMoves()));

        return pokemonSimplificado; 
    }

    //converter uma lista de abilities complexa para uma lista de abilities simplificada
    public static List<SimpleAbilityDto> simplificarHabilidades(List<AbilityDto> abilities){
        List<SimpleAbilityDto> simpleAbilities = new ArrayList<>();

        for(Integer i = 0; i < abilities.size(); i++){ 
            SimpleAbilityDto simpleAbility = new SimpleAbilityDto();
            simpleAbility.setAbilityId(Long.valueOf(i));
            simpleAbility.setName(abilities.get(i).getAbility().getName());
            
            simpleAbilities.add(simpleAbility);
        }

        return simpleAbilities;
    }

    //converter uma lista de moves complexa para uma lista de moves simplificada
    public static List<SimpleMoveDto> simplificarMoves(List<MoveDto> moves){
        List<SimpleMoveDto> simpleMoves = new ArrayList<>();

        for(Integer i = 0; i < moves.size(); i++){ 
            SimpleMoveDto simpleMove = new SimpleMoveDto();
            simpleMove.setMoveId((Long.valueOf(i)));
            simpleMove.setName(moves.get(i).getMove().getName());
            
            simpleMoves.add(simpleMove);
        }

        return simpleMoves;
    }

}
