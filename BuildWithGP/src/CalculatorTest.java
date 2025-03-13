import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Well we're doing the test phase for Calculator for practice
 * I don't have extra idea yet just try it!
 * Okey , in first step just click in Project structure and push the "Ctrl+Alt+Shift+S" combination!
 * After just choose the libraries and click the " + " signal and select the "Maven"
 * If you did well the next step is the refresh program!
 * How can you do this? Just going File-> Invalidate Caches!!!After the program will suggest a restart!(recommended)
 * If you didn't burn out just write a @Test and choose the first command!It will be the org.junit.jupiter.api.Test;!
 * Congratulation your Test import was success!
 */

public class CalculatorTest {

    /**
     * Good! So the in the next step we're calling the methods from main project! Just one by one!
     * Forexample
     * oh and haven't told you, you must write this one
     * "import static org.junit.jupiter.api.Assertions.*;" manually for
     * assertEquals() and assertThrows() call , but I will tell you later what is this!
     * Okay...I don't know clearly, but it's need :D
     * <p>
     * So I write a test method with sum because it was the first method in main project!
     * What should we test? Forexample 1 + 2 = 3 ? And after just continue :)
     */

    @Test
    public void testSum() {
        int result = Calculator.sum(1, 2);
        assertEquals(3, result, "1 + 2 should be 3");
    }

    @Test
    public void testSubtract() {
        int result = Calculator.subtract(5, 2);
        assertEquals(3, result, "5 - 2 should be 3");
    }

    @Test
    public void testMultiply() {
        int result = Calculator.multiply(10, 2);
        assertEquals(20, result, "10 * 2 should be 20");
    }

    @Test
    public void testDivide() {
        int result = Calculator.divide(10, 2);
        assertEquals(5, result, "10 / 2 should be 5");
    }

    @Test
    public void testModulo() {
        int result = Calculator.modulo(10, 3);
        assertEquals(1, result, "10 % 2 should be 1");
    }

    /** At this point, I must use 8.0 and 0.0001 for precision tolerance in assertEquals
     *  because exponentiation returns a double.
     */

    @Test
    public void testExponentiation() {
        double result = Calculator.exponentiation(2,3);
        assertEquals(8.0, result,0.0001, "2 ^ 3 should be 8.0");
    }

    @Test
    public void testsquare() {
        double result = Calculator.square(5);
        assertEquals(25.0, result, "square should be 25.0");
    }

    @Test
    public void testsquareRoot() {
        double result = Calculator.squareRoot(4);
        assertEquals(16.0, result, "√4 should be 16.0");
    }
}




















