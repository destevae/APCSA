package Library;

import java.util.*;
import java.io.* ;
import java.util.Scanner;

public class BookList {

    // creates empty book arraylist
    ArrayList<Book> bookarray = new ArrayList<Book>();

    BookList(){
        bookarray = new ArrayList<Book>();
    }


    void addToList(Book theBook) throws Exception{
        // if book exists, then add to quantity. if book doesn't, then create new
        boolean isCopy = false;
        if(theBook.genre == "Nonfiction"){
            for(Book i : bookarray){
                if(theBook.isEquals(i)){
                    theBook.addtoInt();
                    isCopy = true;
                    break;
                }
            }

            if(isCopy == false){
                bookarray = add(theBook);
            }
            
        }
        
                // if item is already in arraylist, then add to quantity
                if(NonfictionBook.integers > 0){
                    int x = (int) NonfictionBook.integers;
                    x++;
                    NonfictionBook.integers = x;
                }
                
                booklist.add(mybook);
            }

            if(genre.equals("Fiction")){
                FictionBook mybook = new FictionBook(sc.nextLine());
                booklist.add(mybook);
            }

            if(genre.equals("TextBook")){
                TextBook mybook = new TextBook(sc.nextLine());
                booklist.add(mybook);
            }
        }

        sc.close();
    }



    void removeFromList(Book myBook){

    }

    // sorts booklist by sortingMethod
    void sortList(String sortingMethod){
        
    }

    void printTable(){

    }
}
