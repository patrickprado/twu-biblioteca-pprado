package com.twu.biblioteca;


public class Movie extends Checkable {

    private final String director;
    private final int year;
    private final double rating;

    public Movie(String name, String director, int year, double rating, User user) {
        this.identifier = name;
        this.director   = director;
        this.year       = year;
        this.rating     = rating;
        this.checkedTo  = user;
    }

    public void printInfo() {
        System.out.println(this.identifier + " | " + this.director + " | " + this.year + " | " + this.rating);
    }

    public String getName() {
        return this.identifier;
    }

}
