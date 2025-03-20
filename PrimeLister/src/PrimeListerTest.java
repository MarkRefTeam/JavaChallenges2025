import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PrimeListerTest {

    //org.junit.jupiter:junit-jupiter-api:5.8.1 in Maven!

    @Test
    public void testForPrimeLister() {

        assertTrue(PrimeLister.isPrime(7));
        assertFalse(PrimeLister.isPrime(10));
        assertTrue(PrimeLister.isPrime(2));
        assertFalse(PrimeLister.isPrime(1));
    }
}
