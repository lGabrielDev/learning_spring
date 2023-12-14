package br.com.lGabrielDev.tests_bolados.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository <Person, Long>{
    
    
    //queries/methods que vamos testar


    //findAll()
    @Query(nativeQuery = false, value = "SELECT p FROM Person p ORDER BY p.id ASC")
    public List<Person> findAll();


    //findBy()
    @Query(nativeQuery = false, value = "SELECT p FROM Person p WHERE p.id = :id")
    public Optional<Person> findById(@Param(value = "id") Long id);

    @Query(nativeQuery = false, value = "SELECT p FROM Person p WHERE p.name = :name")
    public Optional<Person> findByName(@Param(value = "name") String name);

    @Query(nativeQuery = false, value = "SELECT p FROM Person p WHERE p.email = :email")
    public Optional<Person> findByEmail(@Param(value = "email") String email);
}
