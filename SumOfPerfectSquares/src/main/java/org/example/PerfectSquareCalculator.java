package org.example;

public class PerfectSquareCalculator {

    public static int points = 0;

    public static int calculatePerfectSquareSum(int num) {


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

    public static boolean perfectSquareCalculator(int number) {
        if (number < 0) return false;

        //1.Variation!

        double sqrt = Math.sqrt(number);
        return sqrt == Math.floor(sqrt);
    }

    //I'm not sure about this, but I think you mean this right?

    // or!

    public static boolean isPerfectSquare(int number) {
        if (number < 0) return false;

        //2.Variation!

        int sqrt = (int) Math.sqrt(number);
        return sqrt * sqrt == number;
    }
}