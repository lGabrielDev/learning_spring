package br.com.lGabrielDev.manyToMany.models.Treinador.DTOs;

//usaremos essa Class para criar um "Treinador", passnado apenas o attribute "name"
public class TreinadorDTOCreateOnlyName {
    
    //attributes
    private String name;


    //constructors
    public TreinadorDTOCreateOnlyName(){}
    
    public TreinadorDTOCreateOnlyName(String name){
        this.name = name;
    }



    //getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    //toString(){}
    @Override
    public String toString(){
        return
            String.format("Name: %s", this.name);
    }
}
