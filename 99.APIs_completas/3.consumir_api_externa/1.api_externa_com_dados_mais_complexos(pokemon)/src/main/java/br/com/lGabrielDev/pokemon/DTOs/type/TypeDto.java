package br.com.lGabrielDev.pokemon.DTOs.type;

public class TypeDto {
    
    //attributes
    private TypeOnlyNameDto type;

    //constructors
    public TypeDto(){}

    //constructors
    public TypeOnlyNameDto getType() {
        return type;
    }

    public void setType(TypeOnlyNameDto type) {
        this.type = type;
    }
}
