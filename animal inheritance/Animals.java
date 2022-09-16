public class Animals{
    String name;
    public String unique_trait;

    Animals(String phylaName, String phylaTrait){
        name = phylaName;
        trait = phylaTrait;
        System.out.println("Unique Trait: "+ unique_trait);
    }

    void PrintTrait(){
        System.out.println("Animal: " + name);
        System.out.println("  trait: " + unique_trait);
        super.PrintTrait();
    }
}
