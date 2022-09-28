import java.io.File;
import java.util.*;
import java.io.FileNotFoundException;

public class ScannerPractice {
    public static void main(String[] args) throws FileNotFoundException{
        File top40 = new File("./Top_40s_September_22.txt");

        try{
            Scanner myScanner = new Scanner(top40);
        
            String line = myScanner.nextLine();
            System.out.println(line);

            while(myScanner.hasNextLine()) {
                line = myScanner.nextLine();
                System.out.println(line);
            }
        }

        catch(Exception e){
            System.out.println("failure...");
        }
        
    }
}
