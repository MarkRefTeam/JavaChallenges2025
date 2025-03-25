package org.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PerfectSquareCalculatorTest {

    //Para+Source logic for practice!

    @ParameterizedTest
    @CsvSource({
            "1, 1",
            "2, 5",   // 1^2 + 2^2 = 1 + 4 = 5
            "3, 14",  // 1 + 4 + 9 = 14
            "5, 55"
    })
    void testPerfectSquareCalculator(int input, int expected) {
        int actual = PerfectSquareCalculator.CalculatePerfectSquareSum(input);
        assertEquals(expected, actual);
    }
}
