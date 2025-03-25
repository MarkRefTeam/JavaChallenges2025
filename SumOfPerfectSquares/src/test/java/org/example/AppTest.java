package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    //Actually we need it for correct run , but nothing important here!

    @Test
    void DummyTest() {
        int expected = 4;
        int actual = 2 + 2;
        assertEquals(expected, actual);
    }
}
