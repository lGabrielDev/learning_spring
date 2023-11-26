package br.com.lGabrielDev.manyToMany.models.Treinador.DTOs;
import java.util.ArrayList;
import java.util.List;
import br.com.lGabrielDev.manyToMany.models.Treinador.Treinador;

public class TreinadorDTOQuantidadePokemons {
    //attributes
    private Long id;
    private String name;
    private Integer quantidadePokemons;



    //constructors
    public TreinadorDTOQuantidadePokemons(){
        quantidadePokemons = 0; //inicializamos para nao ter problemas depois
    }

    public TreinadorDTOQuantidadePokemons(Treinador t1) {
        this.id = t1.getId();
        this.name = t1.getName();
        this.quantidadePokemons = t1.getPokemons().size();
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

    public Integer getQuantidadePokemons() {
        return quantidadePokemons;
    }

    public void setQuantidadePokemons(Integer quantidadePokemons) {
        this.quantidadePokemons = quantidadePokemons;
    }



    //converter lista de treinadores
    public List<TreinadorDTOQuantidadePokemons> converterTreinadores(List<Treinador> treinadoresCrus){
        
        List<TreinadorDTOQuantidadePokemons> treinadoresConvertidos = new ArrayList<>();

        for(Treinador i : treinadoresCrus){
            TreinadorDTOQuantidadePokemons t1 = new TreinadorDTOQuantidadePokemons(i);
            treinadoresConvertidos.add(t1);
        }

        return treinadoresConvertidos;
    }

}
