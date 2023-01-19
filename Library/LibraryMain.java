package Library;

import java.io.* ;
import java.util.Scanner;

public class LibraryMain{
    public static void main(String[] args) throws Exception {

        BookList myBooks = new BookList();

        // https://techvidvan.com/tutorials/read-csv-file-in-java/
        Scanner sc = new Scanner(new File("./booklist.csv"));
        
        while(sc.hasNext()){ // creates new book, calls addToList method

            // MR DURRETT //

            String input = sc.nextLine();
            String [] data = input.split(",");

            if(data[1] == "Nonfiction"){
                myBooks.addToList(new FictionBook(data));
            }


            if(Book.genre.equals("Nonfiction")){
                Book mybook = new NonfictionBook(sc.nextLine());
                myBooks.addToList(mybook);

            }

            else if(Book.genre.equals("Fiction")){
                Book mybook = new FictionBook(sc.nextLine());
                myBooks.addToList(mybook);
            }
    
            else if(Book.genre.equals("TextBook")){
                Book mybook = new TextBook(sc.nextLine());
                myBooks.addToList(mybook);
            }
        }
    
    }
}
