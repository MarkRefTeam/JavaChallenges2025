package org.example;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class App {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        //Writes your own name to the console!

        //1.Variation:
        System.out.println("Szöllősy Márk");

        //2.Variation:
        //Static Scanner!

        System.out.println("Enter your name");
        scanner.nextLine();

        //outputs:(percentages,strings,difference)

        System.out.println("Enter a number");
        int num = scanner.nextInt();
        scanner.nextLine();
        System.out.println("30% of your number is: " + getThirtyPercent(num));
        System.out.println("42.8 of your number is: " + getFortyDotEightPercent(num));

        String[] names = {"Márk", "Ancsa", "GP"};
        String result = returnEmptyString(names);
        System.out.println("Returned string:" + result + "'");

        System.out.println("Enter a sentence:");
        String input = scanner.nextLine();
        System.out.println("Double length is: " + getDoubleLength(input));

        System.out.println("Enter your first number: ");
        int num1 = scanner.nextInt();

        System.out.println("Enter the second number: ");
        int num2 = scanner.nextInt();
        scanner.nextLine();

        int difference = getDifference(num1, num2);
        System.out.println("You need to add " + difference + "to the first number to get second");

        System.out.println("Give a text");
        String text = scanner.nextLine();
        System.out.println("The square root is :" + getSquareRootOfLength(text));

        System.out.println(getFactorialOfLength("Hello :D"));

        System.out.println("100 divided by 25 is: " + divide100ByNumber(25));

        //Test:

        System.out.println("Result: " + evaluateNumber(7));
        System.out.println("Result: " + evaluateNumber(8));
        System.out.println("Result: " + evaluateNumber(9));
        System.out.println("Result: " + evaluateNumber(10));
        System.out.println("Result: " + evaluateNumber(15));

        String[] words = {"Alpha", "Beta", "Omega"};
        System.out.println("Lengths : + " + Arrays.toString(getLengths(words)));

        //No, I don't know that...Someone helped me about this task!

        System.out.println("Give information about your brute ");
        int brute = scanner.nextInt();

        System.out.println("Your netto payment is : " + netto(brute) + "HUF");

        boolean[] array = {true, false, true};
        System.out.println("Your Xor value is: " + hasXorInPseudo(array));

        int[] testArray = {3, -1, 0, -7, 5, -3};
        System.out.println("Negative numbers: " + Arrays.toString(getNegativeNumbers(testArray)));


        scanner.close();

        //Writes a welcome message to the console!

        System.out.println("Welcome");
        System.out.println();
        System.out.println("Thank you for checking my homework");
        System.out.println();
    }

    //Gets in a number and returns its 30%!

    public static double getThirtyPercent(int num) {
        return num * 0.3;
    }

    //Gets in an array of Strings and returns an empty String!

    public static String returnEmptyString(String[] inputArray) {
        return "";
    }

    //Gets in a number and returns its 42.8%

    public static double getFortyDotEightPercent(int num) {
        return num * 0.42;
    }

    //Gets in a String and returns the double of its length!

    public static int getDoubleLength(String input) {
        return input.length() * 2;
    }

    //Gets in two numbers and returns how much you would need
    //to add to the first number to get the second one!

    public static int getDifference(int first, int second) {
        return second - first;
    }

    //Gets in a String and returns the square root of its length!

    public static double getSquareRootOfLength(String input) {
        int length = input.length();
        return Math.sqrt(length);
    }

    //Gets in a String and returns the factorial of its length!

    public static int getFactorialOfLength(String input) {
        int length = input.length();
        int result = 1;
        for (int i = 1; i < length; i++) {
            result *= i;
        }
        return result;
    }

    //Gets in a number and returns 100 divided by that number!

    public static double divide100ByNumber(int number) {
        if (number == 0) {
            System.out.println("Cannot divide by zero.");
            return 0;
        }
        return 100.0 / number;
    }

    /**
     * Gets in a number and …
     * a) returns the square of it if it is prime.
     * b) returns the double of it if it is not a prime and divisible by 4.
     * c) returns the triple of it if it is not a prime and not divisible by 4.
     */

    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i < Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }


    public static int evaluateNumber(int number) {
        if (App.isPrime(number)) {
            return number * number;
        } else if (number % 4 == 0) {
            return number * 2;
        } else {
            return number * 3;
        }
    }

    //Gets in an array of Strings and returns a new array
    // of numbers of each String’s length!

    public static int[] getLengths(String[] words) {
        int[] lengths = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            lengths[i] = words[i].length();
        }
        return lengths;
    }

    /**
     * Gets in a gross salary and calculates the net salary according to the Hungarian rules in the following way:
     * - deduces 15% as SZJA (personal income tax) and 18.5% as TBJ (social security tax).
     * - the remaining amount is going to be the net salary.
     * - So if someone earns 100 000 HUF gross per month, their net salary is going to be 66500 HUF.
     * - Use separate methods to calculate SZJA and TBJ.
     */

    //I couldn't do this alone, I used help for this!
    public static double szja(int brute) {
        return brute * 0.15;
    }

    public static double tbj(int brute) {
        return brute * 0.185;
    }

    public static double netto(int brute) {
        return brute - szja(brute) - tbj(brute);
    }

    /**
     * Or you have a better way for this math exam! All in one!
     * Let's see this!
     * <p>
     * I import a scanner if we talk about a new program!
     * So, how do I mean?
     */

    //public class SalaryCalculator {

    //static Scanner scanner = new Scanner(System.in);

    //public static void main(String[] args) {
    //        System.out.print("Add meg a brute payment (HUF): ");
    //        int brute = scanner.nextInt();

    //double nettoPayment = calculateNetto(brute);

    //System.out.println("A netto payment is: " + nettoPayment + " HUF");
    // }

    //public static double calculateSZJA(int brute) {
    //return brute * 0.15;
    //}

    //public static double calculateTBJ(int brute) {
    //return brute * 0.185;
    //}

    //It's same right? Check now!

    //public static double calculateNetto(int brute) {
    //        double szja = calculateSZJA(brute);
    //        double tbj = calculateTBJ(brute);
    //        return brute - szja - tbj;
    //    }
    //}

    //I'm doing more practices/extra tasks for this!(Interesting exam)


    //Gets in an array of booleans and returns a1 XOR a2 XOR a3 … XOR an.

    //false ^ true -> true
    //true ^ true -> false
    //false ^ false -> false
    //false ^ true -> true
    public static boolean hasXorInPseudo(boolean[] array) {
        boolean result = false;
        for (boolean value : array) {
            result ^= value;
        }
        return result;
    }

    //Gets in an array of numbers and returns a new array
    // with all the negative numbers in from the original array!

    public static int[] getNegativeNumbers(int[] numbers) {
        List<Integer> negatives = new ArrayList<>();

        for (int number : numbers) {
            if (number < 0) {
                negatives.add(number);
            }
        }

        int[] result = new int[negatives.size()];
        for (int i = 0; i < negatives.size(); i++) {
            result[i] = negatives.get(i);
        }
        return result;
    }
}
