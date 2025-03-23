package org.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {

    @ParameterizedTest
    @CsvSource(
            value = {
                    "1;Perfect squares from 1 to 1:\\n1",
                    "2;Perfect squares from 1 to 2:\\n1",
                    "10;Perfect squares from 1 to 10:\\n1\\n4\\n9"
            },
            delimiter = ';'
    )
    void testFormattedOutputWithVariousMaxValues(int max, String expectedOutput) {

        // Generate perfect squares (1, 4, 9, etc.)
        List<Integer> squares = SquareNumberLister.generateSquares(max);

        // Call the formatter method
        String actual = App.formatSquares(squares, max);

        expectedOutput = expectedOutput.replace("\\n", "\n");

        // Compare expected and actual result (trimmed)
        assertEquals(expectedOutput.trim(), actual.trim());
    }
}