package com.twu.biblioteca;

public class Book extends Checkable {

    private final String author;
    private final String yearPublished;

    public Book(String title, String author, String yearPublished, User checkedTo) {
        this.identifier    = title;
        this.author        = author;
        this.yearPublished = yearPublished;
        this.checkedTo     = checkedTo;
    }

    public String getTitle() {
        return this.identifier;
    }

    public String getAuthor() {
        return author;
    }

    public void printInfo() {
        String info = this.identifier + " | " + this.author + " | " +  this.yearPublished;
        System.out.println(info);
    }
}
