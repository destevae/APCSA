package Library;

import java.util.*;
import java.io.* ;
import java.util.Scanner;

public class BookList {

    // creates empty book arraylist
    ArrayList<Book> booklist = new ArrayList<Book>();

    BookList(){}

    // creates book list, reads scanner
    void createBookList(){

        
    }

    void addToList(String title, String genre) throws Exception{
        // if book exists, then add to quantity. if book doesn't, then create new
        
        // https://techvidvan.com/tutorials/read-csv-file-in-java/
        Scanner sc = new Scanner(new File("./booklist.csv"));
        // setting comma as delimiter pattern
        sc.useDelimiter(",");
        
        while(sc.hasNext()){ // creates new book, calls addToList method
            if(genre.equals("Nonfiction")){
                NonfictionBook mybook = new NonfictionBook(sc.next());
                booklist.add(mybook);
            }

            if(genre.equals("Fiction")){
                FictionBook mybook = new FictionBook(sc.next());
                booklist.add(mybook);
            }

            if(genre.equals("TextBook")){
                TextBook mybook = new TextBook(sc.next());
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
