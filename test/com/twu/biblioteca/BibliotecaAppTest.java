package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

public class BibliotecaAppTest {

    BibliotecaApp bibliotecaApp;
    Biblioteca    biblioteca;

    @Before
    public void setUp() {
        bibliotecaApp = new BibliotecaApp();
        biblioteca    = new Biblioteca("TW Library");
    }

    @Rule
    public final StandardOutputStreamLog log = new StandardOutputStreamLog();

    @Rule
    public TextFromStandardInputStream systemInMock = emptyStandardInputStream();

    @Test
    public void testCreateBibliotecaAppObject() {
        assertNotNull(bibliotecaApp);
    }

    @Test
    public void testMenuMessage() {
        systemInMock.provideText("1\n");
        Menu.display();
        assertEquals("1 - List Books\n" +
                     "2 - Checkout a book\n" +
                     "3 - Return a book\n" +
                     "4 - List Movies\n" +
                     "5 - Checkout Movie\n" +
                     "6 - User Info\n" +
                     "7 - Quit\n", log.getLog());
    }

    @Test
    public void testListBooksOption() {
        BibliotecaApp.chooseOption(1, biblioteca);
        assertEquals("  Book           | Author         | Year Published       \n" +
                     "A Song of Ice And Fire | George R. R. Martin | 1996\n" +
                     "Steve Jobs | Walter Isaacson | 2011\n" +
                     "The Hitchhiker's Guide to the Galaxy | Douglas Adams | 1979\n", log.getLog());
    }

    @Test
    public void testInvalidMenuOption() {
        BibliotecaApp.chooseOption(123, biblioteca);
        assertEquals("Select a valid option!\n", log.getLog());
    }

    @Test
    public void testBookCheckout() {
        systemInMock.provideText("A Song of Ice And Fire\n");
        assertTrue(BibliotecaApp.operateBookFromBiblioteca(biblioteca, Constants.CHECKOUT));
    }

    //@Test
    public void testMessageReturnBook() {
        systemInMock.provideText("Steve Jobs\n");
        assertTrue(BibliotecaApp.operateBookFromBiblioteca(biblioteca, Constants.CHECKIN));
    }

    @Test
    public void testListMoviesOption() {
        BibliotecaApp.chooseOption(4, biblioteca);
        assertEquals("  Movie           | Author         | Year | Rating       \n" +
                "Fight Club | David Fincher | 1999 | 8.9\n" +
                "Walk The Line | James Mangold | 2005 | 7.9\n" +
                "The Shawshank Redemption | Frank Darabont | 1994 | 9.3\n", log.getLog());
    }

    @Test
    public void testMovieCheckout() {
        systemInMock.provideText("Fight Club\n");
        bibliotecaApp.checkoutMovieFromBiblioteca(biblioteca);
        assertEquals(Constants.CHECKOUT_MOVIE_MESSAGE + "\n" + Constants.CHECKOUT_MOVIE_CONFIRMED_MESSAGE + "\n", log.getLog());
    }

    @Test
    public void testUserLogged() {
        assertTrue(biblioteca.loginUser("123-4567", "pass"));
    }

    @Test
    public void testVerifyUser() {
        systemInMock.provideText("123-4567\npass\n");
        User user = BibliotecaApp.verifyUser(biblioteca);

        assertNotNull(user);
    }



}
