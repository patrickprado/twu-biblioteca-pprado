package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;


public class Library<T extends Checkable> {

    List<T> list = new ArrayList<T>();

    public boolean add(T t) {
        return list.add(t);
    }

    public List<T> get() {
        return list;
    }

    public boolean checkout(String bookTitle, User currentUser) {
        for (T t : list) {
            if (t.getIdentifier().equals(bookTitle) && !t.isCheckedOut()) {
                t.checkOut(currentUser);
                return true;
            }
        }
        return false;
    }

    public boolean checkin(String identifier) {
        for (T t : list) {
            if (t.getIdentifier().equals(identifier) && t.isCheckedOut()) {
                t.checkIn();
                return true;
            }
        }
        return false;
    }


}
