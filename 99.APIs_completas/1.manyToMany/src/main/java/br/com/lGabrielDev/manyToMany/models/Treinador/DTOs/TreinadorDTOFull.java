package br.com.lGabrielDev.manyToMany.models.Treinador.DTOs;

import java.util.HashSet;
import java.util.Set;

import br.com.lGabrielDev.manyToMany.models.Pokemon.Pokemon;
import br.com.lGabrielDev.manyToMany.models.Treinador.Treinador;

public class TreinadorDTOFull {
    
    //attributes
    private Long id;
    private String name;
    private Set<Pokemon> pokemons;


    //constructors
    public TreinadorDTOFull(){
        pokemons = new HashSet<>(); //inicializamos para nao ter problema
    }


    public TreinadorDTOFull(Long id, String name){
        this.id = id;
        this.name = name;
        pokemons = new HashSet<>(); //inicializamos para nao ter problema
    }


    public TreinadorDTOFull(Long id, String name, HashSet<Pokemon> pokemons){
        this.id = id;
        this.name = name;
        this.pokemons = pokemons;
    }


    public TreinadorDTOFull(Treinador t1){ //passamos um treinador e copiamos todos os seus attributes
        this.id = t1.getId();
        this.name = t1.getName();
        this.pokemons = t1.getPokemons();
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


    public Set<Pokemon> getPokemons() {
        return pokemons;
    }


    public void setPokemons(Set<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    


    //printar pokemons
    public void showPokemons(Set<Pokemon> pokemons){
        for(Pokemon i : pokemons){
            System.out.println("Pokemon name: " + i.getName());
        }
    }



   


    //toString() 
    @Override
    public String toString(){
        return
            String.format(
                "#ID: %d\n" + 
                "Name: %s\n", this.id, this.name  //NAO MISTURE AS COISAS. SE QUISER RETORNAR A LISTA DE POKEMONS DESSE TREINADOR, CRIE UM METHOD PARA ISSO. Só vamos mostrar os attributes que NÃO TEM RELAÇAO com outras entidades.
            );
    }


}
