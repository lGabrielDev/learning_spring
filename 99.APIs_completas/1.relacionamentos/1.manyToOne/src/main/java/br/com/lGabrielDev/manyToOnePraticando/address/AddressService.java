package br.com.lGabrielDev.manyToOnePraticando.address;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import br.com.lGabrielDev.manyToOnePraticando.address.DTOs.AddressCreateDTO;
import br.com.lGabrielDev.manyToOnePraticando.address.DTOs.AddressFullDtoOwnerId;
import br.com.lGabrielDev.manyToOnePraticando.person.Person;
import br.com.lGabrielDev.manyToOnePraticando.person.PersonRepository;
import br.com.lGabrielDev.manyToOnePraticando.person.methodsInsanos.PersonMethodsInsanos;

@Service
public class AddressService {
    
    //attributes
    private AddressRepository ar;
    private PersonRepository pr;

    //constructors
    public AddressService(AddressRepository ar, PersonRepository pr){
        this.ar = ar;
        this.pr = pr;
    }

    // ============ POST ============
    public AddressFullDtoOwnerId createAddress(AddressCreateDTO addressCreateDto){


        //o ownerID nao pode ser nulo. Afinal, esse endereco vai pra alguma pessoa
        PersonMethodsInsanos.personIdIsNotNull(addressCreateDto.getOwnerId());
        
        //Verificamos se o "owner_id" existe. Esse endereço precisa ser de alguma pessoa
        PersonMethodsInsanos.personExists(addressCreateDto.getOwnerId(), this.pr);

        Person personCru = this.pr.findById(addressCreateDto.getOwnerId()).get();

        Address addressCru = new Address();
        addressCru.setStreet(addressCreateDto.getStreet());
        addressCru.setNumber(addressCreateDto.getNumber());
        
        //bilateralidade
        //O endereço recebe um "dono". 
        //A pessoa recebe mais um endereco
        addressCru.setOwner(personCru);
        personCru.getAddresses().add(addressCru);

        this.pr.save(personCru);  //salvamos no banco
        this.ar.save(addressCru); //salvamos no banco

        return new AddressFullDtoOwnerId(addressCru);

    }

    // ============ GET ============
    public List<AddressFullDtoOwnerId> getAllAddresses(Long ownerId){
        List<AddressFullDtoOwnerId> addressFullDtoList = new ArrayList<>();

        List<Address> listaAddressCrua = new ArrayList<>();

        //request params
        if(ownerId == null){
            listaAddressCrua = this.ar.findAll();
        }
        else{
            listaAddressCrua = this.ar.findAll(ownerId);
        }

        listaAddressCrua.stream()
            .forEach((addressCru) -> {
                addressFullDtoList.add(new AddressFullDtoOwnerId(addressCru));
            });

        return addressFullDtoList;
    }
}
