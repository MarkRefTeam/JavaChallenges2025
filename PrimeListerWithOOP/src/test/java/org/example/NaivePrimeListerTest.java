package org.example;

import org.example.implementation.NaivePrimeLister;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NaivePrimeListerTest {

    @Test
    void testNaivePrimeLister() {
        PrimeLister naiveLister = new NaivePrimeLister();
        List<Integer> expectedPrimesUpTo10 = List.of(2,3,5,7);
        List<Integer> actualPrimes = naiveLister.generatePrimes(10);
        assertEquals(expectedPrimesUpTo10, actualPrimes);
    }
}
