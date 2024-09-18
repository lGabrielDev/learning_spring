package Classes.enums.mmoExample;

public enum FightClass{
    //CONSTANTS
    WARRIOR("Warrior", "castelo da luz", 5, 10),
    GUNNER("Gunner", "Piltover", 9, 4),
    NINJA("Ninja", "floresta das sombras", 7, 5);

    //attributes
    private final String name;
    private final String region;
    private final Integer strength;
    private final Integer defense;

    //constructors
    private FightClass(String name, String region, Integer strength, Integer defense){
        this.name = name;
        this.region = region;
        this.strength = strength;
        this.defense = defense;
    }
    
    //getters --> Apenas os getters, porque na teoria esses valores 'final' não podem mudar
    public String getName() {
        return name;
    }

    public String getRegion() {
        return region;
    }

    public Integer getStrength() {
        return strength;
    }

    public Integer getDefense() {
        return defense;
    }

    

    //toString()
    @Override
    public String toString() {
        return
            String.format(
                "Name: %s\n" +
                "Region %s\n" +
                "Strength name: %d\n" +
                "Defense: %d\n", this.name, this.region, this.strength, this.defense
            );
    }
    
}