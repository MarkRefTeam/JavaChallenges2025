package org.example;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class App {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        printName();

        //2.Variation:
        //Static Scanner!

        System.out.println("Enter your name");
        scanner.nextLine();

        //outputs:(percentages,strings,difference)

        System.out.println("Enter a number");
        int num = scanner.nextInt();
        scanner.nextLine();
        System.out.println("30% of your number is: " + getThirtyPercent(num));
        System.out.println("42.8 of your number is: " + getFortyTwoDotEightPercent(num));

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

        System.out.println("Give information about your gross ");
        int gross = scanner.nextInt();

        System.out.println("Your net payment is : " + net(gross) + "HUF");

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

    public static void printName() {

        //Writes your own name to the console!

        //1.Variation:
        System.out.println("Szöllősy Márk");

    }

    //Gets in a number and returns its 30%!

    public static double getThirtyPercent(int num) {
        return num * 0.3;

        /**
         * Calculates 30% of the given number.
         * @param num the input number
         * @return 30% of the input value
         */
    }

    //Gets in an array of Strings and returns an empty String!

    public static String returnEmptyString(String[] inputArray) {
        return "";

        /**
         * Returns an empty string regardless of the input.
         * @param inputArray an array of strings (ignored)
         * @return an empty string
         */
    }

    //Gets in a number and returns its 42.8%

    public static double getFortyTwoDotEightPercent(int num) {
        return Math.round(num * 0.428);

        /**
         * Returns 42.8% of the given number.
         * @param num the input number
         * @return 42.8% of num
         */
    }

    //Gets in a String and returns the double of its length!

    public static int getDoubleLength(String input) {
        return input.length() * 2;

        /**
         * Returns twice the length of the given string.
         * @param input the input string
         * @return double the length of the input
         */

    }

    //Gets in two numbers and returns how much you would need
    //to add to the first number to get the second one!

    public static int getDifference(int first, int second) {
        return second - first;

        /**
         * Calculates how much you need to add to the first number
         * to get the second one.
         * @param first the starting number
         * @param second the target number
         * @return the difference (second - first)
         */
    }

    //Gets in a String and returns the square root of its length!

    public static double getSquareRootOfLength(String input) {
        return Math.sqrt(input.length());

        /**
         * Returns the square root of the input string's length.
         * @param input the input string
         * @return square root of the input's length
         */

    }

    //Gets in a String and returns the factorial of its length!

    public static int getFactorialOfLength(String input) {
        int length = input.length();
        int result = 1;
        for (int i = 1; i <= length; i++) {    //I hope you mean this one, right?
            result *= i;
        }
        return result;

        /**
         * Calculates the factorial of the input string's length.
         * For example, if the string length is 4, it returns 4 * 3 * 2 * 1 = 24.
         * @param input the input string
         * @return factorial of the string's length
         */
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
        for (int i = 2; i <= Math.sqrt(number); i++) {   //Yes, you are right! " <= " Thanks!
            if (number % i == 0) {
                return false;
            }
        }
        return true;

        /**
         * Checks whether a given number is a prime number.
         * A number is prime if it is greater than 1 and divisible only by 1 and itself.
         *
         * @param number the number to check
         * @return true if the number is prime, false otherwise
         */

    }


    public static int evaluateNumber(int number) {
        if (App.isPrime(number)) {
            return number * number;
        } else if (number % 4 == 0) {
            return number * 2;
        } else {
            return number * 3;
        }

        /**
         * Evaluates a number based on three conditions:
         * a) If the number is prime, returns its square
         * b) If not prime but divisible by 4, returns its double
         * c) Otherwise, returns its triple
         *
         * @param number the input number
         * @return evaluated result based on the described logic
         */

    }

    //Gets in an array of Strings and returns a new array
    // of numbers of each String’s length!

    public static int[] getLengths(String[] words) {
        int[] lengths = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            lengths[i] = words[i].length();
        }
        return lengths;

        /**
         * Gets an array of strings and returns an array of integers
         * representing the length of each string.
         *
         * @param words an array of strings
         * @return an array of integers containing each string's length
         */

    }

    /**
     * Gets in a gross salary and calculates the net salary according to the Hungarian rules in the following way:
     * - deduces 15% as SZJA (personal income tax) and 18.5% as TBJ (social security tax).
     * - the remaining amount is going to be the net salary.
     * - So if someone earns 100 000 HUF gross per month, their net salary is going to be 66500 HUF.
     * - Use separate methods to calculate SZJA and TBJ.
     */

    //I couldn't do this alone, I used help for this!
    public static double szja(int gross) {
        return gross * 0.15;

        /**
         * Calculates 15% tax from the given gross income.
         *
         * @param gross the gross income
         * @return 15% of the gross value
         */

    }

    public static double tbj(int gross) {
        return gross * 0.185;

        /**
         * Calculates 18.5% tax from the given gross income.
         *
         * @param gross the gross income
         * @return 18.5% of the gross value
         */

    }

    public static double net(int gross) {
        return gross - szja(gross) - tbj(gross);

        /**
         * Calculates the net income after applying SZJA and TBJ deductions.
         *
         * @param gross the gross income
         * @return the net income after deductions
         */

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
    //        System.out.print("Add meg a gross payment (HUF): ");
    //        int gross = scanner.nextInt();

    //double netPayment = calculateNet(gross);

    //System.out.println("A net payment is: " + netPayment + " HUF");
    // }

    //public static double calculateSZJA(int gross) {
    //return gross * 0.15;
    //}

    //public static double calculateTBJ(int gross) {
    //return gross * 0.185;
    //}

    //It's same right? Check now!

    //public static double calculateNet(int gross) {
    //        double szja = calculateSZJA(gross);
    //        double tbj = calculateTBJ(gross);
    //        return gross - szja - tbj;
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

        /**
         * Evaluates XOR operation on all elements in the boolean array.
         *
         * @param array an array of boolean values
         * @return the result of XOR-ing all values
         */

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

    /**
     * Filters the input array and returns only the negative numbers.
     *
     * @param numbers the array of integers to filter
     * @return a new array containing only negative numbers
     */

}
