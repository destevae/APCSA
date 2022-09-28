public class Family extends AnimalClass {
    String familyName;
    String familyTrait;
    public Family(String famNameP, String classNameP, String phylaNameP, String subphylaNameP){
        super(classNameP, phylaNameP, subphylaNameP); // refering to the constructor of Animal Class
        familyName = famNameP;

        // assigns traits to all the families of animals
        if(familyName == "shark"){
            familyTrait = "very scary animals";
        }
        else if(familyName == "butterfly"){
            familyTrait = "very pretty";
        }

        else{
            System.out.println("Please enter in a valid family name");
        }
    }

    void PrintTrait(){ // add this to all
        System.out.println("family: " + familyName);
        System.out.println("     trait: " + familyTrait);
        super.PrintTrait(); 
    }
}
