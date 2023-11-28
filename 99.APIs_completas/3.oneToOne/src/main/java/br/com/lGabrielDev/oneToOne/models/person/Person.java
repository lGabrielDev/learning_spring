package br.com.lGabrielDev.oneToOne.models.person;
import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.lGabrielDev.oneToOne.models.ticket.Ticket;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_person")
public class Person {
    
    //attributes
    @Id //primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increment
    @Column(name = "id") //setamos as configs desse campo
    private Long id;

    @Column(name = "name", length = 320)
    private String name;


    @JsonIgnore //cancelamos o looping infinito de relacionamento
    @OneToOne(mappedBy = "owner", cascade = CascadeType.ALL) //nao queremos criar um campo nessa entidade/table. Portanto, apenas mapeamos a relação, informando o attribute da outra entidade que startou a relacao. Quem vai criar o campo será a outra entidade.
    private Ticket ticket; //como uma pessoa pode ter APENAS 1 ticket, criamos apenas 1 objeto


    //constructors
    public Person(){}

    public Person(String name){ //podemos criar uma pessoa, sem precisar dizer o ticket dela
        
    }


    public Person(PersonDTOCreate newPerson){ //usaremos esse constructor para pegar os dados de uma DTO, passado na hora de criar uma "person"
        this.name = newPerson.getName();
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

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }


    //toString() se precisar
    @Override
    public String toString() {
        return "Person [id=" + id + ", name=" + name + ", ticket=" + ticket + "]";
    }
}
