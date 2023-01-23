import java.util.*;

public class BookList {

    // creates empty book arraylist
    ArrayList<Book> bookarray;

    BookList(){
        bookarray = new ArrayList<Book>();
    }


    void addToList(Book theBook) throws Exception{
        // if book exists, then add to quantity. if book doesn't, then create new
        boolean isCopy = false;

        // System.out.println("old integer: " + theBook.integers);
        for(Book i : bookarray){
            if(theBook.isEquals(i)){
                i.addtoInt();
                System.out.println("Copies: " + i.integers);
                isCopy = true;
                break;
            }
        }

        if(isCopy == false){
            bookarray.add(theBook);
            theBook.addtoInt();
            System.out.println("Copies: " + theBook.integers);
        }
    }


    void removeFromList(Book theBook){
        if(theBook.integers > 1){
            theBook.subtractFromInt();
        }

        else{
            bookarray.remove(theBook);
        }
    }


    // sorts booklist by Title, Genre, Author, and Subject
    void sortList(String sortingMethod){
        if(sortingMethod.equals("title")){
            int current_lowest; // index of lowest number we have found in the array so far
       
            for(int i=0; i<bookarray.size() - 1; i++){
                current_lowest = i;
    
                for(int j=i+1; j<bookarray.size(); j++){ 
                    String bookTitle = bookarray.get(current_lowest).getTitle();
                    if(bookTitle.compareTo(bookarray.get(j).getTitle()) > 0) {
                        current_lowest = j; // found a new lowest value
                    }
                }
 
                Book temp = bookarray.get(i);
                bookarray.set(i, bookarray.get(current_lowest));
                bookarray.set(current_lowest, temp);

            }

            for(int i=0; i<bookarray.size(); i++){
                System.out.println(bookarray.get(i).getTitle());
            }
        }

        else if(sortingMethod.equals("genre")){
            int current_lowest; // index of lowest number we have found in the array so far
       
            for(int i=0; i<bookarray.size() - 1; i++){
                current_lowest = i;
    
                for(int j=i+1; j<bookarray.size(); j++){ 
                    String bookTitle = bookarray.get(current_lowest).getGenre();
                    if(bookTitle.compareTo(bookarray.get(j).getGenre()) > 0) {
                        current_lowest = j; // found a new lowest value
                    }
                }
 
                Book temp = bookarray.get(i);
                bookarray.set(i, bookarray.get(current_lowest));
                bookarray.set(current_lowest, temp);

            }

            for(int i=0; i<bookarray.size(); i++){
                System.out.println(bookarray.get(i).getGenre());
            }
        }

        else if(sortingMethod.equals("author")){
            int current_lowest; // index of lowest number we have found in the array so far
       
            for(int i=0; i<bookarray.size() - 1; i++){
                current_lowest = i;
    
                for(int j=i+1; j<bookarray.size(); j++){ 
                    String bookTitle = bookarray.get(current_lowest).getAuthor();
                    if(bookTitle.compareTo(bookarray.get(j).getAuthor()) > 0) {
                        current_lowest = j; // found a new lowest value
                    }
                }
 
                Book temp = bookarray.get(i);
                bookarray.set(i, bookarray.get(current_lowest));
                bookarray.set(current_lowest, temp);

            }

            for(int i=0; i<bookarray.size(); i++){
                System.out.println(bookarray.get(i).getAuthor());
            }
        }

        else if(sortingMethod.equals("subject")){
            int current_lowest; // index of lowest number we have found in the array so far
       
            for(int i=0; i<bookarray.size() - 1; i++){
                current_lowest = i;
    
                for(int j=i+1; j<bookarray.size(); j++){ 
                    String bookTitle = bookarray.get(current_lowest).getSubject();
                    if(bookTitle.compareTo(bookarray.get(j).getSubject()) > 0) {
                        current_lowest = j; // found a new lowest value
                    }
                }
 
                Book temp = bookarray.get(i);
                bookarray.set(i, bookarray.get(current_lowest));
                bookarray.set(current_lowest, temp);

            }

            for(int i=0; i<bookarray.size(); i++){
                System.out.println(bookarray.get(i).getSubject());
            }
        }
    }

    
    void printTable(){
        System.out.println("________________________________________________________________________________________");
        System.out.println("| Title                     | Genre    | Author            | Subject   | Edition | QTY |");
        System.out.println("|---------------------------|----------|-------------------|-----------|---------|-----|");

        for(int i=0; i<bookarray.size() - 1; i++){

            // title
            int titleSpaces = 27 - (bookarray.get(i).getTitle().length());
            System.out.print("|" + bookarray.get(i).getTitle());
            for(int j = 0; j < titleSpaces; j++){
                System.out.print(" ");
            }
        }
        
    }
}