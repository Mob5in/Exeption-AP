package Library;

import Exeption.BookNotFoundException;
import Exeption.EmptyLibraryException;
import Exeption.InvalidBookException;

import java.util.ArrayList;
import java.util.Objects;

public class Library {
    private ArrayList<Book> books;

    public Library(){
        books = new ArrayList<Book>();
    }

    public void addBook(Book book) throws Exception {
        if(book == null){
            throw new InvalidBookException("Book should not be null");
        }
        this.books.add(book);
    }

    private Book findBook(String title){
        for(Book book : books){
            if(Objects.equals(book.getTitle(), title)){
                return book;
            }
        }
        return null;
    }


    public void borrowBook(String title)throws Exception{
        if(books.isEmpty()){
            throw new EmptyLibraryException("Library is empty no book to borrow");
        }
        Book book = findBook(title);
        if(book == null){
            throw new BookNotFoundException("Book with title "+title+" not found");
        }
        System.out.println("Book is borrowed: " + book);

    }


    public void returnBook(String title)throws BookNotFoundException{
        Book book = findBook(title);
        if(book == null){
            throw new BookNotFoundException("cannot return, book with title "+title+" not found");
        }
        System.out.println("the book "+book+" successfully returned");
    }


    public void listBooks() throws EmptyLibraryException{
        if(books.isEmpty()){
            throw new EmptyLibraryException("Library is empty");
        }
        System.out.println("Books in the library");
        for(Book book : books){
            System.out.println(book);
        }

    }

}

