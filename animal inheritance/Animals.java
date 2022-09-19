public class Animals{
    Phyla phylaOne;
    Phyla phylaTwo;

    Animals(){
        phylaOne = new Phyla("Arthropoda");
        phylaTwo = new Phyla("Chordata");
    }

    String name;
    public String uniqueTrait;

    /* Animals(String phylaName, String uniqueTrait){
        name = phylaName;
        String trait = uniqueTrait;
        System.out.println("Unique Trait: "+ uniqueTrait);
    }

    void PrintTrait(){
        System.out.println("Animal: " + name);
        System.out.println("  trait: " + uniqueTrait);
        super.PrintTrait();
    } */
}
