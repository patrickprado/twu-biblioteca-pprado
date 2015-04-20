package com.twu.biblioteca;

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
            case 2: quit = true;
                break;
            default: System.out.println("Select a valid option!");
                break;
        }
    }

    public static int menu() {
        System.out.println("1 - List Books");
        System.out.println("2 - Quit");
        Scanner scanner = new Scanner(System.in);
        return Integer.parseInt(scanner.next());
    }

    private static void listBooks(Biblioteca biblioteca) {
        biblioteca.printBooksInfo();
    }

}