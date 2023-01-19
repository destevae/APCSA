package Library;

public class FictionBook extends Book{
    String edition;
    
    FictionBook(String csvLine){
        super(csvLine);
    }

    void printInfo(){
        super.printInfo();
    }
}
