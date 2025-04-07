package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.example.App.hasXorInPseudo;
import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    @Test
    void testGetThirtyPercent() {

        System.out.println(App.getThirtyPercent(100));
    }

    @Test
    void testGetFortyDotEightPercent() {

        System.out.println(App.getFortyTwoDotEightPercent(100));
    }

    @Test
    void testHasXorInPseudo() {

        //true ^ false ^ true = false;
        boolean[] testArray1 = {true, false, true};
        System.out.println("Test 1: " + hasXorInPseudo(testArray1));
        assertFalse(App.hasXorInPseudo(testArray1));

        //true ^ true = false;
        boolean[] testArray2 = {true, true};
        System.out.println("Test 2: " + hasXorInPseudo(testArray2));
        assertFalse(App.hasXorInPseudo(testArray2));

        //true ^ false = true;
        boolean[] testArray3 = {true, false};
        System.out.println("Test 3: " + hasXorInPseudo(testArray3));
        assertTrue(App.hasXorInPseudo(testArray3));

        //false ^ false ^ false = false;
        boolean[] testArray4 = {false, false, false};
        System.out.println("Test 4: " + hasXorInPseudo(testArray4));
        assertFalse(App.hasXorInPseudo(testArray4));

        //true ^ true ^ true = true;
        boolean[] testArray5 = {true, true, true};
        System.out.println("Test 5: " + hasXorInPseudo(testArray5));
        assertTrue(App.hasXorInPseudo(testArray5));
    }

    //Okey Let's try the steam!

    // Test method with parameterized input

    @ParameterizedTest
    @MethodSource("provideXorTestData")
    void testHasXorInPseudo_withVariousInputs(boolean[] input, boolean expected) {
        assertEquals(expected, App.hasXorInPseudo(input));
    }

    //Steam provider method

    static Stream<org.junit.jupiter.params.provider.Arguments> provideXorTestData() {
        return Stream.of(
                Arguments.of(new boolean[]{true, false, true}, false),
                Arguments.of(new boolean[]{true, true}, false),
                Arguments.of(new boolean[]{true, false}, true),
                Arguments.of(new boolean[]{false, false, false}, false),
                Arguments.of(new boolean[]{true, true, true}, true)
        );
    }

    /**
     * Stream-based parameterized test for the hasXorInPseudo method.
     * This test checks multiple boolean arrays to verify XOR behavior.
     *
     * @param input boolean array for XOR evaluation
     * @param expected the expected result of the XOR logic
     */
}
