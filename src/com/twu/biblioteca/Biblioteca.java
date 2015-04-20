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
        books.add(new Book("A Song of Ice And Fire", "George R. R. Martin", "1996"));
        books.add(new Book("Steve Jobs", "Walter Isaacson", "2011"));
        books.add(new Book("The Hitchhiker's Guide to the Galaxy", "Douglas Adams", "1979"));
    }

    public List<Book> getBooks() {
        return books;
    }


    public void printBooksInfo() {
        System.out.println("  Book           | Author         | Year Published       ");
        for(Book b : books) {
            b.printInfo();
        }
    }
}
