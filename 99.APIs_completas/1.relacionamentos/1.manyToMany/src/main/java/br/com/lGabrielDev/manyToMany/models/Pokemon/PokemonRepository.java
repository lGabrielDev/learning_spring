package br.com.lGabrielDev.manyToMany.models.Pokemon;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



@Repository
public  interface PokemonRepository extends JpaRepository<Pokemon, Long>{
    
    //queries

    //Findy By #ID
    @Query(nativeQuery = false, value = "SELECT p FROM Pokemon p WHERE p.id = :id")
    public Optional<Pokemon> findById(@Param(value = "id") Long id);


    //Findy ALL
    @Query(nativeQuery = false, value = "SELECT p FROM Pokemon p ORDER BY p.id ASC")
    public List<Pokemon> findAll();
}
