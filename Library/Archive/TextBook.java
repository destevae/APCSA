public class TextBook extends Book{
    String edition;
    int integers;
    
    TextBook(String csvLine){
        super(csvLine);
    }

    void printInfo(){
        super.printInfo();
    }
}
