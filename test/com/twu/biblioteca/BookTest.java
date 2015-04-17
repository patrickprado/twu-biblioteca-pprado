package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by pprado on 4/17/15.
 */
public class BookTest {

    Book book;

    @Before
    public void setUp(){
        book = new Book();
    }

    @Test
    public void testCreateBookObject() {
        assertNotNull(book);
    }

    @Test
    public void testBookTitleGetterAndSetter() {
        book.setTitle("A Song of Ice and Fire");
        assertEquals(book.getTitle(), "A Song of Ice and Fire");
    }

    @Test
    public void testBookAuthorGetterSetter() {
        book.setAuthor("George R. R. Martin");
        assertEquals(book.getAuthor(), "George R. R. Martin");
    }


}
