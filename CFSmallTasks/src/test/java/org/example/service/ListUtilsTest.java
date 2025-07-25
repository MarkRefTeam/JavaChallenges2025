package org.example.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ListUtilsTest {

    @BeforeEach
    void setup() {
        ListUtils listUtils = new ListUtils();
    }

    @Test
    void testIntersectionOfTwoLists() {
        ListUtils list1 = new ListUtils();
        list1.add("a");
        list1.add("b");
        list1.add("c");
        list1.add("d");

        ListUtils list2 = new ListUtils();
        list2.add("b");
        list2.add("c");
        list2.add("e");

        List<String> expected = Arrays.asList("b", "c");
        List<String> result = list1.getIntersection(list2);

        assertEquals(expected, result);
    }

    @Test
    void testReverseWords() {
        ListUtils words = new ListUtils();
        words.add("alma");
        words.add("körte");
        words.add("barack");

        List<String> expected = Arrays.asList("amla", "etrök", "kcarab");
        List<String> result = words.reverseWords();
        assertEquals(expected, result);
    }

    @Test
    void testFindPalindromes() {
        ListUtils words = new ListUtils();
        words.add("kör");
        words.add("radar");
        words.add("anna");
        words.add("alma");

        List<String> expected = Arrays.asList("radar", "anna");
        List<String> result = words.findPalindromes();

        assertEquals(expected, result);
    }

    @Test
    void testCountUniqueChars() {
        ListUtils chars = new ListUtils();
        chars.buildListFromString("hello");

        int expected = 4;
        int result = chars.countUniqueChars();

        assertEquals(expected, result);
    }

    @Test
    void testHasDuplicates() {
        ListUtils listWithDuplicates = new ListUtils();
        listWithDuplicates.buildListFromIntegers(Arrays.asList(1, 2, 3, 3, 4));

        ListUtils listWithoutDuplicates = new ListUtils();
        listWithoutDuplicates.buildListFromIntegers(Arrays.asList(1, 2, 3, 4, 5));

        assertTrue(listWithDuplicates.hasDuplicates());
        assertFalse(listWithoutDuplicates.hasDuplicates());
    }
}