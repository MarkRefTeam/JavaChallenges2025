package org.example;

import org.junit.jupiter.api.Assertions;
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
    void testGeneratePrimes(int n, String expectedCsv) {
        String[] parts = expectedCsv.split(",");
        List<Integer> expected = new ArrayList<>();
        for (String part : parts) {
            if (!part.isEmpty()) {
                expected.add(Integer.parseInt(part));
            }
        }
        List<Integer> actual = PrimeLister.generatePrimes(n);
        assertEquals(expected, actual);
    }

    @Test
    void testShouldFindPairsWithSum10() {
        int[] input = {1, 2, 8, 3, 7, 9, 4, 6};
        List<String> expected = List.of("1 + 9 = 10", "2 + 8 = 10", "3 + 7 = 10", "4 + 6 = 10");
        List<String> result = PrimeLister.findPairWithSum10(input);

        Assertions.assertEquals(expected, result);
    }

    @Test
    void testShouldReturnNumbersGreaterThan100() {
        int[] input = {90, 101, 120, 5, 99, 150};
        List<Integer> expected = List.of(101,120,150);

        List<Integer> result = PrimeLister.filterGreaterThan100(input);

        Assertions.assertEquals(expected,result);
    }

    @Test
    void testCollectEvenNumbers() {
        int[] input = {1,2,3,4,5,6,7,8,9,10};
        List<Integer> expected = List.of(2,4,6,8,10);

        List<Integer> result = PrimeLister.collectEvenNumbers(input);
        Assertions.assertEquals(expected,result);
    }

    @Test
    void testCollectOddNumbers() {
        int[] input = {1,2,3,4,5,6,7,8,9,10};
        List<Integer> expected = List.of(1,3,5,7,9);

        List<Integer> result = PrimeLister.collectOddNumbers(input);
        Assertions.assertEquals(expected,result);
    }

    @Test
    void testBinarySearch() {
        int[] input = {1,3,5,7,9,11,13,15};
        int target = 13;
        int expected = 6;

        int result = PrimeLister.binarySearch(input,target);
        Assertions.assertEquals(expected,result);
    }

    @Test
    void testCountHalvings() {
        int start = 100;
        int limit = 5;
        int expected = 5;

        int result = PrimeLister.countHalving(start,limit);
        Assertions.assertEquals(expected,result);
    }

    @Test
    void testCanBeDividedToOneInKSteps() {
        int start = 64;
        int k = 6;

        boolean result = PrimeLister.canBeDividedToOneInKSteps(start, k);
        Assertions.assertTrue(result);
    }

}
