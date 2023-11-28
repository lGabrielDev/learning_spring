package br.com.lGabrielDev.oneToOne.models.ticket;
import br.com.lGabrielDev.oneToOne.models.person.Person;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "tb_ticket")
public class Ticket {
    
    //attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @Column(name = "numero_cadeira", unique = true)
    Integer numeroCadeira;

    @OneToOne(targetEntity = Person.class) //estamos criando uma relação 1-1 com a entidade "tal"
    @JoinColumn(name = "owner_id") //Criamos um campo adicional nessa entidade. Esse campo vai ser a PK da entidade A. No caso, person_id.
    Person owner; //como um ticket pode ter APENAS 1 pessoa, criamos apenas um objeto


    //constructor
    public Ticket(){}

    public Ticket(Integer numeroCadeira, Person owner){
        this.numeroCadeira = numeroCadeira;
        this.owner = owner;
    }


    //getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumeroCadeira() {
        return numeroCadeira;
    }

    public void setNumeroCadeira(Integer numeroCadeira) {
        this.numeroCadeira = numeroCadeira;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }


    //toString() se precisar
    @Override
    public String toString() {
        return "Ticket [id=" + id + ", numeroCadeira=" + numeroCadeira + ", owner=" + owner + "]";
    }
}
