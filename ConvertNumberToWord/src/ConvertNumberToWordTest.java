import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ConvertNumberToWordTest {

    /** So, Welcome in the Test phase! We're doing this for Test yeah that's right
     * and ... and this more important for calling the methods!
     * Why its need it? Why in this form?
     * For example if we play in team , everybody can join with easily and if we have a correct test
     * its good start for call a correct statement in coding!
     * How should we start? Yes, Maden!
     * Just hit the ctrl+alt+shift+S combination ,choose the libraries and " + " sign!
     * Here is the import command to you! Use this one "//org.junit.jupiter:junit-jupiter-api:5.8.1"
     * and its will work!
     * Next step! Call this import in manually : "import static org.junit.jupiter.api.Assertions.*;"
     * for assertEquals test option!
     */

    //2.Step

    @Test
    public void convertNumberToWord() {
        assertEquals("One" , ConvertNumberToWord.convert(1));
        assertEquals("Twenty" , ConvertNumberToWord.convert(20));
        assertEquals("Ninety Nine".trim(), ConvertNumberToWord.convert(99).trim());
        // I need use a .trim for " - " signal! Its isn't work without it!
        assertEquals("One Hundred" , ConvertNumberToWord.convert(100));
        assertEquals("Nine Hundred Ninety Nine" , ConvertNumberToWord.convert(999));
    }

    /** Well your first test false ,because you don't had a Method!
     * So we're going back to the main program and start building with a String Method!
     */
}


