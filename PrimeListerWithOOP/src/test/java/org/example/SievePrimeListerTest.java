package org.example;

import org.example.implementation.SievePrimeLister;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SievePrimeListerTest {

    @Test
    void testSievePrimeLister() {
        PrimeLister sieveLister = new SievePrimeLister();
        List<Integer> expectedPrimesUpTo10 = List.of(2,3,5,7);
        List<Integer> actualPrimes = sieveLister.generatePrimes(10);
        assertEquals(expectedPrimesUpTo10, actualPrimes);
    }
}
