package br.com.lGabrielDev.manyToMany.models.Treinador;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import br.com.lGabrielDev.manyToMany.models.Treinador.DTOs.TreinadorDTOCreateOnlyName;
import br.com.lGabrielDev.manyToMany.models.Treinador.DTOs.TreinadorDTOFull;
import br.com.lGabrielDev.manyToMany.models.Treinador.DTOs.TreinadorDTOQuantidadePokemons;

@RestController
@RequestMapping("/api")
public class TreinadorController {

    //attributes injetados
    @Autowired
    private TreinadorService ts;

    //rotas

    // ========================== CREATE ==========================
    @PostMapping("/treinador")
    public TreinadorDTOFull createTreinador(@RequestBody TreinadorDTOCreateOnlyName novoTreinador){
        return this.ts.createTreinador(novoTreinador);
    }


    // ========================== Adicionar Pokemons ==========================
    @PostMapping("/treinador/{treinadorId}/add-pokemons")
    public TreinadorDTOFull addPokemons(
            @PathVariable(value = "treinadorId") Long treinadorId,
            @RequestBody List<Long> pokemonIds
        )
    {
        return this.ts.addPokemons(treinadorId, pokemonIds);
    }


    // ========================== READ ==========================
    //Find By #ID
    @GetMapping("/treinador/{id}")
    public TreinadorDTOFull getTreinador(@PathVariable(value = "id") Long id){
        return this.ts.getTreinador(id);
    }


    //Find ALL
    @GetMapping("/treinador")
    public List<TreinadorDTOQuantidadePokemons> getTreinadores(
        @RequestParam(value = "pokemonName", required = false) String pokemonName,
        @RequestParam(value = "quantidadePokemons" , required = false) Integer quantidadePokemons
    ){
        return this.ts.getTreinadores(pokemonName, quantidadePokemons);
    }
}
