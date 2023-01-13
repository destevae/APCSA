package Library;

public class TextBook extends Book{
    String edition;
    
    TextBook(String csvLine){
        super(csvLine);
    }

    void printInfo(){
        System.out.println(title + " " + genre + " " + author + " " + subject + " " + edition);
    }
}
