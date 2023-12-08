package br.com.lGabrielDev.manyToOne.Address;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.lGabrielDev.manyToOne.person.Person;
import br.com.lGabrielDev.manyToOne.person.PersonRepository;

@RestController
@RequestMapping(path = "/address")
public class AddressController {

    //injected attributes
    @Autowired
    private AddressRepository ar;

    @Autowired
    private PersonRepository pr;

    //rotas


    //READ
    @GetMapping("")
    public List<Address> getAllAddresses(
        @RequestParam(value =  "ownerId", required = false) Long ownerId
    ){
        if(ownerId != null){
            return this.ar.findAll(ownerId);
        }
        return this.ar.findAll();
    }


    //CREATE
    @PostMapping("")
    public Address createAddress(@RequestBody(required = true) AddressDTOCreate novoAddress){
        
        //um endereco esta associado a uma "Person". Portanto, um address nao pode ter o campo "owner" em branco
        if(novoAddress.getOwnerId() == null){
            throw new RuntimeException("Esse endereco deve pertencer á alguma 'Pessoa'");
        }

        //Endereco possui um dono??? Vamos verificar se esse dono existe no banco de dados
        Optional<Person> pOptional = this.pr.findById(novoAddress.getOwnerId());


        if(pOptional.isEmpty()){
            throw new RuntimeException(String.format("Não foi possível cadastrar o endereco, pois o owner #%d nao existe.",novoAddress.getOwnerId()));
        }


        //Tudo certo. O campo/attribute "ownerID" foi informado, e esse owner de fato existe no banco.
        //Agora, é só criar esse endereco
        Person addressOwner = pOptional.get();

        Address a1 = new Address(
            novoAddress.getStreetName(),
            novoAddress.getHouseNumber(),
            addressOwner
        );

        this.ar.save(a1); // salvamos esse endereco no banco.
        
        return a1;
    }
}
