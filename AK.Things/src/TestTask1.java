import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestTask1 {

    @Test
    void testFactorial() {
        int n = 1;
        int result = Task1.factorial(n);
        Assertions.assertEquals(1, result);

        System.out.println(result);

    }
    @Test
    void testFactorial2() {
        int n = 5;
        int result = Task1.factorial(n);

        Assertions.assertEquals(120, result);
        System.out.println(result);
    }

    @Test
    void testBlreturn() {
        boolean[]array = {true,false,true};
        boolean result = Task1.Blreturn(array);

        assertFalse(result);
        System.out.println(false);
    }

    @Test
    void testBlreturn2() {
        boolean[]array = {true,true,true,true};
        boolean result = Task1.Blreturn(array);

        assertTrue(result);
        System.out.println(true);
    }
}
