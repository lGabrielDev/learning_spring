package br.com.lGabrielDev.manyToMany.models.Treinador;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TreinadorRepository extends JpaRepository <Treinador, Long> {
    
    //queries

    // ======================================== READ ========================================
    //Find By #ID
    @Query(nativeQuery = false, value = "SELECT t FROM Treinador t WHERE t.id = :id")
    public Optional<Treinador> findById(@Param(value = "id") Long id);

    //Find All
    @Query(nativeQuery = false, value = "SELECT t FROM Treinador t ORDER BY t.id ASC")
    public List<Treinador> findAll();

    //Listar apenas os treinadores que possuam o pokemon "pikachu"
    @Query(nativeQuery = false, value = "SELECT t FROM Treinador t JOIN t.pokemons p WHERE p.name = :pokemonProcurado ORDER BY t.id asc")// Essa query, vai retornar um Treinador. Fizemos um JOIN na table auxiliar, representada pelo attribute que tem relação. Assim, o Hibernate consegue identeificar automaticamente a porra toda. Podendo aplicar os filtros em qualquer das 2 entidades.
    public List<Treinador> findAll(@Param(value = "pokemonProcurado") String pokemonProcurado);

    //Listar apenas os treinadores que possuam mais que "tantos" pokemons
    @Query(nativeQuery = false, value =  "SELECT t FROM Treinador t WHERE SIZE(t.pokemons) > :maisQueTantosPokemons") //Nao precisamos fazer Join, pq a informacao ja se encontra na entidade "Treinador"
    public List<Treinador> findAll(@Param(value = "maisQueTantosPokemons") Integer maisQueTantosPokemons);

    //Aplicar os dois filtros
    @Query(nativeQuery = false, value = "SELECT t FROM Treinador t JOIN t.pokemons p WHERE p.name = :pokemonProcurado AND SIZE(t.pokemons) > :maisQueTantosPokemons ORDER BY t.id ASC")//JPQL, referenciamos pela Entidade e seus attributes. Perceba que o JOIN e no attribute que representa a table auxiliar. Assim, conseguimos aplicar filtros de ambas as entidades
    public List<Treinador> findAll(@Param(value = "pokemonProcurado") String pokemonProcurado, @Param(value = "maisQueTantosPokemons") Integer maisQueTantosPokemons);

}
