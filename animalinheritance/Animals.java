public class Animals extends Family{
    String name;
    String uniqueTrait;


    public Animals(String nameP, String traitP, String famNameP, String classNameP, String phylaNameP, String subphylaNameP){
        super(famNameP, classNameP, phylaNameP, subphylaNameP);
        name = nameP;
        uniqueTrait = traitP;
    
        // assigns traits to all the animals
        if(name == "hammerhead shark"){
            uniqueTrait = "flat head shark";
        }

        if(name == "monarch butterfly"){
            uniqueTrait = "a monarch";
        }
    }

        void PrintTrait(){ // add this to all
            System.out.println("Animal: " + name);
            System.out.println("     trait: " + uniqueTrait);
            super.PrintTrait(); 
        }
    
}
