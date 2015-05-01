package com.twu.biblioteca;


public class User {

    private String libraryNumber;
    private String password;
    private String name;
    private String emailAddress;
    private String phoneNumber;
    private boolean authorized;

    public User(String libraryNumber, String password, String name, String emailAddress, String phoneNumber) {
        this.libraryNumber = libraryNumber;
        this.password      = password;
        this.name          = name;
        this.emailAddress  = emailAddress;
        this.phoneNumber   = phoneNumber;
        this.authorized    = false;
    }

    public void allowUser(String libraryNumber, String password) {
        if(libraryNumber.equals(this.libraryNumber) && password.equals(this.password)) {
            this.authorized = true;
        }
    }

    public void disallowUser() {
        this.authorized = false;
    }

    public boolean authorized() {
        return this.authorized;
    }

    public void printUserInfo() {
        System.out.println("Name        | Email         | Phone Number  \n");
        System.out.println(this.name + " | " + this.emailAddress + " | " + this.phoneNumber);
    }

}
