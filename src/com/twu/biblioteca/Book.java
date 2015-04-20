package com.twu.biblioteca;

/**
 * Created by pprado on 4/17/15.
 */
public class Book {

    private final String title;
    private final String author;
    private final String yearPublished;
    private boolean checkout;

    public Book(String title, String author, String yearPublished, boolean checkout) {
        this.title  = title;
        this.author = author;
        this.yearPublished = yearPublished;
        this.checkout  = checkout;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public void printInfo() {
        String info = this.title + " | " + this.author + " | " +  this.yearPublished;
        System.out.println(info);
    }

    public boolean isCheckout() {
        return this.checkout;
    }
}
