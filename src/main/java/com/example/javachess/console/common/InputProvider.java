package com.example.javachess.console.common;

import java.util.Scanner;

public class InputProvider {

    private static final Scanner scanner = new Scanner(System.in);

    public static String isStartGame() {
        return scanner.next();
    }

    public static String inputCommand() {
        return scanner.next();
    }
}
