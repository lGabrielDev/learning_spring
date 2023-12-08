package br.com.lGabrielDev.CepProject.models.person;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import br.com.lGabrielDev.CepProject.errors.exceptions.CepCannotBeNullException;
import br.com.lGabrielDev.CepProject.errors.exceptions.CepMustContainEightCharacters;
import br.com.lGabrielDev.CepProject.errors.exceptions.CepMustContainOnlyIntegers;
import br.com.lGabrielDev.CepProject.errors.exceptions.CepNotFoundException;
import br.com.lGabrielDev.CepProject.errors.exceptions.NameCannotBeNullException;
import br.com.lGabrielDev.CepProject.external_api.ExternalApiController;
import br.com.lGabrielDev.CepProject.models.address.Address;
import br.com.lGabrielDev.CepProject.models.address.AddressRepository;
import br.com.lGabrielDev.CepProject.models.address.MethodsLegais;
import br.com.lGabrielDev.CepProject.models.person.DTOs.PersonCreateDTO;

@Service
public class PersonService {

    //injected attributes
    @Autowired
    private ExternalApiController epc;

    @Autowired
    private AddressRepository ar;

    @Autowired
    private PersonRepository pr;



    // ===================================== CREATE =====================================
    public ResponseEntity<Person> createPerson(PersonCreateDTO pessoaEnviadaNoBody){

        //validacoes:
        //1- O campo "name" nao pode ser NULL
        //2- O campo "cep" nao pode ser NULL

        if(pessoaEnviadaNoBody.getName() == null){
            throw new NameCannotBeNullException("'Name' cannot be null");
        }
        if(pessoaEnviadaNoBody.getCep() == null){
            throw new CepCannotBeNullException("'CEP' cannot be null");
        }


        //validamos se o "cep" possui letras. O cep só estará correto, se tiver apenas numbers. Não pode ter letras.
        //basicamente, criamos um method para percorrer todas as letras de uma String.
        //tentamos transformar essa letra em um Integer.
        //Se retornar true, quer dizer que todas as letrar conseguiram ser convertidas para Integer.
        if(MethodsLegais.cepHasOnlyNumbers(pessoaEnviadaNoBody.getCep()) == false){
            throw new CepMustContainOnlyIntegers("CEP should have only numbers.");
        }


        //Um cep possui exatamente 8 dígitos. Obrigador o cliente a digitar os 8 digitos
        if(pessoaEnviadaNoBody.getCep().length() != 8){
            if(pessoaEnviadaNoBody.getCep().length() < 8){
                throw new CepMustContainEightCharacters("Cep has 8 characters");
            }
            throw new CepMustContainEightCharacters("Cep has only 8 characters");
        }


        //validacoes feitas, vamos verificar se o CEP existe lá na API externa
        Address addressDaApiExterna = new Address();


        //fazemos uma requisicao para a API externa verificar se existe de fato o CEP informado. Como validamos antes, fazendo com que o cliente digitasse apenas 8 characters, nao precisamos usar o try catch.
        addressDaApiExterna = epc.findCep(pessoaEnviadaNoBody.getCep());
        
        
        
        
        //Se o objeto enviado pela API externa for um objeto com attributes null, quer dizer que o CEP nao foi encontrado
        if(addressDaApiExterna.getBairro() == null){
            throw new CepNotFoundException(String.format("CEP '%s' doesn't exists", pessoaEnviadaNoBody.getCep()));
        }
        
        //se retornar um cep CORRETO, dale! Salvaremos no banco
        
        //Antes de salvar no banco, vamos remover o '-' do attribute cep. O attribute 'cep', do objeto JSON, vem acompanhado de '-'. Nao queremos isso. Queremos apenas numbers.
        addressDaApiExterna.setCep(addressDaApiExterna.getCep().replace("-", ""));
        
        
        //antes de tudo, precisamos salvar no banco o "endereco". Lembrando que ele nao pode ter vinculo nenhum com a outra entidade. Vamos fazer a bilateralidade depois. Vamos salvar o "address" primeiro, porque ele possui apenas attributes sem vinculo com outra entidade.
        this.ar.save(addressDaApiExterna);


        //Com o "address" no banco, agora sim podemos criar nosso "person" e salvar no banco
        Person p1 = new Person();
        p1.setName(pessoaEnviadaNoBody.getName());
      

        //bilateralidade
        p1.setEnderecoCompleto(addressDaApiExterna); //1 pessoa recebe um "endereco"
        addressDaApiExterna.setOwner(p1); //1 endereco recebe uma "pessoa"        

        
        //salvamos a "person" no banco, contendo o "address"
        this.pr.save(p1);

        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(p1);
    }


    // ===================================== READ ALL =====================================
    public ResponseEntity<List<Person>> getAllPersons(String uf){

        if(uf == null){
            return ResponseEntity.status(HttpStatus.OK).body(this.pr.findAll());
        }
        return ResponseEntity.status(HttpStatus.OK).body(this.pr.findAll(uf.toUpperCase())); // Assim, garantimos que o estado vai ser em "SP".
    }
    
}
