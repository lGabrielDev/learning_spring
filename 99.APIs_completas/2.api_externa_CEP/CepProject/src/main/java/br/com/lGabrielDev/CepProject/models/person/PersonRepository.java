package br.com.lGabrielDev.CepProject.models.person;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import feign.Param;

@Repository
public interface PersonRepository extends JpaRepository <Person, Long> {

    //queries

    // ===================================== READ =====================================

    //READ ALL
    @Query(nativeQuery = false, value = "SELECT p FROM Person p ORDER BY p.id DESC")
    public List<Person> findAll();



    //READ, filtrando pelo Estado (UF)
    @Query(nativeQuery = false, value = "SELECT p FROM Person p JOIN p.enderecoCompleto a WHERE a.uf = :uf ORDER BY p.id DESC")
    public List<Person> findAll(@Param(value = "uf") String uf);
}
