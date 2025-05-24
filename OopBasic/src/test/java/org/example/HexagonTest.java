package org.example;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HexagonTest {

    @Test
    public void testPerimeter() {
        Hexagon hex = new Hexagon(1.0);
        assertEquals(6.0, hex.getPerimeter(),0.0001);
    }

    @Test
    public void testArea() {
        Hexagon hex = new Hexagon(1.0);
        assertEquals(2.598076211353316, hex.getArea(), 0.0001);
    }

    @Test
    public void testToString() {
        Hexagon hex = new Hexagon(1.0);
        assertEquals("Hexagon with side: 1.0", hex.toString());
    }
}
