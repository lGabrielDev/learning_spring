package br.com.lGabrielDev.projeto_relacionamento.treinador.DTOs;

public class TreinadorCreateDTO {
    
    //attributes
    private String name;

    //constructors
    public TreinadorCreateDTO(){}


    public TreinadorCreateDTO(String name){
        this.name = name;
    }
    
    //getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
