package org.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

public class PrimeListerTest {

    // This class tests whether the prime checking works correctly.

    @ParameterizedTest
    @CsvSource({
            // Test data: number, expected result
            "2, true",
            "3, true",
            "4, false",
            "5, true",
            "9, false",
            "11, true",
            "1, false"
    })

    void testIsPrime_withVariousInputs(int number, boolean expected) {
        // We call the isPrime method with the test number.
        boolean actual = PrimeLister.isPrime(number);

        // We verify that the result matches the expected value.
        assertEquals(expected, actual);
    }
}
