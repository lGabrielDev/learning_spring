package br.com.lGabrielDev.projeto.models.person;
import br.com.lGabrielDev.projeto.models.person.dtos.PersonCreateDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "tb_person")
public class Person {
    
    //attributes
    @Id //primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increment
    @Column(name = "id")
    private Long id;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "age")
    private Integer age;


    //constructors
    public Person(){}

    public Person(String name, Integer age){
        this.name = name;
        this.age = age;
    }

    public Person(PersonCreateDto p1){
        this.name = p1.getName();
        this.age = p1.getAge();
    }


    //getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

   


    //toString() para debugar
    @Override
    public String toString() {
        return
            String.format(
                "#ID: %d\n" +
                "Name: %s\n" +
                "Age: %d\n", this.id, this.name, this.age
            );
    }
}
