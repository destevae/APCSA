public class AnimalClass extends Subphyla{

    String className;
    String classTrait;
    

    AnimalClass(String classNameP, String phylaNameP, String subphylaNameP){
        super(phylaNameP, subphylaNameP);
        className = classNameP;

        if(className == "Horseshoe Crabs"){
            classTrait = "has a round and hard and brownish-green exoskeleton";
        }

        else if(className == "Spiders"){
            classTrait = "has 8 legs";
        }

        else if(className == "Scorpions"){
            classTrait = "has 8 legs and a venom-injecting tail";
        }

        else if(className == "Crabs"){
            classTrait = "has 10 legs";
        }

        else if(className == "Lobsters"){
            classTrait = "has compound eyes on movable stalks";
        }

        else if(className == "Shrimp"){
            classTrait = "semitransparent body and flexible abdomen";
        }

        else if(className == "Barnacles"){
            classTrait = "exoskeleton made up of chitin and calcium";
        }

        else if(className == "Insects"){
            classTrait = "has a 3 part body";
        }

        else if(className == "Centipedes"){
            classTrait = "has 12-100 body segments";
        }

        else if(className == "Millipedes"){
            classTrait = "has up to 200 legs";
        }

        else if(className == "Starfish"){
            classTrait = "can regenerate their own arms";
        }

        else if(className == "Sea Urchins"){
            classTrait = "have pentaradial symmetry";
        }

        else if(className == "Sand Dollars"){
            classTrait = "have tube feet and spines";
        }

        else if(className == "Jellyfish"){
            classTrait = "has an umbrella, oral arms, and tentacles";
        }

        else if(className == "Coral"){
            classTrait = "can be in many colors";
        }

        else if(className == "Anemones"){
            classTrait = "soft, two tissue layer body";
        }

        else if(className == "Oysters"){
            classTrait = "shells with an oval or pear shape";
        }

        else if(className == "Clams"){
            classTrait = "bivales with equal shells";
        }

        else if(className == "Snails"){
            classTrait = "asymmetric bodies";
        }

        else if(className == "Slugs"){
            classTrait = "thick at the center";
        }

        else if(className == "Periwinkles"){
            classTrait = " ";
        }

        else if(className == "Squid"){
            classTrait = " ";
        }

        else if(className == "Octupi"){
            classTrait = " ";
        }

        else if(className == "Cartilagenous Fish"){
            classTrait = "paired fins and nostrils";
        }

        else{
            System.out.println("Please enter in a valid class name");
        }
    }
    
    void PrintTrait(){ // add this to all
        System.out.println("Class: " + className);
        System.out.println("     trait: " + classTrait);
        super.PrintTrait(); 
    }

}
