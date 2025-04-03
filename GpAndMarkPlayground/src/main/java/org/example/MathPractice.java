package org.example;

public class MathPractice {


    public static boolean isPerfectSquare(int n) {
        double sqrt = Math.sqrt(n);
        return sqrt == Math.floor(sqrt);
    }

    public static boolean hasPairWithSum(int[] numbers, int target) {

        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    return true;
                }
            }
        }
        return true;
    }

    public static void comparePairs(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                if (numbers[i] > numbers[j]) {
                    System.out.println(numbers[i] + " > " + numbers[j]);
                }
            }

        }
    }

    public static void searchingDifferent(int[] numbers) {
        for (int number : numbers) {
            for (int j = 0; j < numbers.length; j++) {
                if (number > numbers[j]) {

                    System.out.println(number + " > " + numbers[j]);
                }
            }
        }
    }

    public static void isDivisbleBy(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                if (numbers[i] > numbers[j]) {
                    System.out.println(numbers[i] + " % " + numbers[j]);
                }
            }
        }
    }

    public static boolean isMultipleOf(int number, int divisor) {
        return number % divisor == 0;
    }

    //O(log n)

    public static short forwardSearch(int[] array, int target) {

        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                return (short) mid;
            } else if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static int shouldReturnFirstEven(int[] array) {
        int left = 0;
        int right = array.length;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] % 2 == 0) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;

    }

    public static int findSmallestEven(int[] array) {
        int minEven = Integer.MAX_VALUE;
        boolean found = false;

        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0 && array[i] < minEven) {
                minEven = array[i];
                found = true;
            }
        }
        return found ? minEven : -1;

    }

    public static boolean hasPairWithSum2(int[] array, int targetSum) {

        for (int i = 0; i < array.length; i++) {
            for (int j = 1; j < array.length; j++) {
                if (array[i] + array[j] == targetSum)
                    return true;
            }
        }
        return false;
    }

}