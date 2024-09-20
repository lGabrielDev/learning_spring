package br.com.lGabrielDev.pokemon.DTOs.simplificado;

public class SimpleAbilityDto {
    
    //attributes
    private Long abilityId;
    private String name;
    
    //constructors
    public SimpleAbilityDto(){}
    
    //getters and setters
    public Long getAbilityId() {
        return abilityId;
    }
    public void setAbilityId(Long abilityId) {
        this.abilityId = abilityId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
