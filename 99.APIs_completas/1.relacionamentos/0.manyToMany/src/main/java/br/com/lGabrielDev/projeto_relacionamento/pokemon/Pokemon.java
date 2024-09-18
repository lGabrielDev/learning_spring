package br.com.lGabrielDev.projeto_relacionamento.pokemon;


import java.util.HashSet;
import java.util.Set;
import br.com.lGabrielDev.projeto_relacionamento.pokemon.enums.PokemonPower;
import br.com.lGabrielDev.projeto_relacionamento.treinador.Treinador;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_pokemon")
public class Pokemon {
    
    //attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false, unique = true, length = 100)
    private String name;

    @Column(name = "power", nullable = false, length = 100)
    @Enumerated(EnumType.STRING)
    private PokemonPower power;

    @ManyToMany(mappedBy = "pokemons")
    private Set<Treinador> treinadores;

    //constructors
    public Pokemon(){
        this.treinadores = new HashSet<>();
    }

    public Pokemon(String name, PokemonPower power, Set<Treinador> treinadores){
        this.name = name;
        this.power = power;
        this.treinadores = treinadores;
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

    public Set<Treinador> getTreinadores() {
        return treinadores;
    }

    public void setTreinadores(Set<Treinador> treinadores) {
        this.treinadores = treinadores;
    }

    //toString()    
}