package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class PerfectSquareCalculatorTest {

    //Para+Source logic for practice!

    @ParameterizedTest
    @CsvSource({
            "1, true",
            "2, false",
            "3, false",
            "4, true",
            "5, false",
            "25, true",
            "26, false",
            "-4, false",
            "49, true"
    })
    void testPerfectSquareCalculator(int input, boolean expected) {
        boolean actual = PerfectSquareCalculator.perfectSquareCalculator(input);
        assertEquals(expected, actual);

        assertTrue(PerfectSquareCalculator.perfectSquareCalculator(25));
        assertTrue(PerfectSquareCalculator.perfectSquareCalculator(1));
        assertTrue(PerfectSquareCalculator.perfectSquareCalculator(49));

        assertFalse(PerfectSquareCalculator.perfectSquareCalculator(26));
        assertFalse(PerfectSquareCalculator.perfectSquareCalculator(-4));
        assertTrue(PerfectSquareCalculator.perfectSquareCalculator(0));
    }
}
