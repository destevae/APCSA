public class FictionBook extends Book{
    String edition;
    int integers;
    
    FictionBook(String csvLine){
        super(csvLine);
    }

    void printInfo(){
        super.printInfo();
    }
}