package org.example;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Lottery {

    public static void main(String[] args) {

        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        Set<Integer> lotteryNumbers = new HashSet<>();
        while (lotteryNumbers.size() < 5) {
            int num = random.nextInt(90) + 1;
            lotteryNumbers.add(num);
        }

        System.out.println("Numbers Generated!");
        System.out.println("numbers: " + lotteryNumbers);

        Set<Integer> userNumbers = new HashSet<>();
        System.out.println("Give 5 numbers between 1 and 90");
        while (userNumbers.size() < 5) {
            System.out.print("Enter number: ");
            String line = scanner.nextLine();
            try {
                int input = Integer.parseInt(line.trim());
                if (input < 1 || input > 90) {
                    System.out.println("You should give a number between 1 and 90");
                    continue;
                }
                if (!userNumbers.add(input)) {
                    System.out.println("You used this number, you should choose another one!");
                }
            } catch (NumberFormatException e) {
                System.out.println("This is not a number, try again!");
            }
        }

        Set<Integer> matched = new HashSet<>(lotteryNumbers);
        matched.retainAll(userNumbers);

        System.out.println("Correct Numbers: " + matched);
        System.out.println("Correct Numbers found: " + matched.size());
    }
}
