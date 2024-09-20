package br.com.lGabrielDev.pokemon;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.lGabrielDev.pokemon.DTOs.PokemonFullDtoApiExterna;
import br.com.lGabrielDev.pokemon.DTOs.PokemonFullDtoSimplificado;
import br.com.lGabrielDev.pokemon.externalAPI.ExternalApiController;
import br.com.lGabrielDev.pokemon.methodsInsanos.MethodsInsanos;

@RestController
@RequestMapping("/api")
public class PokemonController {
    
    //attributes
    private ExternalApiController externalApi; // eh atraves desse objeto que vamos conseguir fazer as solicitacoes para a API externa

    //constructors --> Injecao de dependencia
    public PokemonController(ExternalApiController externalApi){
        this.externalApi = externalApi;
    }

    // =================== GET ===================
    @GetMapping("/pokemon/{name}")
    public ResponseEntity<PokemonFullDtoSimplificado> getPokemon(@PathVariable("name") String pokemon){
        
        PokemonFullDtoApiExterna pokemonApiExterna = this.externalApi.getAllPokemonInfo(pokemon);
        PokemonFullDtoSimplificado pokemonSimplificado = MethodsInsanos.simplificarPokemon(pokemonApiExterna);

        return ResponseEntity
            .status(HttpStatus.OK)
            .body(pokemonSimplificado);
    }
}
