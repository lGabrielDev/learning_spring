package br.com.lGabrielDev.pokemon.DTOs.abilities;

public class AbilityDto {
 
    //attributes
    private AbilityOnlyNameDto ability;

    //constructors
    public AbilityDto(){}

    //getters and setters
    public AbilityOnlyNameDto getAbility() {
        return ability;
    }

    public void setAbility(AbilityOnlyNameDto ability) {
        this.ability = ability;
    }
}
