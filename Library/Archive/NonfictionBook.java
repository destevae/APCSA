public class NonfictionBook extends Book{
    int integers;
    
    NonfictionBook(String csvLine){
        // break it up after using split and assign to variables

        super(csvLine);
    }

    void printInfo(){
        super.printInfo();
    }
}