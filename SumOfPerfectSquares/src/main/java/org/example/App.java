package org.example;

import java.util.Scanner;
import java.util.*;

import static org.example.PerfectSquareCalculator.points;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<Integer> usedNumbers = new HashSet<>();
        int totalPoints = 0;


        while (true) {
            System.out.print("Enter a number (0 to exit): ");
            int number = sc.nextInt();

            if (number == 0) {
                System.out.println("Thanks for playing! Your total points: " + totalPoints);
                break;
            }

            if (usedNumbers.contains(number)) {
                System.out.println("This number was already used, don't cheat please!");
                continue;
            }
            if (number == 42) {
                System.out.println("Congratulation, You found the answer to life, the universe and everything!");
                points += 3;
            } else if (number == 69) {
                System.out.println("Nice :D");
                points += 2;
            } else if (number == 7) {
                System.out.println("Yes you are Lucky");
                points += 3;
            } else if (number == 13) {
                System.out.println("Unlike number you should repeat!");
                points -= 1;
            }

            usedNumbers.add(number);

            boolean result = PerfectSquareCalculator.perfectSquareCalculator(number);

            if (result) {
                int sum = PerfectSquareCalculator.calculatePerfectSquareSum(number);
                System.out.println("Sum of perfect squares up to " + number + " is " + sum);
                System.out.println("You earned " + points + " points!");
                totalPoints += points;
            } else {
                System.out.println(number + " is NOT valid based on the rules.");
            }
        }
        sc.close();
    }
}
