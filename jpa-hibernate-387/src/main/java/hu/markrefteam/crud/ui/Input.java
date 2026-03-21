package hu.markrefteam.crud.ui;

import java.util.Scanner;

public class Input {
    private final Scanner sc;

    public Input(Scanner sc) {
        this.sc = sc;
    }

    public String readLine(String prompt) {
        System.out.print(prompt);
        return sc.nextLine().trim();
    }

    public int readInt(String prompt) {
        while (true) {
            String s = readLine(prompt);
            try {
                return Integer.parseInt(s);
            } catch (NumberFormatException e) {
                System.out.println("You must choose a number, try again");
            }
        }
    }

    public Integer readNullableInt(String prompt) {
        String s = readLine(prompt + " (Enter = empty): ");
        if (s.isBlank()) return null;
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            System.out.println("Its not a number , it will be empty.");
            return null;
        }
    }
}