package br.com.lGabrielDev.projeto_relacionamento.pokemon;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.lGabrielDev.projeto_relacionamento.pokemon.DTOs.PokemonCreateDto;
import br.com.lGabrielDev.projeto_relacionamento.pokemon.DTOs.PokemonFullDTO;
import br.com.lGabrielDev.projeto_relacionamento.pokemon.DTOs.PokemonFullDTOCountTreinadores;
import br.com.lGabrielDev.projeto_relacionamento.pokemon.DTOs.PokemonFullWithoutTreinadoresDTO;
import br.com.lGabrielDev.projeto_relacionamento.pokemon.enums.PokemonPower;
import br.com.lGabrielDev.projeto_relacionamento.pokemon.validations.PokemonNameValidations;
import br.com.lGabrielDev.projeto_relacionamento.pokemon.validations.PokemonPowerValidations;
import br.com.lGabrielDev.projeto_relacionamento.pokemon.validations.PokemonValidations;

@Service
public class PokemonService {
    
    //attributes
    private PokemonRepository pr;

    //constructors
    public PokemonService(PokemonRepository pr){
        this.pr = pr;
    }

    // ============== POST ==============
    public PokemonFullWithoutTreinadoresDTO createPokemon(PokemonCreateDto pokemonCreateDto){
        
        Pokemon pokemonCru = new Pokemon(); //pokemon cru para salvar no banco

        //name validations
        PokemonNameValidations.pokemonNameisNotNull(pokemonCreateDto.getName());
        PokemonNameValidations.pokemonNameisUnique(pokemonCreateDto.getName(), this.pr);

        pokemonCru.setName(pokemonCreateDto.getName()); //tudo certo, setamos o 'name'
        
        //power validations
        PokemonPowerValidations.pokemonPowerIsNotNull(pokemonCreateDto.getPower());
        PokemonPowerValidations.pokemonPowerExists(pokemonCreateDto.getPower());
        
        switch(pokemonCreateDto.getPower()){ //tudo certo, setamos o 'power'
            case "fire":
                pokemonCru.setPower(PokemonPower.FIRE);
                break;
            case "water":
                pokemonCru.setPower(PokemonPower.WATER);
                break;
            case "grass":
                pokemonCru.setPower(PokemonPower.GRASS);
                break;
        }

        this.pr.save(pokemonCru); //salvamos no banco

        return new PokemonFullWithoutTreinadoresDTO(pokemonCru);
    }


    // ============== GET ==============
    public List<PokemonFullDTOCountTreinadores> getPokemons(){

        List<PokemonFullDTOCountTreinadores> pokemonsFullDtos = new ArrayList<>();

        //request params
        

        this.pr.findAll().stream()
            .forEach((pokemon) -> {
                PokemonFullDTOCountTreinadores pokemonDto = new PokemonFullDTOCountTreinadores(pokemon);
                pokemonsFullDtos.add(pokemonDto);
            });

    
        return pokemonsFullDtos;
    }
    
    
    public PokemonFullDTO getPokemonById(Long pokemonId){
        //verificamos se o pokemon existe no banco
        PokemonValidations.pokemonExists(this.pr, pokemonId);

        Pokemon pokemonCru = this.pr.findById(pokemonId).get();

        return new PokemonFullDTO(pokemonCru);
    }
}
