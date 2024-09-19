package br.com.lGabrielDev.praticandinho.address.converterAddress;

import br.com.lGabrielDev.praticandinho.address.Address;
import br.com.lGabrielDev.praticandinho.address.DTOs.AddressWithoutPerson;

public abstract class ConverterAddress {
    
    //converter "Address" to "AddressWithoutPerson"
    public static AddressWithoutPerson converter(Address addressCru){
        return new AddressWithoutPerson(addressCru);
    }
}
