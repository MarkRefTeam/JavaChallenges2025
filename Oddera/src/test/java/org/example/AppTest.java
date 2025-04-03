package org.example;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {

    @Test
    public void testCreateYourCharter() {
        assertEquals("Warrior", App.createYourCharter(1));
        assertEquals("Mage", App.createYourCharter(2));
        assertEquals("Archer", App.createYourCharter(3));
        assertEquals("Invalid Choice", App.createYourCharter(4));
    }
    @Test
    public void testAddToParty() {
        int input = 10;
        int result = App.addToParty(input);
        System.out.println("Add to party: " + result);
    }
}

