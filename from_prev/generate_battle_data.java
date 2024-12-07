package from_prev;

import java.util.*;

public class generate_battle_data {
    static final int NO_OF_MOVES = 4;
public static Random random = new Random();
    public static int level() {
        // Create a Random object
        

        // Generate a random number between 1 and 100 (inclusive)
        int randomNumber = random.nextInt(100) + 1; // nextInt(100) gives 0 to 99, so we add 1 to make it 1 to 100
        return randomNumber;
        // Print the random number
        // System.out.println(randomNumber);
    }

    public static List<Move> getMoves(Pokemon p, int level) {
        List<Move> generatedMoves = new ArrayList<>();
        int i=0;
        // Step 2: Get an Iterator for the entry set of the map

        // Step 3: Iterate over the HashMap using the Iterator
        for(Object[] m : p.moves){
            if((Integer)m[0]<=level)
            generatedMoves.add((Move)m[1]);
        }
       

        // Copy the first 4 elements from the shuffled array
        List<Move> randomMoves = new ArrayList<>();
       Collections.shuffle(generatedMoves, random);
       i=0;
       for(Move give:generatedMoves)
       {
       randomMoves.add(give);
       i++;
       if(i>=4)
       break;
        // Display the original and new arrays
        //System.out.print("Shuffled Array: ");
        
       
    }
    return randomMoves;
}
}
