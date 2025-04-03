import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class TipCalculatorTest {

    @Test
    public void testValidTipCalculation() {

        //Given
        int[] prices = {2000, 250, 300, 50, 250};
        int percentage = 20;

        //when
        int result = TipCalculator.calculateTip(prices, percentage);

        //Then
        assertEquals(result, 570, "Tip calculated should be 570");
    }

    @Test
    public void testTooLowPercentage() {

        //Given
        int[] prices = {2000, 250, 300, 50, 250};
        int percentage = 5;  //Too low

        //When
        int result = TipCalculator.calculateTip(prices, percentage);

        //Then
        assertEquals(result, -1, "Return with -1");

    }

    @Test
    public void testTooHighPercentage() {

        //Given
        int[] prices = {2000, 250, 300, 50, 250};
        int percentage = 90;   //Too high

        //When
        int result = TipCalculator.calculateTip(prices, percentage);

        //Then
        assertEquals(result, -1, "Return with -1 for invalid percentage");
    }
}
