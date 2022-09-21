public class Phyla {
    String phylaName;
    String phylaTrait;

    public Phyla(String nameP){
        phylaName = nameP;
        if(phylaName == "Chordata"){
            phylaTrait  = "has a notochord";
        }

        else if(phylaName == "Arthropoda"){
            phylaTrait = "has an exoskeleton";
        }

        else if(phylaName == "Annelida"){
            phylaTrait = "segmented worm";
        }

        else if(phylaName == "Nematoda"){
            phylaTrait = "round worm";
        }

        else if(phylaName == "Platyhelminthes"){
            phylaTrait = "flat worm";
        }

        else if(phylaName == "Porifera"){
            phylaTrait = "sponge";
        }

        else if(phylaName == "Echinodermata"){
            phylaTrait = "star-like appearance";
        }

        else if(phylaName == "Cnidaria"){
            phylaTrait = "has radial symmetry";
        }

        else if(phylaName == "Mollusca"){
            phylaTrait = "body is covered by a calcareous shell";
        }

        else{
            System.out.println("Please enter in a valid phyla name");
        }
    }

    void PrintTrait(){ // add this to all
        System.out.println("phyla: " + phylaName);
        System.out.println("     trait: " + phylaTrait);
    }
    
}
