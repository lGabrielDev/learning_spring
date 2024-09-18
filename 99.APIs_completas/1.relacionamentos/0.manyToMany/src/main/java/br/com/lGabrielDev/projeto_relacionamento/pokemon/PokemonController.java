package br.com.lGabrielDev.projeto_relacionamento.pokemon;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import br.com.lGabrielDev.projeto_relacionamento.pokemon.DTOs.PokemonCreateDto;
import br.com.lGabrielDev.projeto_relacionamento.pokemon.DTOs.PokemonFullDTO;
import br.com.lGabrielDev.projeto_relacionamento.pokemon.DTOs.PokemonFullDTOCountTreinadores;
import br.com.lGabrielDev.projeto_relacionamento.pokemon.DTOs.PokemonFullWithoutTreinadoresDTO;

@RestController
@RequestMapping("/api/v1")
public class PokemonController {
    
    //attributes
    private PokemonService ps;

    //constructors
    public PokemonController(PokemonService ps){
        this.ps = ps;
    }

    // ============== POST ==============
    @PostMapping("/pokemons")
    public ResponseEntity<PokemonFullWithoutTreinadoresDTO> createPokemon(@RequestBody PokemonCreateDto pokemonCreateDto){
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(this.ps.createPokemon(pokemonCreateDto));
    }


    // ============== GET ==============
    @GetMapping("/pokemons")
    public ResponseEntity<List<PokemonFullDTOCountTreinadores>> getPokemons(){
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(this.ps.getPokemons());
    }

    @GetMapping("/pokemons/{id}")
    public ResponseEntity<PokemonFullDTO> getPokemonById(@PathVariable("id") Long pokemonId){
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(this.ps.getPokemonById(pokemonId));
    }
}
