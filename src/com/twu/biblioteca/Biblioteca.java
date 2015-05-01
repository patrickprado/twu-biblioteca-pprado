package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;


public class Biblioteca extends Loggable {

    private Library<Book> bookLibrary   = new Library<Book>();
    private Library<Movie> movieLibrary = new Library<Movie>();
    private String name;

    public Biblioteca(String name) {
        this.name = name;
        setBooks();
        setMovies();
        setUsers();
    }

    public String getWelcomeMessage() {
        return "Welcome to " + this.name;
    }

    public void setBooks() {
        bookLibrary.add(new Book("A Song of Ice And Fire", "George R. R. Martin", "1996", null));
        bookLibrary.add(new Book("Steve Jobs", "Walter Isaacson", "2011", null));
        bookLibrary.add(new Book("The Hitchhiker's Guide to the Galaxy", "Douglas Adams", "1979",null ));
    }

    public void setMovies() {
        movieLibrary.add(new Movie("Fight Club", "David Fincher", 1999, 8.9, null));
        movieLibrary.add(new Movie("Walk The Line", "James Mangold", 2005, 7.9, null));
        movieLibrary.add(new Movie("The Shawshank Redemption", "Frank Darabont", 1994, 9.3, null));
    }


    public List<Book> getBooks() { return bookLibrary.get(); }

    public Library getBookLibrary() {
        return this.bookLibrary;
    }

    public Library getMovieLibrary() {
        return this.movieLibrary;
    }

    public List<Movie> getMovies() {
        return movieLibrary.get();
    }


    public void printBooksInfo() {
        System.out.println("  Book           | Author         | Year Published       ");
        for (Book b : getBooks()) {
            if (!b.isCheckedOut()) {
                b.printInfo();
            }
        }
    }

    public void printMoviesInfo() {
        System.out.println("  Movie           | Author         | Year | Rating       ");
        for (Movie m : getMovies()) {
            if (!m.isCheckedOut()) {
                m.printInfo();
            }
        }
    }

}