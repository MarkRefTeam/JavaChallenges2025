import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class DifficultMethodsTest {

    /**
     * Okay !!! Well we must do a test phase for DifficultMethods.java
     * Just for practice!!Later we will do the NumberChecks too but step by step!
     * Good luck!
     * So in a first try we couldn't try it ...because we must call this new src for Maden again!
     * Ctrl+Shift+Alt+S /// Libraries , " + " and call for Maden! If everything fine you can try it with
     * Right-click on the method name and click the Run Test variation!
     */


    @Test
    public void sumOf2DArray() {

        int[][] numbers = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int result = 45;
        assertEquals(result, DifficultMethods.sumOf2DArray(numbers));

        //Its will work with
        //import static org.junit.jupiter.api.Assertions.assertEquals;
    }

    @Test
    public void sumEachRow() {
        int[][] numbers = {
                {1, 1, 1},
                {2, 2, 2},
                {3, 3, 3}
        };

        int[] result = {3, 6, 9};
        assertArrayEquals(result, DifficultMethods.sumEachRow(numbers));

        //Its will work with
        //import static org.junit.jupiter.api.Assertions.assertArrayEquals;
    }

    /**
     * But what is this and why you should add it? Let's see this!
     * We use static imports to directly call methods from the Assertions class
     * in JUnit without having to prefix them with Assertions. every time.
     * ///
     * "assertEquals" is used for comparing primitive values or objects
     * that have properly overridden equals().
     * ///
     * assertArrayEquals is specifically designed for comparing arrays,
     * since assertEquals would only compare memory addresses instead of actual content.
     * ///
     * For Example:
     * int[] expected = {1, 2, 3};
     * int[] actual = {1, 2, 3};
     * assertEquals(expected, actual); //This would fail because it compares references!
     * assertArrayEquals(expected, actual);  //This works correctly!
     * ///
     * By importing them statically, we can use assertEquals() and assertArrayEquals() directly,
     * our test code cleaner and more readable.
     */

    @Test
    public void sumMainDiagonal() {
        int[][] numbers = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int expected = 1 + 5 + 9;
        assertEquals(expected, DifficultMethods.sumMainDiagonal(numbers));
    }

    @Test
    public void diagonalDifference() {
        int[][] matrix = {
                {1, 1, 1, 1},
                {1, 0, 0, 0},
                {1, 2, 3, 2},
                {2, 2, 2, 2}
        };
        int mainDiagonalSum = 1 + 0 + 3 + 2;
        int secondaryDiagonalSum = 1 + 0 + 2 + 2;

        int expected = Math.abs(mainDiagonalSum - secondaryDiagonalSum);
        assertEquals(expected, DifficultMethods.diagonalDifference(matrix));
    }
}
