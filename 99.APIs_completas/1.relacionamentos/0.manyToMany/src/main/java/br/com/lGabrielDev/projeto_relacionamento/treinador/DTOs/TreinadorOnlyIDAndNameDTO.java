package br.com.lGabrielDev.projeto_relacionamento.treinador.DTOs;

import java.util.HashSet;
import java.util.Set;
import br.com.lGabrielDev.projeto_relacionamento.treinador.Treinador;

public class TreinadorOnlyIDAndNameDTO {
    //attributes
    Long id;
    String name;

    //constructors
    public TreinadorOnlyIDAndNameDTO(){}

    public TreinadorOnlyIDAndNameDTO(Treinador treinadorCru){
        this.id = treinadorCru.getId();
        this.name = treinadorCru.getName();
    }

    //getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //transformar lista de treinadores CRUS para uma lista de TreinadorOnlyIDAndNameDTO. 
    public static Set<TreinadorOnlyIDAndNameDTO> converterListaTreinadores(Set<Treinador> treinadoresCrus){
        Set<TreinadorOnlyIDAndNameDTO> treinadoresFullDtos = new HashSet<>();

        treinadoresCrus.stream()
            .forEach((treinador) -> {
                TreinadorOnlyIDAndNameDTO treinadorDto = new TreinadorOnlyIDAndNameDTO(treinador);
                treinadoresFullDtos.add(treinadorDto);
            });
        return treinadoresFullDtos;
    }
    
}
