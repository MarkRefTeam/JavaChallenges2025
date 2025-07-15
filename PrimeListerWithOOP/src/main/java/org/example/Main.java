package org.example;

import org.example.implementation.NaivePrimeLister;
import org.example.implementation.SievePrimeLister;
import org.example.implementation.SqrtPrimeLister;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        PrimeLister naiveLister = new NaivePrimeLister();
        PrimeLister sieveLister = new SievePrimeLister();
        PrimeLister sqrtLister = new SqrtPrimeLister();

        List<Integer> primeNaive = naiveLister.generatePrimes(100);
        System.out.println("Naive up to 100: " + primeNaive);

        List<Integer> primeSieve = sieveLister.generatePrimes(100);
        System.out.println("Sieve up to 100: " + primeSieve);

        List<Integer> primeSqrt = sqrtLister.generatePrimes(100);
        System.out.println("Sqrt up to 100: " + primeSqrt);
    }
}
