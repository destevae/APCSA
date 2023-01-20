public class TextBook extends Book{
    String edition;
    
    TextBook(String csvLine){
        super(csvLine);
    }

    void printInfo(){
        super.printInfo();
    }
}
