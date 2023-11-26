package br.com.lGabrielDev.manyToMany.models.Pokemon.DTOs;

import java.util.HashSet;
import java.util.Set;

import br.com.lGabrielDev.manyToMany.enums.PokemonPower;
import br.com.lGabrielDev.manyToMany.models.Pokemon.Pokemon;
import br.com.lGabrielDev.manyToMany.models.Treinador.Treinador;
import br.com.lGabrielDev.manyToMany.models.Treinador.DTOs.TreinadorDTOOnlyIdAndName;

//usaremos essa class para enviar um "pokemon" com todos os attributes
public class PokemonDTOFull {
    
    //attributes
    private Long id;
    private String name;
    private PokemonPower power;
    private Set<TreinadorDTOOnlyIdAndName> treinadores;
    

    //constructors
    public PokemonDTOFull(){
        treinadores = new HashSet<>();
    }

    public PokemonDTOFull(Long id, String name, PokemonPower power, Set<TreinadorDTOOnlyIdAndName> treinadores) {
        this.id = id;
        this.name = name;
        this.power = power;
        this.treinadores = treinadores;
    }


    public PokemonDTOFull(Pokemon pokemonCru){
        this.id = pokemonCru.getId();
        this.name = pokemonCru.getName();
        this.power = pokemonCru.getPower();


        //convertemos a lista crua de "Treinador" para uma lista de "Treinador com com apenas '#ID' and 'name'"
        Set<TreinadorDTOOnlyIdAndName> treinadoresConvertidos = new HashSet<>();

        for(Treinador i : pokemonCru.getTreinadores()){
            TreinadorDTOOnlyIdAndName t1 = new TreinadorDTOOnlyIdAndName();
            t1.setId(i.getId());
            t1.setName(i.getName());

            treinadoresConvertidos.add(t1);
        }

        this.treinadores = treinadoresConvertidos;
        
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


    public Set<TreinadorDTOOnlyIdAndName> getTreinadores() {
        return treinadores;
    }


    public void setTreinadores(Set<TreinadorDTOOnlyIdAndName> treinadores) {
        this.treinadores = treinadores;
    }



    //toString()
    @Override
    public String toString(){
        return
            String.format(
                "#ID: %d\n" + 
                "#Name: %s\n" + 
                "Power: %s\n", this.id, this.name,this.power  //NAO MISTURE AS COISAS. SE QUISER RETORNAR A LISTA DE POKEMONS DESSE TREINADOR, CRIE UM METHOD PARA ISSO. Só vamos mostrar os attributes que NÃO TEM RELAÇAO com outras entidades.
            );
    }
        
}
