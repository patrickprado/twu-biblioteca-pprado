package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;
import sun.jvm.hotspot.HelloWorld;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class BibliotecaAppTest {

    BibliotecaApp biblioteca;

    @Before
    public void setUp() {
        biblioteca = new BibliotecaApp();
    }

    @Rule
    public final StandardOutputStreamLog log = new StandardOutputStreamLog();

    @Test
    public void testCreateBibliotecaAppObject() {
        assertNotNull(biblioteca);
    }

    @Test
    public void testWelcomeMessage() {
        biblioteca.main(null);
        assertEquals("Welcome to TW Library\n" +
                        "  Book           | Author         | Year Published       |\n" +
                        "A Song of Ice And Fire | George R. R. Martin | 1996\n" +
                        "Steve Jobs | Walter Isaacson | 2011\n" +
                        "The Hitchhiker's Guide to the Galaxy | Douglas Adams | 1979\n", log.getLog());
    }


}
