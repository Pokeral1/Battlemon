import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class PokemonDataParser {
    public static void main(String[] args) {
        // Specify the path to the file
        int count=0;
        String filePath = "G:\\DSJCHBSJH\\from_prev\\pokemons.java";
        try{
            File file = new File(filePath);
            Scanner sc = new Scanner(file);
            for(int i = 0 ;i<4;i++)sc.nextLine();
            while(sc.hasNextLine()){
                count++;
                String line = sc.nextLine().trim();
                int eqi = line.indexOf('=');
                System.out.print("Move.pokemon_move_dict.put(");
                int start=0,last=0;
                for(int i = 0 ; i<200;i++){
                    if(line.charAt(i)=='"'){
                        if(start==0){
                            start=i;
                        }
                        else {
                            last=i+1;
                            break;
                        }
                    }
                }
                System.out.print(line.substring(start,last));
                System.out.print(",");
                if(count<=100) System.out.print("Move_01.");
                else if(count<=200) System.out.print("Move_02.");
                else  if(count<=300) System.out.print("Move_03.");
                else if(count<=400) System.out.print("Move_04.");
                else if(count<=500) System.out.print("Move_05.");
                else if(count<=600) System.out.print("Move_06.");
                else if(count<=700) System.out.print("Move_07.");
                else System.out.print("Move_08.");
                System.out.print(line.substring(8,eqi).trim());
                System.out.println(");");
                if(count==898)break;
                sc.close();
            }
        }catch(FileNotFoundException e){}
        
    }
}
