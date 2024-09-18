package br.com.lGabrielDev.projeto_relacionamento.pokemon.validations;

public abstract class PokemonPowerValidations {
    
    
    //check pokemon name is not null
    public static Boolean pokemonPowerIsNotNull(String power){
        if(power == null || power.isBlank()){
            throw new RuntimeException("Pokemon 'power' is null or has only white spaces");
        }
        return true;
    }

    //check if pokemon power exists
    public static Boolean pokemonPowerExists(String pokemonPower){
        switch(pokemonPower){
            case "fire":
            case "water":
            case "grass":
                return true;
            default:
                throw new RuntimeException("Pokemon 'power' is wrong. Type ['fire', 'water', grass]");
        }
    }
}
