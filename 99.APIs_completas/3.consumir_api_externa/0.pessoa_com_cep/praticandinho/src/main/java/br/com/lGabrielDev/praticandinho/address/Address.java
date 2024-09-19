package br.com.lGabrielDev.praticandinho.address;

import br.com.lGabrielDev.praticandinho.person.Person;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_address")
public class Address {
    
    //attributes
    @Id // PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increment
    @Column(name = "id") //setamos as info dessa column (constraints etc..)
    private Long id;
    
    private String cep;
    private String logradouro;
    private Integer number;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;

    @OneToOne(mappedBy = "fullAddress") //Se lá nós criamos a relação, aqui nós mapeamos/confirmamos essa relação.
    private Person owner;
    
    //constructors
    public Address(){}

    public Long getId() {
        return id;
    }

    //getters and setters
    public void setId(Long id) {
        this.id = id;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    //toString()
    @Override
    public String toString() {
        return "Address [id=" + id + ", cep=" + cep + ", logradouro=" + logradouro + ", number=" + number
                + ", complemento=" + complemento + ", bairro=" + bairro + ", localidade=" + localidade + ", uf=" + uf
                + ", owner=" + owner + "]";
    } 
}
