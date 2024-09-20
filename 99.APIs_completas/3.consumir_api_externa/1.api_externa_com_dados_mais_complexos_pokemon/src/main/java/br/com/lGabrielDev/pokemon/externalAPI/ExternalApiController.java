package br.com.lGabrielDev.pokemon.externalAPI;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.lGabrielDev.pokemon.DTOs.PokemonFullDtoApiExterna;

@FeignClient(name = "pokemonAPI", url = "https://pokeapi.co/api/v2/pokemon")
public interface ExternalApiController {
    
    // =================== GET ===================
    @GetMapping("/{pokemon}")
    public PokemonFullDtoApiExterna getAllPokemonInfo(@PathVariable("pokemon") String pokemon);
}
