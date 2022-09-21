public class Subphyla extends Phyla{
    
    String subphylaName;
    String subphylaTrait;


    public Subphyla(String phylaNameP, String subphylaNameP){
        super(phylaNameP);
        subphylaName = subphylaNameP;

        // assigns traits to all the subphylas

        if(subphylaName == "Chelicerates"){
            subphylaTrait = "no antennae";
        }

        else if(subphylaName == "Crustaceans"){
            subphylaTrait = "two pairs of antennae";
        }

        else if(subphylaName == "Labiatae"){
            subphylaTrait = "centipedes or milipedes - not leaves!";
        }

        else if(subphylaName == "Vertebrata"){
            subphylaTrait = "has a backbone and skull";
        }

        else{
            System.out.println("Please enter in a valid subphyla name");
        }
    }

    void PrintTrait(){ // add this to all
        System.out.println("Subphyla: " + subphylaName);
        System.out.println("     trait: " + subphylaTrait);
        super.PrintTrait(); 
    }
}
