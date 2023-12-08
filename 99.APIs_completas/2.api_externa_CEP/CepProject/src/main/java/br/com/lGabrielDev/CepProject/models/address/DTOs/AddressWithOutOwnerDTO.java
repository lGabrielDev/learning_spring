package br.com.lGabrielDev.CepProject.models.address.DTOs;
import br.com.lGabrielDev.CepProject.models.address.Address;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

//DTOzinho sem o attribute "owner"
public class AddressWithOutOwnerDTO {
    

    //attributes
    private Long id;
    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
    private String ddd;


    //constructors --> Criados pelo lombok
    public AddressWithOutOwnerDTO(Address enderecoApiExterna){
        this.cep = enderecoApiExterna.getCep();

        this.logradouro = enderecoApiExterna.getLogradouro();
        this.complemento = enderecoApiExterna.getComplemento();
        this.bairro = enderecoApiExterna.getBairro();
        this.localidade = enderecoApiExterna.getLocalidade();
        this.uf = enderecoApiExterna.getUf();
        this.ddd = enderecoApiExterna.getDdd();
    }

    //getters and setters --> Criados pelo lombok


    //toString() --> Usaremos para debugar
    @Override
    public String toString(){
        return
            String.format(
                "#ID: %d" +
                "cep: %s" +
                "logradouro: %s" +
                "complemento: %s" +
                "bairro: %s" +
                "localidade: %s" +
                "uf: %s" +
                "ddd: %s", id, cep, logradouro, bairro, localidade, uf, ddd
            );
    }



    //converter um "Address" para um "AddressWithOutOwnerDTO"
    public void converterAddressCru(Address addressCru){
        this.logradouro = addressCru.getLogradouro();
        this.complemento = addressCru.getComplemento();
        this.bairro = addressCru.getBairro();
        this.localidade = addressCru.getLocalidade();
        this.uf = addressCru.getUf();
        this.ddd = addressCru.getDdd();
    }
}
