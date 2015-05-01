package com.twu.biblioteca;

import java.util.Scanner;

public class Menu {

    public static void display() {
        System.out.println("1 - List Books");
        System.out.println("2 - Checkout a book");
        System.out.println("3 - Return a book");
        System.out.println("4 - List Movies");
        System.out.println("5 - Checkout Movie");
        System.out.println("6 - User Info");
        System.out.println("7 - Quit");
    }

    public static int readOption() {
        Scanner scanner = new Scanner(System.in);
        if(scanner.hasNext()) {
            try {
                return Integer.parseInt(scanner.next());
            } catch(NumberFormatException e) {
                return 0;
            }
        }
        return 7;
    }
}
