package br.com.lGabrielDev.praticandinho.person;

import org.springframework.stereotype.Service;
import br.com.lGabrielDev.praticandinho.address.Address;
import br.com.lGabrielDev.praticandinho.address.AddressRepository;
import br.com.lGabrielDev.praticandinho.external.ViaCepController;
import br.com.lGabrielDev.praticandinho.person.DTOs.PersonCreateDto;
import br.com.lGabrielDev.praticandinho.person.DTOs.PersonFullDto;
import br.com.lGabrielDev.praticandinho.person.validations.PersonValidations;

@Service
public class PersonService {

    //attributes
    private ViaCepController viaCepController;
    private AddressRepository ar;
    private PersonRepository pr;
    

    //constructors
    public PersonService(ViaCepController viaCepController, AddressRepository ar, PersonRepository pr){
        this.viaCepController = viaCepController;
        this.ar = ar;
        this.pr = pr;
    }

    // ====================== POST ======================
    public PersonFullDto createPerson(PersonCreateDto personCreateDto){

        //validations...
        PersonValidations.nameAndCepAreNotNull(personCreateDto.getName(), personCreateDto.getCep());
        PersonValidations.cepLengthIs8(personCreateDto.getCep());
        PersonValidations.cepOnlyHasNumbers(personCreateDto.getCep());

        //verificamos se o cep existe. Pra isso, só consultar o campo "bairro", ou qualquer outro campo, e verificar se ele não é null
        PersonValidations.cepExiste(personCreateDto.getCep(), this.viaCepController);

        //setamos o endereco
        Address addressCru = this.viaCepController.getAddressByCep(personCreateDto.getCep()); //esse "Address" recebe o objeto da API externa
        addressCru.setNumber(personCreateDto.getNumeroCasa()); //setamos o numero da casa
        addressCru.setCep(PersonValidations.removerTraco(addressCru.getCep())); //Antes de salvar no banco, vamos remover o '-' do attribute cep. O attribute 'cep', do objeto JSON, vem acompanhado de '-'. Nao queremos isso. Queremos apenas numbers.

        //antes de tudo, precisamos salvar no banco o "endereco". Lembrando que ele nao pode ter vinculo nenhum com a outra entidade. Vamos fazer a bilateralidade depois. Vamos salvar o "address" primeiro, porque ele possui apenas attributes sem vinculo com outra entidade.
        this.ar.save(addressCru);

        //Com o "address" no banco, agora sim podemos criar nosso "person" e salvar no banco
        Person personCru = new Person(personCreateDto, addressCru);

        //bilateralidade
        addressCru.setOwner(personCru);
        personCru.setFullAddress(addressCru);

        //salvamos a "person" no banco, contendo o "address"
        this.pr.save(personCru);
        return new PersonFullDto(personCru);
    }


    // ====================== GET ======================
    public Address getAddressByCep(String cep){
        return this.viaCepController.getAddressByCep(cep);
    }
}