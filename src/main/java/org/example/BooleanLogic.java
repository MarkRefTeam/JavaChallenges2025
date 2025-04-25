package org.example;

import java.util.Scanner;

public class BooleanLogic {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Give a number");
        int numberInput = sc.nextInt();
        sc.nextLine();

        System.out.println("Now give a word: ");
        String wordInput = sc.nextLine();

        System.out.println("choose a check:");
        System.out.println("1 - Is Even?");
        System.out.println("2 - Is Divisible by 3?");
        System.out.println("3 - Is Three Digits?");
        System.out.println("4 - Is Positive and Three Digits?");
        System.out.println("5 - Run All Checks");
        System.out.println("6 - Math Logic");

        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Even: " + isEven(numberInput));
                break;
            case 2:
                System.out.println("Divisible by 3: " + hasDivisibleBy3(numberInput));
                break;
            case 3:
                System.out.println("Three digits: " + isThreeDigits(numberInput));
                break;
            case 4:
                System.out.println("Positive and three digits: " + isPositiveAndThreeDigits(numberInput));
                break;
            case 5:
                System.out.println("All checks passed: " + passesAllCheck(numberInput));
                break;
            case 6:
                System.out.println("Give a base number:");
                double base = sc.nextDouble();
                System.out.println("Give an exponent:");
                double exponent = sc.nextDouble();
                System.out.println("Math logic result: " + isRoundedPowerGreaterThan100(base, exponent));
                break;
            default:
                System.out.println("Invalid choice.");
        }

        sc.close();

        checkNumberLogic(numberInput);
        checkWordLogic(wordInput);
        passesAllCheck(numberInput);

        System.out.println(isNegative(-5));
        System.out.println(isLevelBiggerThan10(10, 100));
        System.out.println(isLongerThan5WithAAndE("apple"));
        System.out.println(hasEvenAndDivisibleBy5(150));
        System.out.println(isPositiveAndThreeDigits(100));
        System.out.println(isPositiveAndThreeDigits(256));
        System.out.println(isPositiveAndThreeDigits(998));
        System.out.println(isPositiveAndThreeDigits(-120));
        System.out.println(isPositiveAndThreeDigits(5));
        System.out.println(isPositiveAndThreeDigits(1000));
        System.out.println(isOdd(-5));
        System.out.println(isPositive(6));
        System.out.println(hasUpperCase("Kajak"));
        System.out.println(hasDivisibleBy3(9));
        System.out.println(isThreeDigits(120));
    }

    //for numbers:

    public static void checkNumberLogic(int number) {

        if (isEven(number)) {
            System.out.println(number + " is even.");
        } else {
            System.out.println(number + " is odd.");
        }
    }

    //for words:

    public static void checkWordLogic(String word) {

        if (isPalindrome(word)) {
            System.out.println("\"" + word + "\" palindrome word");
        } else {
            System.out.println("\"" + word + "\" is Not a palindrome!");
        }
    }

    public static boolean passesAllCheck(int number) {

        boolean isValid = true;

        if (isEven(number)) {
            isValid = true;
        }
        if (hasDivisibleBy3(number)) {
            isValid = true;
        }
        if (isThreeDigits(number)) {
            isValid = true;
        }
        if (!isEven(number)) {
            isValid = false;
        }
        return isValid;
    }

    public static boolean isRoundedPowerGreaterThan100(double base, double exponent) {
        double result = Math.pow(base, exponent);
        return Math.floor(result) > 100;
    }

    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    public static boolean isOdd(int number) {
        return number % 2 != 0;
    }

    public static boolean isPositive(int number) {
        return number > 0;
    }

    public static boolean isNegative(int number) {
        return number < 0;
    }

    public static boolean isLevelBiggerThan10(int level, int xp) {
        return level >= 10 && xp >= 100;
    }

    public static boolean isLongerThan5WithAAndE(String word) {
        return word.length() > 5 && (word.contains("a") || word.contains("e"));
    }

    public static boolean hasEvenAndDivisibleBy5(int number) {
        return number % 2 == 0 && number % 5 == 0;
    }

    public static boolean hasDivisibleBy3(int number) {
        return number % 3 == 0;
    }

    public static boolean isPositiveAndThreeDigits(int number) {
        return number > 0 && number >= 100 && number <= 999;
    }

    public static boolean isThreeDigits(int number) {
        return number >= 100 && number <= 999;
    }

    public static boolean isPalindrome(String text) {
        String reversed = new StringBuilder(text).reverse().toString();
        return text.equalsIgnoreCase(reversed);
    }

    public static boolean hasUpperCase(String text) {
        for (char c : text.toCharArray()) {
            if (Character.isUpperCase(c)) {
                return true;
            }
        }
        return false;
    }

}
