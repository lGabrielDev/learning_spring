package br.com.lGabrielDev.manyToMany.models.Pokemon.DTOs;

//usaremos esse DTO para enviar um pokemon somente com os attributes:
// - "name"
// - "power"
public class PokemonDTOCreate {

    //attributes
    private String name;
    private String power; //pra ser mais fácil do usuario informar. Assim, ele nao precisar informar o power em UPPERCASE LETTERS

    //constructors
    public PokemonDTOCreate(String name, String power){
        this.name = name;
        this.power = power;
    }
    



    //getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    
    //toString()
    @Override
    public String toString(){
        return
            String.format(
                "#Name: %s\n" + 
                "Power: %s\n", this.name,this.power  //NAO MISTURE AS COISAS. SE QUISER RETORNAR A LISTA DE POKEMONS DESSE TREINADOR, CRIE UM METHOD PARA ISSO. Só vamos mostrar os attributes que NÃO TEM RELAÇAO com outras entidades.
            );
    }



}
