import java.io.File;
import java.util.*;

public class ScannerPractice {
    public static void main(String[] args) throws Exception{
        File top40 = new File("./Top_40s_September_22.txt");

        try{   
            Scanner myScanner = new Scanner(top40);
            int fileLines = 0;

            while(myScanner.hasNextLine()) {
                myScanner.nextLine();
                fileLines++;
            }

            String [] lines = new String[fileLines]; // makes empty string array the length of the file length
            myScanner = new Scanner(top40);

            for(int i = 0; i<fileLines; i++){
                lines[i] = myScanner.nextLine();
            }

            // loop thru filled array to print
            for(String line : lines){
                System.out.println(line);
            }

        }

        catch(Exception e){
            System.out.println("failure...");
        }
        
    }
}
