package br.com.lGabrielDev.manyToOnePraticando.address.methodsInsanos;

import java.util.HashSet;
import java.util.Set;

import br.com.lGabrielDev.manyToOnePraticando.address.Address;
import br.com.lGabrielDev.manyToOnePraticando.address.DTOs.AddressFullDTOWithoutPerson;

public abstract class AddressMethodsInsanos {
    
    //converter uma lista de "Address" para uma lista de "AddressFullDTOWithoutPerson"
    public static Set<AddressFullDTOWithoutPerson> converterLista(Set<Address> listaCrua){
        
        Set<AddressFullDTOWithoutPerson> listaDto = new HashSet<>();

        listaCrua.stream()
            .forEach((addressCru) ->{
                listaDto.add(new AddressFullDTOWithoutPerson(addressCru));
            });

        return listaDto;
    }
}
