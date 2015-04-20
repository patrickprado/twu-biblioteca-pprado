package com.twu.biblioteca;

import sun.text.bidi.BidiLine;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BibliotecaApp {

    private static boolean quit;

    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca("TW Library");
        System.out.println(biblioteca.getWelcomeMessage());
        quit = false;
        while(!quit) {
            chooseOption(menu(), biblioteca);
        }
    }

    static void chooseOption(int optionMenu, Biblioteca biblioteca) {
        switch (optionMenu) {
            case 1: listBooks(biblioteca);
                    break;
            case 2: checkoutBookFromBiblioteca(biblioteca);
                    break;
            case 3: returnBookToBiblioteca(biblioteca);
                    break;
            case 4: quit = true;
                    break;
            default: System.out.println("Select a valid option!");
                    break;
        }
    }

    public static int menu() {
        System.out.println("1 - List Books");
        System.out.println("2 - Checkout a book");
        System.out.println("3 - Return a book");
        System.out.println("4 - Quit");

        Scanner scanner = new Scanner(System.in);
        if(scanner.hasNext()) {
            return Integer.parseInt(scanner.next());
        }
        return 2;
    }

    private static void listBooks(Biblioteca biblioteca) {
        biblioteca.printBooksInfo();
    }

    public static void checkoutBookFromBiblioteca(Biblioteca biblioteca) {
        System.out.println("Please, digit a book title to checkout:\n");
        Scanner scanner = new Scanner(System.in);
        Boolean checkoutConfirmed = false;
        if(scanner.hasNextLine()) {
            checkoutConfirmed = biblioteca.checkoutBook(scanner.nextLine());
        }
        messageCheckout(checkoutConfirmed);
    }

    public static void messageCheckout(Boolean checkoutConfirmed) {
        if(checkoutConfirmed) {
            System.out.println("Thank you! Enjoy the book.");
        }
        else {
            System.out.println("That book is not available.");
        }
    }

    public static void returnBookToBiblioteca(Biblioteca biblioteca) {
        System.out.println("Please, digit the book title which you are returning:\n");
        Scanner scanner = new Scanner(System.in);
        Boolean returnConfirmed = false;
        if(scanner.hasNextLine()) {
            returnConfirmed = biblioteca.returnBookToRack(scanner.nextLine());
        }
        messageReturnBook(returnConfirmed);
    }

    public static void messageReturnBook(Boolean returnConfirmed) {
        if(returnConfirmed) {
            System.out.println("Thank you for returning the book.");
        }
        else {
            System.out.println("That is not a valid book to return.");
        }
    }


}