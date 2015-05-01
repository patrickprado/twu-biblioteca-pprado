package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp {

    private static boolean quit;
    private static User currentUser = null;
    private static Menu menu = new Menu();

    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca("TW Library");

        login(biblioteca);

        System.out.println(biblioteca.getWelcomeMessage());

        quit = false;
        while(!quit) {
            menu.display();
            chooseOption(menu.readOption(), biblioteca);
        }
    }

    static void chooseOption(int optionMenu, Biblioteca biblioteca) {
        switch (optionMenu) {
            case 1: biblioteca.printBooksInfo();
                    break;
            case 2: System.out.println(Constants.CHECKOUT_BOOK_MESSAGE);
                    boolean checkoutConfirmed = operateBookFromBiblioteca(biblioteca, Constants.CHECKOUT);
                    messageCheckoutBook(checkoutConfirmed);
                    break;
            case 3: System.out.println(Constants.RETURN_BOOK_MESSAGE);
                    boolean returnConfirmed = operateBookFromBiblioteca(biblioteca, Constants.CHECKIN);
                    messageReturnBook(returnConfirmed);
                    break;
            case 4: biblioteca.printMoviesInfo();
                break;
            case 5: checkoutMovieFromBiblioteca(biblioteca);
                    break;
            case 6: printCurrentUserInfo();
                    break;
            case 7: quit = true;
                    currentUser.disallowUser();
                    break;
            default: System.out.println(Constants.SELECT_A_VALID_OPTION);
                    break;
        }
    }

    public static boolean operateBookFromBiblioteca(Biblioteca biblioteca, String operation) {
        Scanner scanner = new Scanner(System.in);
        Boolean operationConfirmed = false;
        if(scanner.hasNextLine()) {
            if(operation.equals(Constants.CHECKOUT)) {
                operationConfirmed = biblioteca.getBookLibrary().checkout(scanner.nextLine(), currentUser);
            }
            else if(operation.equals(Constants.CHECKIN)) {
                operationConfirmed = biblioteca.getBookLibrary().checkin(scanner.nextLine());
            }
        }
        return operationConfirmed;
    }

    public static void messageCheckoutBook(Boolean checkoutConfirmed) {
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

    public static void checkoutMovieFromBiblioteca(Biblioteca biblioteca) {
        System.out.println(Constants.CHECKOUT_MOVIE_MESSAGE);
        Scanner scanner = new Scanner(System.in);
        Boolean operationConfirmed = false;
        if(scanner.hasNextLine()) {
            operationConfirmed = biblioteca.getMovieLibrary().checkout(scanner.nextLine(), currentUser);
        }
        messageCheckoutMovie(operationConfirmed);
    }


    public static void messageCheckoutMovie(boolean checkoutMovieConfirmed) {
        if(checkoutMovieConfirmed) {
            System.out.println(Constants.CHECKOUT_MOVIE_CONFIRMED_MESSAGE);
        }
        else {
            System.out.println(Constants.CHECKOUT_MOVIE_UNCONFIRMED_MESSAGE);
        }
    }

    public static User verifyUser(Biblioteca biblioteca) {
        Scanner scanner = new Scanner(System.in);

        String libraryNumber = scanner.nextLine();
        String password = scanner.nextLine();

        if(biblioteca.loginUser(libraryNumber, password)) {
            User user = new User(libraryNumber, password, "Patrick", "pprado@thoughtworks.com", "1234-1234");
            return user;
        }

        return null;
    }

    public static void login(Biblioteca biblioteca) {
        while(currentUser == null) {
            System.out.println(Constants.LOGIN_MESSAGE);
            currentUser = verifyUser(biblioteca);
        }
    }

    private static void printCurrentUserInfo() {
        currentUser.printUserInfo();
    }



}