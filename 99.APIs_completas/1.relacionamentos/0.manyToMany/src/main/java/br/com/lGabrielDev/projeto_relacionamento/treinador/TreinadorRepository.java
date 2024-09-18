package br.com.lGabrielDev.projeto_relacionamento.treinador;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TreinadorRepository extends JpaRepository<Treinador, Long> {
    
    //queries
    @Query(value = "SELECT t FROM Treinador t ORDER BY t.id ASC")
    public List<Treinador> findAllDefault();

    //Listar apenas os treinadores que possuam o pokemon "pikachu"
    @Query(value = "SELECT t FROM Treinador t JOIN t.pokemons p WHERE p.name = :pokemonName ORDER BY t.id ASC") // Essa query, vai retornar um Treinador. Fizemos um JOIN na table auxiliar, representada pelo attribute que tem relação. Assim, o Hibernate consegue identeificar automaticamente a porra toda. Podendo aplicar os filtros em qualquer das 2 entidades.
    public List<Treinador> findAll(@Param("pokemonName") String name);

    //Listar apenas os treinadores que possuam mais que "tantos" pokemons
    @Query(value = "SELECT t FROM Treinador t WHERE SIZE(t.pokemons) > :quantity ORDER BY t.id ASC")
    public List<Treinador> findAll(@Param("quantity") Integer quantity);

    //Aplicar os dois filtros
    @Query(value = "SELECT t FROM Treinador t JOIN t.pokemons p WHERE p.name = :pokemonName AND SIZE(t.pokemons) > :pokemonQuantity ORDER BY t.id ASC") //JPQL. Referenciamos pela Entidade e seus attributes. Perceba que o JOIN eh no attribute que representa a table auxiliar. Assim, conseguimos aplicar filtros de ambas as entidades.
    public List<Treinador> findAll(@Param("pokemonName") String name, @Param("pokemonQuantity") Integer quantity);
}
