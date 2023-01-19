package Library;

public abstract class Book {
    String title;
    String genre;
    String author;
    String subject;
    int edition;
    int integers;

    Book(String csvLine){
        String [] attributes = csvLine.split(",");
        genre = attributes[1];
        author = attributes[2];
        subject = attributes[3];
        edition = Integer.parseInt(attributes[4]);
        integers = 1;
    }

    void printInfo(){
       System.out.println(title + " " + genre + " " + author + " " + subject + " " + edition + " " + integers); 
    }

    public String getTitle(){
        return title;
    }

    public String getGenre(){
        return genre;
    }

    public String getAuthor(){
        return author;
    }

    public String getSubject(){
        return subject;
    }

    public int getEdition(){
        return edition;
    }

    public int getIntegers(){
        return integers;
    }

    public boolean isEquals(Book compareBook){
        if(compareBook.title.equals(title) && compareBook.genre.equals(genre) && compareBook.author.equals(author) && compareBook.subject.equals(subject) 
           && compareBook.edition == edition && compareBook.integers == integers){
            return true;
        }

        return false;
    }

    public void addtoInt(){
        integers++;
    }

    
}
