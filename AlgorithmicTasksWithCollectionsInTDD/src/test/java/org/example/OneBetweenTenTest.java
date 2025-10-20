package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.example.OneBetweenTenTask.*;
import static org.junit.jupiter.api.Assertions.*;

public class OneBetweenTenTest {

    @Test
    void testRemoveDuplicatesBasic() {
        assertEquals("ban", removeDuplicates("banana"));
    }

    @Test
    void testRemoveDuplicatesEmpty() {
        assertEquals("", removeDuplicates(""));
    }

    @Test
    void testRemoveDuplicatesAllUnique() {
        assertEquals("abc", removeDuplicates("abc"));
    }

    @Test
    void testRemoveDuplicatesAllSame() {
        assertEquals("a", removeDuplicates("aaaaa"));
    }

    @Test
    void testRemoveDuplicatesWithSpaces() {
        assertEquals("abc", removeDuplicates("aabbcc"));
    }

    //Anagrams!

    @Test
    void testAnagramsBasicTrue() {
        assertTrue(areAnagrams("listen", "silent"));
    }

    @Test
    void testAnagramsDifferentLength() {
        assertFalse(areAnagrams("abc", "ab"));
    }

    @Test
    void testAnagramsNotAnagram() {
        assertFalse(areAnagrams("hello", "world"));
    }

    @Test
    void testAnagramCaseSensitive() {
        assertFalse(areAnagrams("Listen", "silent"));
    }

    @Test
    void testAnagramsWithRepeatingChars() {
        assertTrue(areAnagrams("aabbcc", "abcabc"));
    }

    //Unique:

    @Test
    void testGetUniqueUnion() {
        List<Integer> list1 = Arrays.asList(1, 2, 2, 1, 1);
        List<Integer> list2 = Arrays.asList(1, 3, 4);
        List<Integer> expected = Arrays.asList(1, 2, 3, 4);

        List<Integer> result = getUniqueUnion(list1, list2);

        assertTrue(result.containsAll(expected) && expected.containsAll(result));
    }

    @Test
    void testFrequencyCounter() {
        List<Integer> numbers = Arrays.asList(1, 2, 2, 3, 1);
        Map<Integer, Integer> expected = new HashMap<>();
        expected.put(1, 2);
        expected.put(2, 2);
        expected.put(3, 1);

        assertEquals(expected, frequencyCounter(numbers));
    }

    @Test
    void testHasUniqueLetters() {
        assertFalse(OneBetweenTenTask.hasUniqueLetters("ball"));
        assertTrue(OneBetweenTenTask.hasUniqueLetters("lamp"));
    }
}

class CollectionTasksTest {

    Map<Character, Boolean> map;

    @BeforeEach
    void setup() {
        map = new HashMap<>();
    }

    @ParameterizedTest
    @CsvSource({
            "lamp, true",
            "ball, false",
            "code, true",
            "success, false"
    })
    void testHasUniqueLettersWithMap(String input, boolean expected) {
        assertEquals(expected, hasUniqueLettersWithMap(input));
    }


    @Test
    void testSomething() {
        map.put('a', true);
        assertTrue(map.containsKey('a'));
    }

}