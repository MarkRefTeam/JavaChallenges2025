package org.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SquareNumberListerTest {

    @ParameterizedTest
    @CsvSource({
            "1, 1",
            "2, 1, 4",
            "3, 1, 4, 9"
    })
    void testGenerateSquaresParameterized(int n, String expectedCsv) {

        //Split the expected result string (expectedCsv) by commas.
        //Create a list of Integers.
        //Trim and parse each value to Integer.

        String[] parts = expectedCsv.split(",");
        List<Integer> expected = new ArrayList<>();

        for (String part : parts) {
            expected.add(Integer.parseInt(part.trim()));
        }

        List<Integer> actual = SquareNumberLister.generateSquares(n);

        //Assert that both lists are exactly the same

        assertEquals(expected, actual);
    }
}
