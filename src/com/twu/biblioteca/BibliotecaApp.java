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
            case 2: System.out.println(Constants.CHECKOUT_BOOK_MESSAGE);
                    boolean checkoutConfirmed = operateBookFromBiblioteca(biblioteca, Constants.CHECKOUT);
                    messageCheckout(checkoutConfirmed);
                    break;
            case 3: System.out.println(Constants.RETURN_BOOK_MESSAGE);
                    boolean returnConfirmed = operateBookFromBiblioteca(biblioteca, Constants.RETURN);
                    messageReturnBook(returnConfirmed);
                    break;
            case 4: quit = true;
                    break;
            default: System.out.println(Constants.SELECT_A_VALID_OPTION);
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
            try {
                return Integer.parseInt(scanner.next());
            } catch(NumberFormatException e) {
                return 0;
            }
        }
        return 4;
    }

    private static void listBooks(Biblioteca biblioteca) {
        biblioteca.printBooksInfo();
    }

    public static boolean operateBookFromBiblioteca(Biblioteca biblioteca, String operation) {
        Scanner scanner = new Scanner(System.in);
        Boolean operationConfirmed = false;
        if(scanner.hasNextLine()) {
            if(operation == Constants.CHECKOUT) {
                operationConfirmed = biblioteca.checkoutBook(scanner.nextLine());
            }
            else if(operation == Constants.RETURN) {
                operationConfirmed = biblioteca.returnBookToRack(scanner.nextLine());
            }
        }
        return operationConfirmed;
    }

    public static void messageCheckout(Boolean checkoutConfirmed) {
        if(checkoutConfirmed) {
            System.out.println(Constants.CHECKOUT_BOOK_CONFIRMED_MESSAGE);
        }
        else {
            System.out.println(Constants.CHECKOUT_BOOK_UNCONFIRMED_MESSAGE);
        }
    }

    public static void messageReturnBook(Boolean returnConfirmed) {
        if(returnConfirmed) {
            System.out.println(Constants.RETURN_BOOK_CONFIRMED_MESSAGE);
        }
        else {
            System.out.println(Constants.RETURN_BOOK_UNCONFIRMED_MESSAGE);
        }
    }

}