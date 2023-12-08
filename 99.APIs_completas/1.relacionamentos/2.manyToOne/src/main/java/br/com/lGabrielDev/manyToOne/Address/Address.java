package br.com.lGabrielDev.manyToOne.Address;
import br.com.lGabrielDev.manyToOne.person.Person;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_address")
public class Address {

    //attributes

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "street", length = 50)
    private String street;

    @Column(name = "number")
    private Integer houseNumber;



    @ManyToOne(targetEntity = Person.class) //Informamos que queremos ter uma relação com outra entidade.
    @JoinColumn(name = "person_id") //Essa é a parte MANY da relaçao. Portanto, criamos o campo adicional, referenciando a PK da outra entidade, aqui.
    private Person owner; //Um endereco pode ser de apenas 1 pessoa. Portanto, nao criamos uma lista e sim uma "Pessoa" unica
  

    //constructors
    public Address(){}

    public Address(String street, Integer houseNumber, Person owner) {
        this.street = street;
        this.houseNumber = houseNumber;
        this.owner = owner;
    }

    


    //getters and setters
    public Long getId() {
        return id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(Integer houseNumber) {
        this.houseNumber = houseNumber;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }
}
