abstract class Book {
    String title;
    String genre;
    String author;
    String subject;
    int edition;
    int integers;
    

    Book(String csvLine){
        String [] attributes = csvLine.split(",");
        title = attributes[0];
        genre = attributes[1];
        author = attributes[2];
        subject = attributes[3];
        edition = Integer.parseInt(attributes[4]);
        int integers = 1;
    }

    void printInfo(){
       System.out.println("Title:" + title); 
       System.out.println("Genre:" + genre);
       System.out.println("Author:" + author);
       System.out.println("Subject:" + subject);
       System.out.println("Edition:" + edition);
       System.out.println("");
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
           && compareBook.edition == edition){
            // System.out.println("BOOK TITLE COMPARED: " + compareBook.title);
            return true;
        }

        return false;
    }

    public void addtoInt(){
        integers++;
    }

    public void subtractFromInt(){
        integers--;
    }

    
}