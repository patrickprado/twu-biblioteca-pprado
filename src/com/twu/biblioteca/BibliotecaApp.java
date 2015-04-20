package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class BibliotecaApp {

    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca("TW Library");
        System.out.println(biblioteca.getWelcomeMessage());
        biblioteca.printBooksInfo();
    }


}