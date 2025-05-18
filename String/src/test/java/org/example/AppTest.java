package org.example;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AppTest {

    @Test
    public void testCountB() {
        String testInput = "bBffBDGddbB";
        int result = App.countB(testInput);
        Assertions.assertEquals(3,result);
    }

    @Test
    public void testReturnHello() {
        String testInput = "helloabchelloasvbhellogdvmhello";
        int result = App.returnHello(testInput);
        Assertions.assertEquals(4, result);

    }
}
