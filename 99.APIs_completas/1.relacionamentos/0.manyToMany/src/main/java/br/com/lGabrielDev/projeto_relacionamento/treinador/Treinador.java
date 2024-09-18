package br.com.lGabrielDev.projeto_relacionamento.treinador;

import java.util.HashSet;
import java.util.Set;
import br.com.lGabrielDev.projeto_relacionamento.pokemon.Pokemon;
import br.com.lGabrielDev.projeto_relacionamento.treinador.DTOs.TreinadorCreateDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity //transformamos essa Class em uma entity no banco
@Table(name = "tb_treinador") //setamos o nome da table
public class Treinador {

    //attributes
    @Id //Primary KEY
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increment
    @Column(name = "id")
    private Long id;

    @Column(name = "name", length = 100, nullable = false, unique = true)
    private String name;

    @ManyToMany(targetEntity = Pokemon.class) //criamos a conexao das entidades
    @JoinTable( //criamos a association table para relacionar as 2 tables
        name = "treinador_pokemon",
        joinColumns = @JoinColumn(name = "treinador_id"), //criamos o primeiro campo, referenciando a PK da table A
        inverseJoinColumns = @JoinColumn(name = "pokemon_id") //criamos o segundo campo, referenciando a PK da table B
    )
    private Set<Pokemon> pokemons;

    //constructors
    public Treinador(){
        this.pokemons = new HashSet<>();
    }

    public Treinador(String name, Set<Pokemon> pokemons){
        this.name = name;
        this.pokemons = pokemons;
    }

    public Treinador(TreinadorCreateDTO treinadorDto){
        this.pokemons = new HashSet<>();
        this.name = treinadorDto.getName();
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

    //toString()
}