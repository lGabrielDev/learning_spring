package br.com.lGabrielDev.projeto_relacionamento.treinador;

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
import br.com.lGabrielDev.projeto_relacionamento.treinador.DTOs.TreinadorCreateDTO;
import br.com.lGabrielDev.projeto_relacionamento.treinador.DTOs.TreinadorFullDTO;
import br.com.lGabrielDev.projeto_relacionamento.treinador.DTOs.TreinadorFullDTOCountPokemons;

@RestController
@RequestMapping("/api/v1")
public class TreinadorController {
    
    //attributes
    private TreinadorService ts;

    //constructors
    public TreinadorController(TreinadorService ts){
        this.ts = ts;
    }

    // ============== POST ==============
    @PostMapping("/treinadores")
    public ResponseEntity<TreinadorFullDTO> createTreinador(@RequestBody TreinadorCreateDTO treinadorOnlyName){
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(this.ts.createTreinador(treinadorOnlyName));
    }

    // ============== POST ==============
    @PostMapping("/treinadores/{id}/adicionar_pokemons")
    public ResponseEntity<TreinadorFullDTO> createTreinador(@PathVariable("id") Long treinadorId, @RequestBody List<Long> pokemonIds){
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(this.ts.addPokemons(treinadorId, pokemonIds));
    }

    //============== GET ==============
    @GetMapping("/treinadores")
    public ResponseEntity<List<TreinadorFullDTOCountPokemons>> getTreinadores(
        @RequestParam(name = "pokemon_name", required = false) String pokemonName,
        @RequestParam(name = "quantity", required = false) Integer quantidadePokemon
    )
    {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(this.ts.getTreinadores(pokemonName, quantidadePokemon));
    }

    @GetMapping("/treinadores/{id}")
    public ResponseEntity<TreinadorFullDTO> getTreinadores(@PathVariable("id") Long treinadorId){
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(this.ts.getTreinadorById(treinadorId));
    }


}
