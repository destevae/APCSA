import java.util.*;

public class Phyla {
    String phylaN;
    String phylaTrait;

    Subphyla subphylaOne;
    Subphyla subphylaTwo;

    public Phyla(String phylaName){
        phylaN = phylaName;
        if(phylaN == "Chordata"){
            subphylaOne = new Subphyla("Vertebrata");
            subphylaTwo = null;
        }

        else if(phylaN == "Anthropoda"){
            subphylaOne = new Subphyla("Chelicerates");
            subphylaTwo = new Subphyla("Cursaceans");
        }
    }


    public String printPhyla(){
        Hashtable<String, String> phylaDict = new Hashtable<String, String>(); // source: https://www.educative.io/answers/how-to-create-a-dictionary-in-java
        phylaDict.put("Annelida", "segmented worm");
        phylaDict.put("Nematoda", "round worm");
        phylaDict.put("Arthropoda", "has an exoskeleton");
        phylaDict.put("Platyhelminthes", "flat worm");

    }
    
}
