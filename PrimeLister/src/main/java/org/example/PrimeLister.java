package org.example;

import java.util.ArrayList;
import java.util.List;

public class PrimeLister {

    // This method checks if the given number is a prime number.

    public static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }

        // Numbers less than 2 are not prime.

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }

        // If no divisors were found, the number is prime
        return true;
    }

    /**
     * Generates a list of prime numbers up to n.
     * Time complexity: O(n * sqrt(n))
     */

    public static List<Integer> generatePrimes(int n) {
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                primes.add(i);
            }
        }
        return primes;
    }

    /**
     * Yes , I remember Kriszti's presentation ,but it's a very hard part to me... :D
     * Here coming some extra task for learn it!
     */

    public static List<String> findPairWithSum10(int[] array) {
        List<String> pairs = new ArrayList<>();

        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] + array[j] == 10) {
                    pairs.add(array[i] + " + " + array[j] + " = 10");
                }
            }
        }
        return pairs;
    }

    /**
     * Here comeing some extra task for learning it!
     * I think im understand ,but we will see! :D :D
     */

    //Extra 1. (Practice)
    public static List<Integer> filterGreaterThan100(int[] array) {
        List<Integer> filtered = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 100) {
                filtered.add(array[i]);
            }
        }
        return filtered;
    }

    //Extra 2. (searching Even!)

    public static List<Integer> collectEvenNumbers(int[] array) {
        List<Integer> evenNumbers = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                evenNumbers.add(array[i]);
            }
        }
        return evenNumbers;
    }

    //Extra 3. (With Odd)

    public static List<Integer> collectOddNumbers(int[] array) {
        List<Integer> oddNumbers = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0) {
                oddNumbers.add(array[i]);
            }
        }
        return oddNumbers;
    }

    //Extra 4. O(log n)

    public static int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (array[mid] == target) {
                return mid;   //we found it!
            } else if (array[mid] < target) {
                left = mid + 1; //we're going right side!
            } else {
                right = mid - 1; //we're going left side!
            }
        }
        return -1;
    }

    //Extra 5. O(log n) with same logic!

    public static int countHalving(int start, int limit) {

        //int start = 100;
        //int limit = 5;    //Don't need definition again?

        int steps = 0;

        while (start > limit) {
            start = start / 2;
            steps++;
        }
        return steps;
    }

    //Extra 6. with boolean!

    public static boolean canBeDividedToOneInKSteps(int start, int k) {

        for (int i = 0; i < k; i++) {
            start = start / 2;
        }
        return start == 1;
    }
}
