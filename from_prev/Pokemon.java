package from_prev;

import java.util.*;

public class Pokemon {
    public static Map <Integer,Pokemon> get_by_name=new HashMap<>();
    public final String name;
    public final int hp;
    public final int attack;
    public final int defense;
    public final int speed;
    public final int specialAttack;
    public final int specialDefense;
    public final PokemonType type1;
    public final PokemonType type2;
    public List<Object[]> moves;
    public final double height;
    public final double weight;
    public int pokemonID;
    //public List<String> types;
    // public String genderRatio;
    // public String growthRate;
    // public int baseExp;
    // public List<String> evYield;
    // public int catchRate;
    // public int happiness;
    // public String abilities;
    // public String hiddenAbilities;
    // public String color;
    // public String shape;
    // public String habitat;
    // public String category;
    // public String pokedexEntry;
    // public int generation;
    //public String evolution;
    //public int evolutionLevel;
    // public List<String> tutorMoves;
    // public List<String> eggMoves;
    // public List<String> eggGroups;
    // public int hatchSteps;    
    // Constructor
    public Pokemon( int pokemonID ,String name, int hp, int attack, int defense, 
    int specialAttack, int specialDefense, int speed,PokemonType type1,PokemonType type2,
    double height, double weight) {

        this.name = name;
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
        this.speed = speed;
        this.specialAttack = specialAttack;
        this.specialDefense = specialDefense;
        this.type1=type1;
        this.type2=type2;
        this.moves = Move.move_at_level(name);
        this.height = height;
        this.weight = weight;
        this.pokemonID = pokemonID;
        get_by_name.put(pokemonID,this);
        // this.genderRatio = genderRatio;
        // this.growthRate = growthRate;
        // this.baseExp = baseExp;
        // this.evYield = evYield;
        // this.catchRate = catchRate;
        // this.happiness = happiness;
        // this.abilities = abilities;
        // this.hiddenAbilities = hiddenAbilities;
        // this.tutorMoves = tutorMoves;
        // this.eggMoves = eggMoves;
        // this.eggGroups = eggGroups;
        // this.hatchSteps = hatchSteps;
        // this.color = color;
        // this.shape = shape;
        // this.habitat = habitat;
        // this.category = category;
        // this.pokedexEntry = pokedexEntry;
        // this.generation = generation;
        //this.evolution = evolution;
        //this.evolutionLevel = evolutionLevel;
    }

    public void printData(){
        System.out.println("Name: "+this.name);
        if(this.type2==PokemonType.notype)
        {
            System.out.println("Type: "+this.type1.getTypeName());

        }
        else
        {
            System.out.println("Type 1: "+this.type1.getTypeName());
            System.out.println("Type 2: "+this.type2.getTypeName());
        }
        System.out.println("HP: "+this.hp);
        System.out.println("Attack: "+this.attack);
        System.out.println("Defense: "+this.defense);
        System.out.println("Speed: "+this.speed);
        System.out.println("Special Attack: "+this.specialAttack);
        System.out.println("Special Defense: "+this.specialDefense);
        System.out.println("Height: "+this.height+"m");
        System.out.println("Weight: "+this.weight+"kg");
        System.out.println("Moves: ");

        for(Object[] m: this.moves){
            Move temp = (Move) m[1];
            System.out.println((Integer)m[0]+" "+temp.name);
        }
    }

    public void printIntro(){
        System.out.println("Name: "+this.name);
        if(this.type2==PokemonType.notype)
        {
            System.out.println("Type: "+this.type1.getTypeName());

        }
        else
        {
            System.out.println("Type: "+this.type1.getTypeName()+"/"+this.type2.getTypeName());
        }

    }
}

