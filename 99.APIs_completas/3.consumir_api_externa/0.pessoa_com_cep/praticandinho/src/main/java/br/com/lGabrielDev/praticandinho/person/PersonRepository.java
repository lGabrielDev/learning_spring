package br.com.lGabrielDev.praticandinho.person;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long>{
    //queries
}
