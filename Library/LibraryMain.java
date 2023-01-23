import java.io.* ;
import java.util.Scanner;

public class LibraryMain{
    public static void main(String[] args) throws Exception {

        BookList myBooks = new BookList();

        // https://techvidvan.com/tutorials/read-csv-file-in-java/
        Scanner sc = new Scanner(new File("./booklist.csv"));

        sc.nextLine();
        while(sc.hasNext()){ // creates new book, calls addToList method

            String input = sc.nextLine();
            String [] data = input.split(",");
            

            if(data[1].equals("Nonfiction")){
                Book myBook = new NonfictionBook(input);
                myBooks.addToList(myBook);
                myBook.printInfo();
            }

            if(data[1].equals("Fiction")){
                Book myBook = new FictionBook(input);
                myBooks.addToList(myBook);
                myBook.printInfo();
            }

            if(data[1].equals("Textbook")){
                Book myBook = new TextBook(input);
                myBooks.addToList(myBook);
                myBook.printInfo();
            }
        }

        myBooks.sortList("subject");
    }
}