package com.cj.test;

import java.io.Console;

public class ConsoleTest {
    public static void main(String[] args) {
        Console cons = System.console();
        if (cons != null) {
            String userName = cons.readLine("User name: ");
            char[] password = cons.readPassword("Password: ");
            System.out.println("User name: " + userName);
            System.out.println("Password: " + String.valueOf(password));
        } else {
            System.out.println("cons为null");
        }
    }
}
