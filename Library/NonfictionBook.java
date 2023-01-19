package Library;

public class NonfictionBook extends Book{
    static int integers;
    
    NonfictionBook(String csvLine){
        // break it up after using split and assign to variables

        super(csvLine);
    }

    void printInfo(){
        super.printInfo();
    }
}
