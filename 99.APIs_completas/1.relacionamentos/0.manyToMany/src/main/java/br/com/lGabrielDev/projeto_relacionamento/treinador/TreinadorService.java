package br.com.lGabrielDev.projeto_relacionamento.treinador;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import br.com.lGabrielDev.projeto_relacionamento.pokemon.Pokemon;
import br.com.lGabrielDev.projeto_relacionamento.pokemon.PokemonRepository;
import br.com.lGabrielDev.projeto_relacionamento.treinador.DTOs.TreinadorCreateDTO;
import br.com.lGabrielDev.projeto_relacionamento.treinador.DTOs.TreinadorFullDTO;
import br.com.lGabrielDev.projeto_relacionamento.treinador.DTOs.TreinadorFullDTOCountPokemons;
import br.com.lGabrielDev.projeto_relacionamento.treinador.validations.TreinadorValidations;

@Service
public class TreinadorService {
    
    //attributes
    private TreinadorRepository tr;
    private PokemonRepository pr;

    //constructors
    public TreinadorService(TreinadorRepository tr, PokemonRepository pr){
        this.tr = tr;
        this.pr = pr;
    }


    // ============== POST ==============
    public TreinadorFullDTO createTreinador(TreinadorCreateDTO treinadorOnlyName){
        
        if(treinadorOnlyName.getName() == null || treinadorOnlyName.getName().isBlank()){
            throw new RuntimeException("O campo 'name' está em branco");
        }

        //criamos um "treinador Cru" para salvarmos no banco
        Treinador treinadorCru = new Treinador(treinadorOnlyName);
        this.tr.save(treinadorCru);

        return new TreinadorFullDTO(treinadorCru);
    }


    // ============== POST add pokemons ==============
    public TreinadorFullDTO addPokemons(Long treinadorId, List<Long> pokemonIds){

        //verificamos se o treinador existe
        TreinadorValidations.treinadorExists(treinadorId, this.tr);

        //verificamos se os pokemons #IDs existem
        TreinadorValidations.pokemonsExists(pokemonIds, this.pr);

        Treinador treinadorCru = this.tr.findById(treinadorId).get();

        //criamos uma lista/set desses pokemons
        Set<Pokemon> pokemonsCrus = new HashSet<>();

        pokemonIds.stream()
            .forEach((pokemonId) -> {
                Pokemon pokemonCru = this.pr.findById(pokemonId).get();
                pokemonsCrus.add(pokemonCru);
            });

        //verificamos se o treinador ja possui algum desses pokemons
        TreinadorValidations.treinadorDoesNotHaveThesePokemons(pokemonsCrus, treinadorCru);

        //tudo certo..
        //treinador existe
        //pokemons existem
        //treinador nao possui nenhum desses pokemons
        pokemonsCrus.stream()
            .forEach((pokemon) -> {
                pokemon.getTreinadores().add(treinadorCru); //adicionamos em um lado da relacao
                this.pr.save(pokemon); //salvamos a alteracao desse pokemon no banco
                treinadorCru.getPokemons().add(pokemon); //adicionamos no outro lado da relacao também
            });

        this.tr.save(treinadorCru);
        
        return new TreinadorFullDTO(treinadorCru);
    }



    // ============== GET ==============
    public List<TreinadorFullDTOCountPokemons> getTreinadores(String pokemonName, Integer pokemonQuantity){

        List<TreinadorFullDTOCountPokemons> treinadoresFullDtos = new ArrayList<>();

        List<Treinador> treinadoresCrus = new ArrayList<>();

        //request params
        if(pokemonName == null && pokemonQuantity == null){
            treinadoresCrus = this.tr.findAllDefault();
        }
        else if(pokemonName != null && pokemonQuantity == null){
            treinadoresCrus = this.tr.findAll(pokemonName);
        }
        else if(pokemonName == null && pokemonQuantity != null){
            treinadoresCrus = this.tr.findAll(pokemonQuantity);
        }
        else{
            treinadoresCrus = this.tr.findAll(pokemonName, pokemonQuantity);
        }

        treinadoresCrus.stream()
            .forEach((treinador) -> {
                TreinadorFullDTOCountPokemons treinadorDto = new TreinadorFullDTOCountPokemons(treinador);
                treinadoresFullDtos.add(treinadorDto);
            });

        return treinadoresFullDtos;
    }


    public TreinadorFullDTO getTreinadorById(Long treinadorId){
        //verificamos se o treinador existe no banco
        TreinadorValidations.treinadorExists(treinadorId, this.tr);

        Treinador treinadorCru = this.tr.findById(treinadorId).get();

        return new TreinadorFullDTO(treinadorCru);
    }
}
