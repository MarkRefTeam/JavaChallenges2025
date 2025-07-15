package org.example.implementation;

import org.example.PrimeLister;

import java.util.ArrayList;
import java.util.List;

public class NaivePrimeLister implements PrimeLister {

    @Override
    public List<Integer> generatePrimes(int max) {
        List<Integer> primes = new ArrayList<>();

        for (int i = 2; i <= max; i++) {
            boolean isPrime = true;
            for (int j = 2; j < i; j++) {
                if(i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if(isPrime) {
                primes.add(i);
            }
        }
        return primes;
    }
}
