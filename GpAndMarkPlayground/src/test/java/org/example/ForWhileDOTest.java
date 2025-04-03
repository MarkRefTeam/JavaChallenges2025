package org.example;

import org.junit.jupiter.api.Test;
import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

import static org.example.App.FindClosestLowerOdd;
import static org.example.ForWhileDO.*;
import static org.junit.jupiter.api.Assertions.*;

public class ForWhileDOTest {

    @Test
    public void testSumWithForLoop() {
        int result = ForWhileDO.sumWithForLoop(5);
        assertEquals(55, result);
    }

    @Test
    public void testsumWithWhileLoop() {
        int result = ForWhileDO.sumWithWhileLoop(5);
        assertEquals(15, result);
    }

    @Test
    public void testSumWithDoWhileLoop() {
        int result = ForWhileDO.sumWithDoWhileLoop(5);
        assertEquals(15, result);
    }

    @Test
    public void testsumEvenNumbers() {
        int result = ForWhileDO.sumEvenNumbers(10);
        assertEquals(30, result);
    }

    @Test
    public void youMustUnderstand() {
        int result = ForWhileDO.youMustUnderstand(10);
        assertEquals(30, result);
    }

    @Test
    public void calculateSomething() {
        int result = ForWhileDO.calculateSomething(6);
        assertEquals(21, result);
    }

    @Test
    public void calculateSomethingElse() {
        int result = ForWhileDO.calculateSomething2(8);
        assertEquals(36, result);
    }

    @Test
    public void youCanDoIt() {
        int result = ForWhileDO.sumDivisibleByThree(73);
        assertEquals(900, result);
    }

    @Test
    public void SkipMultiplesOfSix() {
        int result = ForWhileDO.sumSkipMultiplesOfSix();
        assertEquals(174, result);
    }

    @Test
    public void testSumSkippingSixMultiples() {
        int result = ForWhileDO.sumSkippingSixMultiples(30);
        assertEquals(375, result);
    }

    @Test
    public void testSumOddNotDivisibleByFive() {
        int result = ForWhileDO.sumOddNotDivisibleByFive(50);
        assertEquals(500, result);
    }

    @Test
    public void testSumSpecialNumbers() {
        int result = ForWhileDO.SumSpecialNumbers(50);
        assertEquals(650, result);
    }

    @Test
    public void testCalculateCrazyCombo() {
        int result = ForWhileDO.calculateCrazyCombo(40);
        assertEquals(258, result);
    }

    @Test
    public void testHasEvenDivisibleByThree() {
        int[] list1 = {1, 4, 7, 9};
        int[] list2 = {2, 6, 11};

        System.out.println(hasEvenDivisibleByThree(list1));
        System.out.println(hasEvenDivisibleByThree(list2));
    }

    @Test
    public void testHasNegativeDivisibleByFour() {
        int[] list1 = {-1, -4, -8, 9};
        int[] list2 = {2, -6, -12, 0};

        System.out.println(hasNegativeDivisibleByFour(list1));
        System.out.println(hasNegativeDivisibleByFour(list2));
    }

    @Test
    public void testHasEvenDivisibleByTwo() {
        int[] list1 = {8, 16, 22, 42};
        int[] list2 = {12, 18, 26, 52};

        //1. variation :

        System.out.println(hasEvenDivisibleByTwo(list1));
        System.out.println(hasEvenDivisibleByTwo(list2));

        //2. variation :

        assertTrue(hasEvenDivisibleByTwo(list1));
        assertTrue(hasEvenDivisibleByTwo(list2));
    }

    @Test
    public void testHasDivisibleByTwoOrThree() {
        int[] list1 = {9, 22, 63, 81};
        int[] list2 = {2, 3, 14, 36};

        System.out.println(hasDivisibleByTwoOrThree(list1));
        System.out.println(hasDivisibleByTwoOrThree(list2));
    }

    @Test
    public void testFindFirstDivisibleByThree() {
        int[] list1 = {1, 2, 3, 4, 5};
        int[] list2 = {6, 7, 8, 9, 10};

        System.out.println(findFirstDivisibleByThree(list1));
        System.out.println(findFirstDivisibleByThree(list2));
    }

    @Test
    public void testFindFirstEvenNotDivisibleByThree() {
        int[] list1 = {1, 2, 3, 4, 5};
        int[] list2 = {6, 7, 8, 9, 10};

        System.out.println(findFirstEvenNotDivisibleByThree(list1));
        System.out.println(findFirstEvenNotDivisibleByThree(list2));
    }

    @Test
    public void testHasFindFirstEvenNotDivisibleByThree2() {
        int[] list1 = {1, 2, 3, 4, 5};
        int[] list2 = {6, 7, 8, 9, 10};

        System.out.println(hasFindFirstEvenNotDivisibleByThree2(list1));
        System.out.println(hasFindFirstEvenNotDivisibleByThree2(list2));


    }

    @Test
    public void testHasEvenGreaterThanTen() {
        int[] list1 = {1, 3, 7, 9};
        int[] list2 = {5, 10, 12};
        int[] list3 = {22, 4, 8};
        int[] list4 = {10};

        System.out.println(hasEvenGreaterThanTen(list1));
        System.out.println(hasEvenGreaterThanTen(list2));
        System.out.println(hasEvenGreaterThanTen(list3));
        System.out.println(hasEvenGreaterThanTen(list4));


    }

    @Test
    public void testFindMaxOdd() {
        int[] list1 = {1, 2, 3, 4, 5};

        System.out.println(FindMaxOdd(list1));
    }


}






