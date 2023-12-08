package br.com.lGabrielDev.manyToMany.models.Pokemon.DTOs;
import java.util.ArrayList;
import java.util.List;
import br.com.lGabrielDev.manyToMany.enums.PokemonPower;
import br.com.lGabrielDev.manyToMany.models.Pokemon.Pokemon;


//usaremos essa class na rota de "listar todos os pokemons"
public class PokemonDTOQuantidadeTreiadores {

    //attributes
    private Long id;
    private String name;
    private PokemonPower power;
    private Integer quantidadeTreinadores;



    //constructors
    public PokemonDTOQuantidadeTreiadores(){
        this.quantidadeTreinadores = 0; // inicializamos para nao ter problema depois
    }

    public PokemonDTOQuantidadeTreiadores(Pokemon pokemonCru){
        this.id = pokemonCru.getId();
        this.name = pokemonCru.getName();
        this.power = pokemonCru.getPower();
        this.quantidadeTreinadores = pokemonCru.getTreinadores().size();
    }



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


    public PokemonPower getPower() {
        return power;
    }


    public void setPower(PokemonPower power) {
        this.power = power;
    }


    public Integer getQuantidadeTreinadores() {
        return quantidadeTreinadores;
    }


    public void setQuantidadeTreinadores(Integer quantidadeTreinadores) {
        this.quantidadeTreinadores = quantidadeTreinadores;
    }

   

    //conveter uma lista de pokemons para uma lista de "PokemonDTOQuantidadeTreiadores"
    public static List<PokemonDTOQuantidadeTreiadores> converterPokemons(List<Pokemon> pokemonsCrus){

        List<PokemonDTOQuantidadeTreiadores> pokemonsConvertidos = new ArrayList<>();
        
        for(Pokemon i : pokemonsCrus){
            PokemonDTOQuantidadeTreiadores p1 = new PokemonDTOQuantidadeTreiadores(i);
            pokemonsConvertidos.add(p1);
        }

        return pokemonsConvertidos;
    }
    
    
}
