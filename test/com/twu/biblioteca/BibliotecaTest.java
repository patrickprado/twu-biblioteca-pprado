package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;


public class BibliotecaTest {

    private Biblioteca biblioteca;

    @Rule
    public final StandardOutputStreamLog log = new StandardOutputStreamLog();


    @Before
    public void setUp() {
        biblioteca = new Biblioteca("TW Library");
    }

    @Test
    public void testGettingWelcomeMessage() {
        assertEquals("Welcome to TW Library", biblioteca.getWelcomeMessage());
    }

    @Test
    public void testGettingBooksFromBiblioteca() {
        List<Book> books = biblioteca.getBooks();
        assertNotNull(books);
    }

    @Test
    public void testPrintingBooksFromBiblioteca() {
        biblioteca.printBooksInfo();
        assertEquals("  Book           | Author         | Year Published       \n" +
                "A Song of Ice And Fire | George R. R. Martin | 1996\n" +
                "Steve Jobs | Walter Isaacson | 2011\n" +
                "The Hitchhiker's Guide to the Galaxy | Douglas Adams | 1979\n", log.getLog());
    }


    @Test
    public void testPrintingMoviesFromBiblioteca() {
        biblioteca.printMoviesInfo();
        assertEquals("  Movie           | Author         | Year | Rating       \n" +
                "Fight Club | David Fincher | 1999 | 8.9\n" +
                "Walk The Line | James Mangold | 2005 | 7.9\n" +
                "The Shawshank Redemption | Frank Darabont | 1994 | 9.3\n", log.getLog());
    }


    @Test
    public void testLoginUser() {
        assertTrue(biblioteca.loginUser("123-4567", "pass"));
    }

}
