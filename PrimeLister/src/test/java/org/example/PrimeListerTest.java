package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PrimeListerTest {

    // This class tests whether the prime checking works correctly.

    @ParameterizedTest
    @CsvSource({
            // Test data: number, expected result
            "2, true",
            "3, true",
            "4, false",
            "5, true",
            "9, false",
            "11, true",
            "1, false"
    })

    void testIsPrime_withVariousInputs(int number, boolean expected) {
        // We call the isPrime method with the test number.
        boolean actual = PrimeLister.isPrime(number);

        // We verify that the result matches the expected value.
        assertEquals(expected, actual);
    }

    /**
     * Generates all prime numbers up to n.
     * Time complexity: O(n * sqrt(n))
     */

    @ParameterizedTest
    @CsvSource({
            "1, ''",
            "2, 2",
            "5, '2,3,5'",
            "10, '2,3,5,7'"})

    void testGeneratePrimes (int n, String expectedCsv) {
        String[] parts = expectedCsv.split(",");
        List<Integer> expected = new ArrayList<>();
        for (String part : parts) {
            if(!part.trim().isEmpty()) {
                expected.add(Integer.parseInt(part));
            }
        }
        List<Integer> actual = PrimeLister.generatePrimes(n);
        assertEquals(expected, actual);
    }
}
