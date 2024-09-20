package br.com.lGabrielDev.pokemon.DTOs.moves;

public class MoveDto {
    
    //attributes
    private MoveOnlyNameDto move;

    //constructors
    public MoveDto(){}

    //getters and setters
    public MoveOnlyNameDto getMove() {
        return move;
    }

    public void setMove(MoveOnlyNameDto move) {
        this.move = move;
    }
}
