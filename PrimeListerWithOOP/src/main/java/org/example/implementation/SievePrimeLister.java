package org.example.implementation;

import org.example.PrimeLister;

import java.util.ArrayList;
import java.util.List;

public class SievePrimeLister implements PrimeLister {

    @Override
    public List<Integer> generatePrimes(int max) {
        List<Integer> primes = new ArrayList<>();

        boolean[] isPrime = new boolean[max + 1];
        for (int i = 2; i <= max; i++) {
            isPrime[i] = true;
        }
        for (int i = 2; i * i <= max; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= max; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        for (int i = 2; i <= max; i++) {
            if(isPrime[i]) {
                primes.add(i);
            }
        }
        return primes;
    }
}