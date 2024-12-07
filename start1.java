import java.util.*;
//import from_prev.*;
import from_prev.Move;
import from_prev.Pokemon;
import from_prev.generate_battle_data;
import from_prev.pokemons;
import java.util.stream.IntStream;
import java.util.stream.Collectors;
import Battle_Engine.*;
public class start1 {
    public static void main(String args[]) {
        try{
            loadDatabase();

            Scanner sc = new Scanner(System.in);
            int choosenIds[] = new int[6];

            System.out.println("Enter ID of your pokemon(s)");

            choosenIds[0] = sc.nextInt();

            if(choosenIds[0]!=0)
            {

                Pokemon p = Pokemon.get_by_name.get(choosenIds[0]);
                int level = generate_battle_data.level();

                final List<Move> allocatedMoves = generate_battle_data.getMoves(p,level);
                Map<Integer, String> map_numbers_to_moves = IntStream.range(0, allocatedMoves.size())
                    .boxed()
                    .collect(Collectors.toMap(
                            index -> index, // Key: the index of the element
                            index -> allocatedMoves.get(index).name // Value: the element at that
                                    // index
                        ));
                p.printIntro();
                System.out.println("Level: "+level);
                for (Map.Entry<Integer, String> entry : map_numbers_to_moves.entrySet()) {
                    System.out.println((entry.getKey() + 1) + "." + entry.getValue());
                }
                StatsCalc.load_data(p,level);

            }
            else
            {
                System.out.println("Exiting....");
                System.exit(0);
            }
            sc.close();
        }
        catch(Exception e)
        {
            String restart[]={};
            System.out.println("Enter a valid pokemon ID or write 0 to quit");
            main(restart);
        }

    }

    static void loadDatabase(){
        Move.load_to_dict();
        pokemons.createPokemons();
    }

}