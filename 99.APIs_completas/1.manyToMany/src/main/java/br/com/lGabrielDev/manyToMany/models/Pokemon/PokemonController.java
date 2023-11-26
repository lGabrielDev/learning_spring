package br.com.lGabrielDev.manyToMany.models.Pokemon;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.lGabrielDev.manyToMany.models.Pokemon.DTOs.PokemonDTOCreate;
import br.com.lGabrielDev.manyToMany.models.Pokemon.DTOs.PokemonDTOFull;
import br.com.lGabrielDev.manyToMany.models.Pokemon.DTOs.PokemonDTOQuantidadeTreiadores;


@RestController
@RequestMapping("/api")
public class PokemonController {

    //attributes injetados
    @Autowired
    private PokemonService ps;
    
    //rotas

    // =================================================== CREATE ===================================================
    @PostMapping("/pokemon")
    public PokemonDTOFull createPokemon(@RequestBody PokemonDTOCreate novoPokemon){
        return this.ps.createPokemon(novoPokemon);
    }


    // =================================================== READ ===================================================
    //Find By #ID
    @GetMapping("/pokemon/{id}")
    public PokemonDTOFull getPokemon(@PathVariable(value = "id") Long id){
        return this.ps.getPokemon(id);
    }

    //Find All
    @GetMapping("/pokemon")
    public List<PokemonDTOQuantidadeTreiadores> getAllPokemons (){
        return this.ps.getAllPokemons();
    }
    
}
