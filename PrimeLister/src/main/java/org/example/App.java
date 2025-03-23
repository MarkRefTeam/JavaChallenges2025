package org.example;

import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        run(scanner);
    }

    public static void run(Scanner scanner) {
        int max = getUserInput(scanner);
        if (max == -1) return;

        List<Integer> squares = SquareNumberLister.generateSquares(max);
        System.out.println("Perfect squares from 1 to " + max + ":");

        for (int square : squares) {
            String label = PrimeLister.isPrime(square) ? " (prime)" : "";
            System.out.println(square + label);
        }
    }

    private static int getUserInput(Scanner scanner) {
        int attempts = 0;

        //Count the number of input attempts, max 5 allowed

        while (attempts < 5) {
            System.out.print("Enter a number between 2 and 2000000000: ");
            String input = scanner.nextLine();

            //Ask the user for input.

            try {
                int max = Integer.parseInt(input);
                if (max >= 2 && max <= 2_000_000_000) {
                    return max;

                    //Validate if the number is between 2 and 2,000,000,000.

                } else {
                    System.out.println("Number out of range.");
                }

                //Print error if the number is out of range.

            } catch (NumberFormatException e) {
                System.out.println("Invalid input.");
            }

            //Catch exception if the input is not a number.
            attempts++;
        }

        System.out.println("Too many invalid attempts. Exiting.");
        return -1;

        //If 5 invalid attempts, exit with -1 return value.
    }

    // This method returns all perfect squares as a formatted String

    public static String formatSquares(List<Integer> squares, int max) {
        StringBuilder sb = new StringBuilder();
        sb.append("Perfect squares from 1 to ").append(max).append(":\n");

        // Append a note if the number is prime

        for (int square : squares) {
            String label = PrimeLister.isPrime(square) ? " (prime)" : "";

            // Append number + label in a new line

            sb.append(square).append(label).append("\n");
        }

        return sb.toString().trim();
    }
}
