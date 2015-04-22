package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pprado on 4/17/15.
 */
public class Biblioteca {

    private List<Book> books = new ArrayList<Book>();
    private String name;

    public Biblioteca(String name) {
        this.name = name;
        setBooks();
    }

    public String getWelcomeMessage() {
        return "Welcome to " + this.name;
    }

    public void setBooks() {
        books.add(new Book("A Song of Ice And Fire", "George R. R. Martin", "1996", false));
        books.add(new Book("Steve Jobs", "Walter Isaacson", "2011", true));
        books.add(new Book("The Hitchhiker's Guide to the Galaxy", "Douglas Adams", "1979", false));
    }

    public List<Book> getBooks() {
        return books;
    }


    public void printBooksInfo() {
        System.out.println("  Book           | Author         | Year Published       ");
        for(Book b : books) {
            if (!b.isCheckout()) {
                b.printInfo();
            }
        }
    }

    public boolean checkoutBook(String bookTitle) {
        for(Book b : books) {
            if(b.getTitle().equals(bookTitle) && !b.isCheckout()) {
                b.checkoutBook();
                return true;
            }
        }
        return false;
    }

    public boolean returnBookToRack(String bookTitle) {
        for(Book b : books) {
            if(b.getTitle().equals(bookTitle) && b.isCheckout()) {
                b.uncheckoutBook();
                return true;
            }
        }
        return false;
    }

}
