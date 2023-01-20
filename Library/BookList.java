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
                theBook.addtoInt();
                isCopy = true;
                break;
            }
        }

        if(isCopy == false){
            bookarray.add(theBook);
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


    // sorts booklist by sortingMethod
    void sortList(String sortingMethod){
        
    }

    
    void printTable(){

    }
}
