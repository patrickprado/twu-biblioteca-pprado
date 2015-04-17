package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

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



}
