package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.example.MathPractice.findSmallestEven;
import static org.example.MathPractice.shouldReturnFirstEven;

public class MathPracticeTest {

    @Test
    void testIsPerfectSquare() {


        Assertions.assertTrue(MathPractice.isPerfectSquare(49));
        Assertions.assertFalse(MathPractice.isPerfectSquare(50));
        Assertions.assertTrue(MathPractice.isPerfectSquare(1));
        Assertions.assertTrue(MathPractice.isPerfectSquare(0));
        Assertions.assertFalse(MathPractice.isPerfectSquare(-4));
        Assertions.assertFalse(MathPractice.isPerfectSquare(2));
        Assertions.assertFalse(MathPractice.isPerfectSquare(15));

        System.out.println("All square root tests passed 💪");
    }

    @Test
    void testHasPairWithSum() {

        Assertions.assertTrue(MathPractice.hasPairWithSum(new int[]{2, 4, 6, 1, 9}, 10));
        Assertions.assertTrue(MathPractice.hasPairWithSum(new int[]{1, 2, 3}, 10));
    }

    @Test
    void testComparePairs() {

        int[] numbers = {4, 7, 2, 5};
        MathPractice.comparePairs(numbers);
    }

    @Test
    void testSearchingDifferent() {

        int[] numbers = {10, 3, 5, 8};
        MathPractice.searchingDifferent(numbers);

    }

    @Test
    void testIsDivisibleBy() {

        int[] numbers = {2, 4, 6, 3, 12};
        MathPractice.isDivisbleBy(numbers);
    }

    @Test
    void testIsMultipleOf() {

        System.out.println((MathPractice.isMultipleOf(12, 3)));

        Assertions.assertTrue((MathPractice.isMultipleOf(12, 3)));
    }

    @Test
    void testForwardSearch() {

        int[] array = {1, 3, 5, 7, 9, 11};

        Assertions.assertEquals(2, MathPractice.forwardSearch(array, 5));
        Assertions.assertEquals(5, MathPractice.forwardSearch(array, 11));
        Assertions.assertEquals(-1, MathPractice.forwardSearch(array, 8));

    }

    @Test
    void testShouldReturnFirstEven() {

        int[] array = {1, 3, 5, 6, 7, 9};


        Assertions.assertEquals(3, MathPractice.shouldReturnFirstEven(array));
    }

    @Test
    void testFindsmallestEven() {

        int[] array = {7, 3, 10, 6, 9};

        Assertions.assertEquals(6, MathPractice.findSmallestEven(array));

    }

    @Test
    void testHasPairWithSum2() {

        int[] array = {1, 4, 6, 2, 9};
        int targetSum = 10;


        System.out.println(targetSum);

        Assertions.assertTrue(MathPractice.hasPairWithSum2(array, 10));

    }
}
