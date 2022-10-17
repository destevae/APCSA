import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class StringsArrays{
    public static void main(String[] args) throws FileNotFoundException{
        File top40 = new File("./Top_40s_September_22.txt");
        
        try{   
            Scanner myScanner = new Scanner(top40);
            
            int fileLines = 0;
            while(myScanner.hasNextLine()){
               myScanner.nextLine();
               fileLines++;
            }

            String [] songs = new String[40]; // makes empty string array for songs
            String [] artists = new String[40];
            myScanner = new Scanner(top40);
            int numSongs = 0;
            int numArtists = 0;

            for(int i = 0; i < fileLines; i++){ // puts all lines into the string array
                if(i%2 == 1){
                    songs[numSongs] = myScanner.nextLine();
                    numSongs++;
                }

                if(i%2 == 1){
                    artists[numArtists] = myScanner.nextLine();
                    numArtists++;
                }
            }

            int current_lowest; // index of lowest string we have found in the array so far
       
            for(int k=0; k<numArtists; k++){
                current_lowest = k;
    
                for(int j=k+1; j<artists.length; j++){
                    if(artists[current_lowest].compareTo(artists[j]) > 0){
                        current_lowest = j; // found a new lowest value
                    }
                }

                String temp = artists[k];
                artists[k] = artists[current_lowest];
                artists[current_lowest] = temp;
            }
 
            // loop thru artists array to print
            for(String line : artists){
                System.out.println(line);
            } 
        }

        catch(Exception e){
            e.printStackTrace();
        }
    }
}