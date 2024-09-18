package Classes.enums.mmoExample;

public class Player {

    //attributes
    private String name;
    private String email;
    private FightClass fightClass;

    //constructors
    public Player(String name, String email, FightClass fightClass){
        this.name = name;
        this.email = email;
        this.fightClass = fightClass;
    }

    //getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public FightClass getFightClass() {
        return fightClass;
    }

    public void setFightClass(FightClass fightClass) {
        this.fightClass = fightClass;
    }

    //toString()
    @Override
    public String toString() {
        return
            String.format(
                "Name: %s\n"+
                "Email: %s\n"+
                "Class: %s\n", this.name, this.email, this.getFightClass().getName()
            );
    }
}