package br.com.lGabrielDev.manyToMany.methodsLegais;


import br.com.lGabrielDev.manyToMany.enums.PokemonPower;

public abstract class MethodsLegais {

    
    //method para verificar se o "power", informado na hora de criar o pokemon, existe. 
    public static Boolean powerIsCorrect(String powerInformado){
        
        //array/lista contendo todos os "pokemon powers", em String
        String[] listaDePowers = {
            PokemonPower.ELECTRICITY.getName(),
            PokemonPower.FIRE.getName(),
            PokemonPower.WATER.getName(),
            PokemonPower.GRASS.getName()
        };

        //verificamos se o "power" informado corresponde a algum desses powers
        for(String i : listaDePowers){
            if(powerInformado.toLowerCase().equals(i.toLowerCase())){
                return true;
            }
        }
        return false;
    }
    
}
