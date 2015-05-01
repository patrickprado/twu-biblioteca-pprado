package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;

import static org.junit.Assert.*;


public class BookTest {

    private Book book;

    @Rule
    public final StandardOutputStreamLog log = new StandardOutputStreamLog();

    @Before
    public void setUp(){
        book = new Book("A Song of Ice And Fire", "George R. R. Martin", "1996", null);
    }

    @Test
    public void testCreateBookObject() {
        assertNotNull(book);
    }

    @Test
    public void testBookTitleGetterAndSetter() {
        assertEquals(book.getTitle(), "A Song of Ice And Fire");
    }

    @Test
    public void testBookAuthorGetterSetter() {
        assertEquals(book.getAuthor(), "George R. R. Martin");
    }

    @Test
    public void testPrintBookInfo() {
        book.printInfo();
        assertEquals("A Song of Ice And Fire | George R. R. Martin | 1996\n", log.getLog());
    }

    @Test
    public void testCheckoutABook() {
        Book bookUncheckout = new Book("Steve Jobs", "Walter Isaacson", "2011", null);
        User user = new User("123-4567", "pass", "Patrick", "pprado@thoughtworks.com", "1234-1234");
        bookUncheckout.checkOut(user);
        assertTrue(bookUncheckout.isCheckedOut());
        assertEquals(bookUncheckout.getCheckedTo(), user);
    }

    @Test
    public void testUncheckoutABook() {
        Book bookCheckout = new Book("A Song of Ice And Fire", "George R. R. Martin", "1996", null);
        bookCheckout.checkIn();
        assertFalse(bookCheckout.isCheckedOut());
    }


}
