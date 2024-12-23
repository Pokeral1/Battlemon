package Battle_Engine;

import java.util.HashMap;
import java.util.Map;
import Database.Pokemon;

public class store_pokedat {
    private static Map<Pokemon, Integer> pokemonLevelMap = new HashMap<>();

    public static void map_name_to_level(Pokemon p, int level) {
        pokemonLevelMap.put(p, level);
    }

    public static void process_pokemon_levels() {
        // Call StatsCalc.load_data with each key-value pair
        for (Map.Entry<Pokemon, Integer> entry : pokemonLevelMap.entrySet()) {
            StatsCalc.load_data(entry.getKey(), entry.getValue());
        }
        // Clear the map for the next run
        pokemonLevelMap.clear();
    }

    public static Integer get_pokemon_level(Pokemon p) {
        return pokemonLevelMap.get(p);
    }
}