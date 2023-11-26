package br.com.lGabrielDev.manyToMany.models.Treinador;
import java.util.HashSet;
import java.util.Set;
import br.com.lGabrielDev.manyToMany.models.Pokemon.Pokemon;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity//transformamos essa Class em uma Entity no banco
@Table(name = "tb_treinador") //setamos o nome dessa table 
public class Treinador {
    
    //attributes
    @Id //esse e o campo PRIMARY KEY
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increment
    @Column(name = "id") //configuramos o campo
    private Long id;

    @Column(name = "name", length = 50)
    private String name;


    @ManyToMany(targetEntity = Pokemon.class) //informamos a entity B que queremos fazer relação
    @JoinTable( //criamos uma association table para conseguir relacionar essas 2 entidades. 
        name = "treinador_pokemon", //setamos o nome dessa nova table
        joinColumns = @JoinColumn(name = "treinador_id"), //Criamos o primeiro campo dessa table, que sera a PK da entity A
        inverseJoinColumns = @JoinColumn(name = "pokemon_id") //Criamos o segundo campo dessa table, que sera a PK da entity B
    )
    private Set<Pokemon> pokemons; //esse é o attribute que vamos usar para relacionar as 2 entidades. Usamos 'Set<>' porque nós NÃO QUEREMOS pokemons iguais nessa lista. 1 treinador pode ter VÁRIOS pokemons, porem eles nao se repetem.



    //constructors
    public Treinador(){
        this.pokemons = new HashSet<>(); //inicializamos essa lista para nao ter problema.
    }
    
    public Treinador(String name){ //usaremos para criar um treinador, sem precisar passar uma lista de pokemons
        this.name = name;
        this.pokemons = new HashSet<>(); //inicializamos essa lista para nao ter problema.
    }

    public Treinador(String name, HashSet<Pokemon> pokemons){  //usaremos para criar um treinador, que já possua pokemons 
        this.name = name;
        this.pokemons = pokemons;
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

    public Set<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(Set<Pokemon> pokemons) {
        this.pokemons = pokemons;
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
