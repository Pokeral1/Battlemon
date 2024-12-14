package Database;
//import java.util.*;
public class PokemonType {

    private final int typeNumber;
    private final String typeName;

    public static PokemonType normal = new PokemonType(1,"NORMAL");
    public static PokemonType fire = new PokemonType(2,"FIRE");
    public static PokemonType water = new PokemonType(3,"WATER");
    public static PokemonType grass = new PokemonType(4,"GRASS");
    public static PokemonType electric = new PokemonType(5,"ELECTRIC");
    public static PokemonType ice = new PokemonType(6,"ICE");
    public static PokemonType fighting = new PokemonType(7,"FIGHTING");
    public static PokemonType poison = new PokemonType(8,"POISON");
    public static PokemonType ground = new PokemonType(9,"GROUND");
    public static PokemonType flying = new PokemonType(10,"FLYING");
    public static PokemonType psychic = new PokemonType(11,"PSYCHIC");
    public static PokemonType bug = new PokemonType(12,"BUG");
    public static PokemonType rock = new PokemonType(13,"ROCK");
    public static PokemonType ghost = new PokemonType(14,"GHOST");
    public static PokemonType dragon = new PokemonType(15,"DRAGON");
    public static PokemonType dark = new PokemonType(16,"DARK");
    public static PokemonType steel = new PokemonType(17,"STEEL");
    public static PokemonType fairy = new PokemonType(18,"FAIRY");
    public static PokemonType notype = new PokemonType(0,"");

    PokemonType(int typeNumber,String typeName) {
        this.typeNumber = typeNumber;
        this.typeName = typeName;
    }

    public String getTypeName() {
        return this.typeName;
    }
    public int getTypeNumber(){
        return this.typeNumber;
    }

    // Method to get the integer value
    /* public int getTypeNumber() {
    return typeNumber;
    }*/
}

