package org.example.implementation;

import org.example.PrimeLister;

import java.util.ArrayList;
import java.util.List;

public class SqrtPrimeLister implements PrimeLister {

    @Override
    public List<Integer> generatePrimes(int max) {
        List<Integer> primes = new ArrayList<>();
        if (max < 2) {
            return primes;
        }

        for (int num = 2; num <= max; num++) {
            boolean isPrime = true;
            double sqrt = Math.sqrt(num);
            for (int div = 2; div <= sqrt; div++) {
                if (num % div == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                primes.add(num);
            }
        }
        return primes;
    }
}
