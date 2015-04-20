package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;

import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by pprado on 4/17/15.
 */
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
        assertEquals("  Book           | Author         | Year Published       |\n" +
                     "A Song of Ice And Fire | George R. R. Martin | 1996\n" +
                     "Steve Jobs | Walter Isaacson | 2011\n" +
                     "The Hitchhiker's Guide to the Galaxy | Douglas Adams | 1979\n", log.getLog());
    }

}
