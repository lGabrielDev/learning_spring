package br.com.lGabrielDev.tests_bolados.models.Person;

import br.com.lGabrielDev.tests_bolados.models.Person.dtos.PersonCreateDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity //mapeamos essa class para uma table no banco
@Table(name = "tb_person") //setamos o name da table
public class Person {
    
    //attributes
    @Id //PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increment
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;


    //constructors
    public Person(){}

    public Person(String name, String email){
        this.name = name;
        this.email = email;
    }

    public Person(PersonCreateDTO personDto){
        this.name = personDto.getName();
        this.email = personDto.getEmail();
    }

   


    //getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    //toString() --> Para debugar
    @Override
    public String toString(){
        return
            String.format( 
                """
                #ID: %d
                Name: %s
                Email: %s
                """, this.id, this.name, this.email
            );
    }
    
    
}
