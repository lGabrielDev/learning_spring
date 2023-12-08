package br.com.lGabrielDev.CepProject.models.person.DTOs;
import br.com.lGabrielDev.CepProject.models.address.DTOs.AddressWithOutOwnerDTO;
import br.com.lGabrielDev.CepProject.models.person.Person;


//Class para representar todos os attributes de uma "person". Lembrando, que o attribute "enderecoCompleto" nao possui informacoes do owner. Isso seria redundante.
public class PersonFullDTO {
    
    //attributes
    private Long id;
    private String name;
    private AddressWithOutOwnerDTO enderecoCompleto;


    //constructors --> Criados pelo lombok
    public PersonFullDTO(Person personCrua){
        this.id = personCrua.getId();
        this.name = personCrua.getName();
        
        //convertendo o attribute "Address" para "AddressWithOutOwnerDTO"
        this.enderecoCompleto.converterAddressCru(personCrua.getEnderecoCompleto());
        
    }


    //getters and setters --> Criados pelo lombok


    //toString() --> Usaremos para debugar
    @Override
    public String toString(){
        return
            String.format(
                "#ID: %d" +
                "Name: %s" +
                "Endereco completo: %s", this.id, this.name, this.enderecoCompleto.toString()
            );
    }

}
