import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import Battle_Engine.store_pokedat;
import Battle_Engine.RandomPokemonChooser;
import Database.Pokemon;
import Database.pokemons;
import Database.Move;
import Database.generate_battle_data;

public class start1 {
    static Scanner sc = new Scanner(System.in);
    static Map<String, List<Move>> pokemonMovesMap = new HashMap<>();
    static Map<String, String> pokemonChooserMap = new HashMap<>(); // Map to store who chose the Pokémon
    static int pokemonCounter = 0; // Counter to create unique identifiers

    public static void main(String args[]) {
        try {
            loadDatabase();

            int choice = getPokemonChoice();
            choosePokemonsAlternately(choice);
            store_pokedat.process_pokemon_levels();
            printAllMoves();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sc != null) {
                sc.close();
            }
        }
    }

    private static void loadDatabase() {
        // Load Pokémon data
        Database.Move.load_to_dict();
        pokemons.createPokemons();
    }

    private static int getPokemonChoice() {
        int choice;
        while (true) {
            System.out.println("Enter number of pokemons you want to choose (1-6):");
            choice = sc.nextInt();
            if (choice > 6) {
                System.out.println("You can only choose up to 6 pokemons. Please try again.");
            } else if (choice < 1) {
                System.out.println("You need to choose at least 1 pokemon. Please try again.");
            } else {
                break; // valid choice, exit the loop
            }
        }
        return choice;
    }

    private static void choosePokemonsAlternately(int choice) {
        for (int i = 0; i < choice; i++) {
            // User chooses a Pokémon by ID
            System.out.println("Enter the ID of Pokémon " + (i + 1) + ":");
            int pokemonId = sc.nextInt();
            int userLevel = (int) (Math.random() * 100) + 1; // Generate random level between 1 and 100

            Pokemon userPokemon = Pokemon.get_by_name.get(pokemonId);
            if (userPokemon != null) {
                store_pokedat.map_name_to_level(userPokemon, userLevel);
                System.out.println("User chose Pokémon: " + userPokemon.name + " at level " + userLevel);
                storeAndPrintMoves(userPokemon, userLevel, "User");
            } else {
                System.out.println("Pokémon not found. Please try again.");
                i--; // retry the current iteration
                continue;
            }

            // Computer chooses a Pokémon
            Pokemon computerPokemon = RandomPokemonChooser.chooseRandomPokemons(1)[0];
            int computerLevel = (int) (Math.random() * 100) + 1; // Generate random level between 1 and 100
            store_pokedat.map_name_to_level(computerPokemon, computerLevel);

            System.out.println("Computer chose Pokémon: " + computerPokemon.name + " at level " + computerLevel);
            storeAndPrintMoves(computerPokemon, computerLevel, "Computer");
        }
    }

    private static void storeAndPrintMoves(Pokemon pokemon, int level, String chooser) {
        // Generate moves for the Pokémon
        final List<Move> allocatedMoves = generate_battle_data.getMoves(pokemon, level);
        // Ensure only up to 4 moves are stored
        List<Move> limitedMoves = allocatedMoves.stream().limit(4).collect(Collectors.toList());
        // Map the moves to their indices
        Map<Integer, String> mapNumbersToMoves = IntStream.range(0, limitedMoves.size())
            .boxed()
            .collect(Collectors.toMap(
                    index -> index, // Key: the index of the element
                    index -> limitedMoves.get(index).name // Value: the element at that index
                ));

        // Create a unique identifier for the Pokémon
        String uniqueKey = pokemon.name + "_" + (++pokemonCounter);

        // Print the Pokémon's introduction, level, and stats
        pokemon.printIntro();
        System.out.println("Level: " + level);

        // Print the list of moves
        // for (Map.Entry<Integer, String> entry : mapNumbersToMoves.entrySet()) {
        // System.out.println((entry.getKey() + 1) + "." + entry.getValue());
        // }

        // Store the moves in the map
        pokemonMovesMap.put(uniqueKey, limitedMoves);
        // Store who chose the Pokémon
        pokemonChooserMap.put(uniqueKey, chooser);
    }

    private static void printAllMoves() {
        System.out.println("\n\n\n\n---------------------\n\n\n\n\nUser's Pokémon:");
        for (Map.Entry<String, List<Move>> entry : pokemonMovesMap.entrySet()) {
            String uniqueKey = entry.getKey();
            List<Move> moves = entry.getValue();
            String pokemonName = uniqueKey.split("_")[0];
            Pokemon pokemon = Pokemon.get_by_name.values().stream()
                .filter(p -> p.name.equals(pokemonName))
                .findFirst()
                .orElse(null);
            String chooser = pokemonChooserMap.get(uniqueKey);
            if ("User".equals(chooser)) {
                System.out.println( uniqueKey.split("_")[0] + " with ID " + uniqueKey + ":");
                pokemon.printTypeOnly();
                for (Move move : moves) {
                    System.out.println("- " + move.name);
                }
            }
        }

        System.out.println("\nComputer's Pokémon:");
        for (Map.Entry<String, List<Move>> entry : pokemonMovesMap.entrySet()) {
            String uniqueKey = entry.getKey();
            List<Move> moves = entry.getValue();
            String pokemonName = uniqueKey.split("_")[0];
            Pokemon pokemon = Pokemon.get_by_name.values().stream()
                .filter(p -> p.name.equals(pokemonName))
                .findFirst()
                .orElse(null);
            String chooser = pokemonChooserMap.get(uniqueKey);
            if ("Computer".equals(chooser)) {
                System.out.println( uniqueKey.split("_")[0] + " with ID " + uniqueKey + ":");
                pokemon.printTypeOnly();
                for (Move move : moves) {
                    System.out.println("- " + move.name);
                }
            }
        }
    }
}