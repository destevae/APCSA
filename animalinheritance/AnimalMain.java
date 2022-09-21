public class AnimalMain {
    public static void main(String[] args){
        // note: when creating an animal, the phyla name comes before the subphyla name
        
        /////// ANIMALS THAT WORK: monarch butterfly, hammerhead shark ///////
        
        Animals butterfly = new Animals("monarch butterfly", "very pretty", "butterfly", "Insects", "Arthropoda", "Crustaceans");
        butterfly.PrintTrait();

        Animals hammerhead = new Animals("hammerhead shark", "flat head shark", "shark", "Cartilagenous Fish", "Chordata", "Vertebrata");
        hammerhead.PrintTrait();
    }
}
