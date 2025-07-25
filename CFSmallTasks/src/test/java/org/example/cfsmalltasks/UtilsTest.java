package org.example.cfsmalltasks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UtilsTest {

    private Utils utils;

    @BeforeEach
    void setup() {
        utils = new Utils();
    }

    @Test
    void testIntersectionOfTwoLists() {
        List<String> list1 = Arrays.asList("a", "b", "c", "d");
        List<String> list2 = Arrays.asList("b", "c", "e");
        List<String> expected = Arrays.asList("b", "c");

        List<String> result = utils.getIntersection(list1, list2);
        assertEquals(expected, result);
    }

    @Test
    void testReverseWords() {
        List<String> words = Arrays.asList("alma", "körte", "barack");
        List<String> expected = Arrays.asList("amla", "etrök", "kcarab");

        List<String> result = utils.reverseWords(words);
        assertEquals(expected, result);
    }

    @Test
    void testFindPalindromes() {
        List<String> words = Arrays.asList("kör", "radar", "anna", "alma");
        List<String> expected = Arrays.asList("radar", "anna");

        List<String> result = utils.findPalindromes(words);
        assertEquals(expected, result);
    }

    @Test
    void testCountUniqueChars() {
        String input = "hello";
        int expected = 4;

        int result = utils.countUniqueChars(input);
        assertEquals(expected, result);
    }

    @Test
    void testHasDuplicates() {
        List<Integer> listWithDuplicates = Arrays.asList(1,2,3,3,4);
        List<Integer> listWithoutDuplicates = Arrays.asList(1,2,3,4,5);

        assertTrue(utils.hasDuplicates(listWithDuplicates));
        assertFalse(utils.hasDuplicates(listWithoutDuplicates));
    }
}