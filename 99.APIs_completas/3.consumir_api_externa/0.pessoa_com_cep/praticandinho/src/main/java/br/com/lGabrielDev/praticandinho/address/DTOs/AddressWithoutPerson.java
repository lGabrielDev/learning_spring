package br.com.lGabrielDev.praticandinho.address.DTOs;

import br.com.lGabrielDev.praticandinho.address.Address;

public class AddressWithoutPerson {
    
    //attributes
    private Long id;
    private String cep;
    private String logradouro;
    private Integer numeroCasa;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;

    //constructors
    public AddressWithoutPerson(){}

    public AddressWithoutPerson(Address addressCru){
        this.id = addressCru.getId();
        this.cep = addressCru.getCep();
        this.logradouro = addressCru.getLogradouro();
        this.numeroCasa = addressCru.getNumber();
        this.complemento = addressCru.getComplemento();
        this.bairro = addressCru.getBairro();
        this.localidade = addressCru.getLocalidade();
        this.uf = addressCru.getUf();
    }

    //getters and setters
    public Long getId() {
        return id;
    }

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

    public Integer getNumeroCasa() {
        return numeroCasa;
    }

    public void setSumeroCasa(Integer numeroCasa) {
        this.numeroCasa = numeroCasa;
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


    //toString()
    @Override
    public String toString() {
        return "AddressWithoutPerson [id=" + id + ", cep=" + cep + ", logradouro=" + logradouro + ", number=" + numeroCasa
                + ", complemento=" + complemento + ", bairro=" + bairro + ", localidade=" + localidade + ", uf=" + uf
                + "]";
    }
}
