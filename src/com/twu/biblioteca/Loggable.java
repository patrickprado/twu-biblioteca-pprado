package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;


public class Loggable {

    private List<User> users = new ArrayList<User>();

    public void setUsers() {
        users.add(new User("123-4567", "pass", "Patrick", "pprado@thoughtworks.com", "1234-1234"));
        users.add(new User("246-3579", "pass", "Patrick", "pprado@thoughtworks.com", "1234-1234"));
        users.add(new User("135-2468", "pass", "Patrick", "pprado@thoughtworks.com", "1234-1234"));
    }

    public boolean loginUser(String libraryNumber, String password) {
        for (User u : this.users) {
            u.allowUser(libraryNumber, password);
            if(u.authorized()) {
                return true;
            }
        }
        return false;
    }

}
