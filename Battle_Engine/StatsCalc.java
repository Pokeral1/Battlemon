package Battle_Engine;

import from_prev.*;
import from_prev.Move;
import from_prev.Pokemon;
import from_prev.generate_battle_data;
import from_prev.pokemons;

public class StatsCalc {
    public static void load_data(Pokemon p, int level) {
        
        int LEVEL = level;
        int HP = calc_hp(p.hp,LEVEL);
        int SPATK = calc(p.specialAttack,LEVEL);
        int SPDEF = calc(p.specialDefense,LEVEL);
        int ATK = calc(p.attack,LEVEL);
        int DEF = calc(p.defense,LEVEL);
        int SPEED = calc(p.speed,LEVEL);
        int arr[] = new int[6];
        arr[0] = HP;
        arr[1] = ATK;
        arr[2] = DEF;
        arr[3] = SPATK;
        arr[4] = SPDEF;
        arr[5] = SPEED;
        for (int i = 0; i < arr.length; i++)
            System.out.println(arr[i]);

    }

    static int calc_hp(int hp,int LEVEL) {
        int HP = (2 * hp * LEVEL / 100) + LEVEL + 10;
        return HP;
    }

    static int calc(int stat,int LEVEL) {
        int stat_f = (2 * stat * LEVEL / 100) + 5;
        return stat_f;
    }

}