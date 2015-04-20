package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by pprado on 4/17/15.
 */
public class BookTest {

    private Book book;

    @Rule
    public final StandardOutputStreamLog log = new StandardOutputStreamLog();

    @Before
    public void setUp(){
        book = new Book("A Song of Ice and Fire", "George R. R. Martin", "1996");
    }

    @Test
    public void testCreateBookObject() {
        assertNotNull(book);
    }

    @Test
    public void testBookTitleGetterAndSetter() {
        assertEquals(book.getTitle(), "A Song of Ice and Fire");
    }

    @Test
    public void testBookAuthorGetterSetter() {
        assertEquals(book.getAuthor(), "George R. R. Martin");
    }

    @Test
    public void testPrintBookInfo() {
        book.printInfo();
        assertEquals("A Song of Ice and Fire | George R. R. Martin | 1996\n", log.getLog());
    }


}
