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

        for(Book i : bookarray){
            if(theBook.isEquals(i)){
                i.addtoInt();
                isCopy = true;
                break;
            }
        }

        if(isCopy == false){
            bookarray.add(theBook);
            theBook.addtoInt();
            if(theBook.subject.equals("")){
            }
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

            for(int i=0; i<bookarray.size() - 1; i++){
                current_lowest = i;
                for(int j=i+1; j<bookarray.size(); j++){ 
                    String bookTitle = bookarray.get(current_lowest).getGenre();
                    if(bookTitle.compareTo(bookarray.get(j).getGenre()) == 0 && 
                      (bookarray.get(current_lowest).getTitle().compareTo(bookarray.get(j).getTitle()) > 0)){
                        current_lowest = j;
                    }

                }

                Book temp = bookarray.get(i);
                bookarray.set(i, bookarray.get(current_lowest));
                bookarray.set(current_lowest, temp);
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

            for(int i=0; i<bookarray.size() - 1; i++){
                current_lowest = i;
                for(int j=i+1; j<bookarray.size(); j++){ 
                    String bookTitle = bookarray.get(current_lowest).getAuthor();
                    if(bookTitle.compareTo(bookarray.get(j).getAuthor()) == 0 && 
                      (bookarray.get(current_lowest).getTitle().compareTo(bookarray.get(j).getTitle()) > 0)){
                        current_lowest = j;
                    }

                }

                Book temp = bookarray.get(i);
                bookarray.set(i, bookarray.get(current_lowest));
                bookarray.set(current_lowest, temp);
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

            for(int i=0; i<bookarray.size() - 1; i++){
                current_lowest = i;
                for(int j=i+1; j<bookarray.size(); j++){ 
                    String bookTitle = bookarray.get(current_lowest).getSubject();
                    if(bookTitle.compareTo(bookarray.get(j).getSubject()) == 0 && 
                      (bookarray.get(current_lowest).getTitle().compareTo(bookarray.get(j).getTitle()) > 0)){
                        current_lowest = j;
                    }

                }

                Book temp = bookarray.get(i);
                bookarray.set(i, bookarray.get(current_lowest));
                bookarray.set(current_lowest, temp);
            }
        }
        
        else{
            System.out.println("Please make sure you are sorting by a valid method.");
        }
    }

    
    void printTable(){
        System.out.println("________________________________________________________________________________________");
        System.out.println("| Title                     | Genre    | Author            | Subject   | Edition | QTY |");
        System.out.println("|---------------------------|----------|-------------------|-----------|---------|-----|");

        for(int i=0; i<bookarray.size(); i++){

            // title
            int titleSpaces = 27 - (bookarray.get(i).getTitle().length());
            System.out.print("|" + bookarray.get(i).getTitle());
            for(int j = 0; j < titleSpaces; j++){
                System.out.print(" ");
            }

            // genre
            int genreSpaces = 10 - (bookarray.get(i).getGenre().length());
            System.out.print("|" + bookarray.get(i).getGenre());
            for(int j = 0; j < genreSpaces; j++){
                System.out.print(" ");
            }

            // author
            int authorSpaces = 19 - (bookarray.get(i).getAuthor().length());
            System.out.print("|" + bookarray.get(i).getAuthor());
            for(int j = 0; j < authorSpaces; j++){
                System.out.print(" ");
            }

            // subject
            int subjectSpaces = 11 - (bookarray.get(i).getSubject().length());
            System.out.print("|" + bookarray.get(i).getSubject());
            for(int j = 0; j < subjectSpaces; j++){
                System.out.print(" ");
            }

            // edition
            String editionString = Integer.toString(bookarray.get(i).getEdition());
            int editionSpaces = 9 - editionString.length();
            System.out.print("|" + bookarray.get(i).getEdition());
            for(int j = 0; j < editionSpaces; j++){
                System.out.print(" ");
            }

            // qty
            String qtyString = Integer.toString(bookarray.get(i).getIntegers());
            int qtySpaces = 5 - qtyString.length();
            System.out.print("|" + bookarray.get(i).getIntegers());
            for(int j = 0; j < qtySpaces; j++){
                System.out.print(" ");
            }

            System.out.println("|");

        }

        System.out.println("----------------------------------------------------------------------------------------");
        
    }
}