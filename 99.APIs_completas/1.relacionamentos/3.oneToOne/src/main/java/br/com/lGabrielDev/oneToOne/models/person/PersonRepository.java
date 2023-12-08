package br.com.lGabrielDev.oneToOne.models.person;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository  extends JpaRepository <Person, Long>{
    
    //queries
}
