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
     * Checks if a number is prime.
     * Time complexity: O(sqrt(n))
     */

    public static List<Integer> generatePrimes(int n) {
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= n ; i++) {
            if (isPrime(i)) {
                primes.add(i);
            }
        }
        return primes;
    }
}
