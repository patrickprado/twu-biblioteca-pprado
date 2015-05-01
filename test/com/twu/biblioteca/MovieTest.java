package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class MovieTest {

    Movie movie;

    @Rule
    public final StandardOutputStreamLog log = new StandardOutputStreamLog();

    @Before
    public void setUp() {
        movie = new Movie("Fight Club", "David Fincher", 1999, 8.9, null);
    }

    @Test
    public void printMovieInfo() {
        movie.printInfo();
        assertEquals("Fight Club | David Fincher | 1999 | 8.9\n", log.getLog());
    }

    @Test
    public void testCheckoutMovie() {
        User user = new User("123-4567", "pass", "Patrick", "pprado@thoughtworks.com", "1234-1234");
        movie.checkOut(user);
        assertTrue(movie.isCheckedOut());
        assertEquals(movie.getCheckedTo(), user);
    }
}