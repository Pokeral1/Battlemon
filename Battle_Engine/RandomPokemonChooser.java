package Battle_Engine;

import Database.Pokemon;

public class RandomPokemonChooser {
    public static Pokemon[] chooseRandomPokemons(int n) {
        Pokemon[] pokemons = new Pokemon[n];
        int index = 0;

        while (index < n) {
            int chosenId = (int) (Math.random() * Pokemon.TOTAL_POKEMONS) + 1;
            Pokemon p = Pokemon.get_by_name.get(chosenId);
            if (p != null) {
                pokemons[index] = p;
                index++;
            }
        }
        return pokemons;
    }
}