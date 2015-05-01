package com.twu.biblioteca;

public class Checkable {

    protected User checkedTo;

    protected String identifier;

    public boolean isCheckedOut() {
        return this.checkedTo != null;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public void checkOut(User user) {
        this.checkedTo = user;
    }

    public void checkIn() {
        this.checkedTo = null;
    }

    public User getCheckedTo() {
        return this.checkedTo;
    }

}
