package br.com.lGabrielDev.projeto_relacionamento.pokemon;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PokemonRepository extends JpaRepository<Pokemon, Long>{
    
    //queries
    @Query(value = "SELECT p FROM Pokemon p WHERE p.name = :name")
    public Optional<Pokemon> findByName(@Param("name") String name);
}
