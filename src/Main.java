import Exeption.*;
import Library.*;


public class Main {
    public static void main(String[] args) throws Exception {


        Library library = new Library();


        try{
            library.listBooks();
        }catch (EmptyLibraryException e){
            System.out.println(e.getMessage());
        }


        Book book1 = null;
        Book book2 = null;
        Book book3 = null;
        Book book4 = null;



        book1 = new Book("Java Programming", 300);

        try{
            book2 = new Book("Design Patterns", -3);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

        try{
            book3 = new Book(null, 100);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

        book4 = new Book("", 400);


        library.addBook(book1);

        try {
            library.addBook(book2);
        }catch (InvalidBookException e){
            System.out.println(e.getMessage());
        }

        try {
            library.addBook(book3);
        }catch (InvalidBookException e){
            System.out.println(e.getMessage());
        }

        library.addBook(book4);

        library.listBooks();


        library.borrowBook("Java Programming");

        try {
            library.returnBook("Clean Code");
        }catch (BookNotFoundException e){
            System.out.println(e.getMessage());
        }


        library.returnBook("Java Programming");
    }
}