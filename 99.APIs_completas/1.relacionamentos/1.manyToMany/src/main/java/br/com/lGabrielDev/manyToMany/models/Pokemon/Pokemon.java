package br.com.lGabrielDev.manyToMany.models.Pokemon;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import br.com.lGabrielDev.manyToMany.enums.PokemonPower;
import br.com.lGabrielDev.manyToMany.models.Treinador.Treinador;
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

    @Id //esse e o campo PRIMARY KEY
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increment
    @Column(name = "id") //configuramos o campo
    private Long id;

    @Column(name = "name", length = 50)
    private String name;

    @Column(name = "power", length = 50)
    @Enumerated(EnumType.STRING) //informamos que esse campo é um "ENUM".Assim, conseguimos converter para String no banco
    private PokemonPower power;


    @JsonIgnore
    @ManyToMany(mappedBy = "pokemons") //confirmamos a relação, informando o campo da entidade A que iniciou essa relacao.
    private Set<Treinador> treinadores;


    //constructors
    public Pokemon(){
        this.treinadores = new HashSet<>(); // inicializamos para nao ter problema
    }

    public Pokemon(String name, PokemonPower power){ //usaremos para criar um pokemon, sem precisar passar uma lista de treinadores
        this.name = name;
        this.power = power;
        this.treinadores = new HashSet<>(); //inicializamos essa lista para nao ter problema.
    }

    public Pokemon(String name, PokemonPower power, HashSet<Treinador> treinadores){ //usaremos para criar um pokemon, sem precisar passar uma lista de treinadores
        this.name = name;
        this.power = power;
        this.treinadores = treinadores;
    }


    //getters and setters
    public Long getId() {
        return id;
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
