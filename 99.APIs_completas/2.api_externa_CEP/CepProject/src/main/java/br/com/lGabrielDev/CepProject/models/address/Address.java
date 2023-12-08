package br.com.lGabrielDev.CepProject.models.address;
import com.fasterxml.jackson.annotation.JsonIgnore;
import br.com.lGabrielDev.CepProject.models.person.Person;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter


@Entity
@Table(name = "tb_address")
public class Address {
    
    //attributes

    @Id //PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increment
    @Column(name = "id")
    private Long id;


    @Column(name = "cep") //cep NÃO PRECISA SER unique. Pessoas podem morar no mesmo cep
    private String cep;


    @Column(name = "logradouro")
    private String logradouro;


    @Column(name = "complemento")
    private String complemento;


    @Column(name = "bairro")
    private String bairro;


    @Column(name = "localidade")
    private String localidade;


    @Column(name = "uf")
    private String uf;

    @Column(name = "ddd")
    private String ddd;


    @JsonIgnore //cancelar o loop infinito de relacionamento
    @OneToOne(mappedBy = "enderecoCompleto", fetch = FetchType.LAZY) //confirmamos a relacao.
    private Person owner;



    
    //constructors --> Criados com lombok


    //getters and setters --> Criados com lombok


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
                "ddd: %s" +
                "ownerID: %d" +
                "owner: %s", id, cep, logradouro, bairro, localidade, uf, ddd, owner.getId(), owner.getName()
            );
    }
}
