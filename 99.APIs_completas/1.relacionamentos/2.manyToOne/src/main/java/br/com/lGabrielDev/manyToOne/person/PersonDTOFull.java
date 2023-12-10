package br.com.lGabrielDev.manyToOne.person;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import br.com.lGabrielDev.manyToOne.Address.AddressDTOWithOutPersons;

//usaremos essa DTO CLass para mostrar todos os attributes de uma Person, inclusive seus addresses
public class PersonDTOFull {
    
    //attributes
    private Long id;
    private String name;
    private Set<AddressDTOWithOutPersons> addresses;


    //constructors
    public PersonDTOFull(){}
    
    public PersonDTOFull(Person personCrua){
        this.id = personCrua.getId();
        this.name = personCrua.getName();

        this.addresses = AddressDTOWithOutPersons.converterAddress(personCrua.getAddresses());
        
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

    public Set<AddressDTOWithOutPersons> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<AddressDTOWithOutPersons> addresses) {
        this.addresses = addresses;
    }



    //converer uma lista crua de "Person" em uma lista de "PersonDTOFull"

     public static List<PersonDTOFull> converterAddress(List<Person> personsCrus){
        
        List<PersonDTOFull> personsConvertidos = new ArrayList<>();

        for(Person i : personsCrus){
            PersonDTOFull p1 = new PersonDTOFull(i);
            personsConvertidos.add(p1);
        }
        
        return personsConvertidos;

    }
}