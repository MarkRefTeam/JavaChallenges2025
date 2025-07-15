package org.example;

import org.example.implementation.SqrtPrimeLister;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SqrtPrimeListerTest {

    @Test
    void testSqrtPrimeLister() {
        PrimeLister sqrtLister = new SqrtPrimeLister();
        List<Integer> expectedPrimesUpTo10 = List.of(2,3,5,7);
        List<Integer> actualPrimes = sqrtLister.generatePrimes(10);
        assertEquals(expectedPrimesUpTo10, actualPrimes);
    }
}
