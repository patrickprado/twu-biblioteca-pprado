package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class UserTest {

    User user;

    @Before
    public void setUp() {
        user = new User("123-4567", "passwordAccept", "Patrick", "pprado@thoughtworks.com", "1234-1234");
    }

    @Test
    public void testUserAuthorized() {
        user.allowUser("123-4567", "passwordAccept");
        assertTrue(user.authorized());
    }

    @Test
    public void testUserUnauthorized() {
        user.disallowUser();
        assertFalse(user.authorized());
    }

}