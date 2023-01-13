package Library;

public abstract class Book {
    static String title;
    static String genre;
    static String author;
    static String subject;
    static String edition;
    static String integers;

    Book(String csvLine){
        String [] attributes = csvLine.split(",");
        Book.genre = attributes[1];
        Book.author = attributes[2];
        Book.subject = attributes[3];
        Book.edition = attributes[4];
    }

    void printInfo(){
       System.out.println(title + " " + genre + " " + author + " " + subject + " " + edition + " " + integers); 
    }

    
}
