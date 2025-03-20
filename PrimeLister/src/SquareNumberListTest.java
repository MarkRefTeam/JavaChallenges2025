import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SquareNumberListTest {

    @Test
    public void testIsPrime() {

        assertFalse(PrimeLister.isPrime(8));
        assertFalse(PrimeLister.isPrime(50));
        assertTrue(PrimeLister.isPrime(2));
        assertFalse(PrimeLister.isPrime(10));
        assertFalse(PrimeLister.isPrime(1));
        assertTrue(PrimeLister.isPrime(9973));
        assertFalse(PrimeLister.isPrime(0));   //why not? :D
    }
}
