package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by pprado on 4/30/15.
 */
public class LibraryTest {

    Library<Book> libraryBook;
    Library<Movie> libraryMovie;
    User user;

    @Before
    public void setUp() throws Exception {
        libraryBook = new Library<Book>();
        libraryMovie = new Library<Movie>();

        user = new User("123-4567", "pass", "Patrick", "pprado@thoughtworks.com", "1234-1234");

        libraryBook.add(new Book("A Song of Ice And Fire", "George R. R. Martin", "1996", null));
        libraryBook.add(new Book("Steve Jobs", "Walter Isaacson", "2011", user));
        libraryMovie.add(new Movie("Fight Club", "David Fincher", 1999, 8.9, null));
    }

    @Test
    public void checkoutBook() {
        assertTrue(libraryBook.checkout("A Song of Ice And Fire", user));
        assertEquals(libraryBook.list.get(0).checkedTo, user);
    }

    @Test
    public void checkinBook() {
        assertTrue(libraryBook.checkin("Steve Jobs"));
        assertEquals(libraryBook.list.get(0).checkedTo, null);
    }

    @Test
    public void checkoutMovie() {
        assertTrue(libraryMovie.checkout("Fight Club", user));
        assertEquals(libraryMovie.list.get(0).checkedTo, user);
    }

}