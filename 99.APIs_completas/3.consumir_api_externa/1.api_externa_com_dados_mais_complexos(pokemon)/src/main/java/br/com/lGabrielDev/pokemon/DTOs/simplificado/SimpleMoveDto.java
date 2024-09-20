package br.com.lGabrielDev.pokemon.DTOs.simplificado;

public class SimpleMoveDto {

    //attributes
    private Long moveId;
    private String name;

    //constructors
    public SimpleMoveDto(){}

    //getters and setters
    public Long getMoveId() {
        return moveId;
    }
    
    public void setMoveId(Long moveId) {
        this.moveId = moveId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
