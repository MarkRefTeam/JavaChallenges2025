package org.example;

public class PerfectSquareCalculator {

    public static int points = 0;

    public static int CalculatePerfectSquareSum(int num) {


        if (num < 1) {
            System.out.println("Invalid input , Please enter a number greater than or equal to 1.");
            return -1;
        }

        int sum = 0;
        for (int i = 1; i <= num; i++) {
            sum += i * i;
        }
        return sum;
    }

    public static boolean PerfectSquareCalculator(int number) {
        if (number < 2) return false;

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i * i == 0) {
                return false;
            }
        }
        return true;
    }
}