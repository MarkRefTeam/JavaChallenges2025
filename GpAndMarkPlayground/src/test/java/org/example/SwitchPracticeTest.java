package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SwitchPracticeTest {

    @Test
    public void testPlanetName() {
        assertEquals("Unknown",SwitchPractice.getPlanetName(0));
        assertEquals("Mercury",SwitchPractice.getPlanetName(1));
        assertEquals("Venus",SwitchPractice.getPlanetName(2));
        assertEquals("Earth",SwitchPractice.getPlanetName(3));
        assertEquals("Mars",SwitchPractice.getPlanetName(4));
        assertEquals("Jupiter",SwitchPractice.getPlanetName(5));
        assertEquals("Saturn",SwitchPractice.getPlanetName(6));
        assertEquals("Uranus",SwitchPractice.getPlanetName(7));
        assertEquals("Neptune",SwitchPractice.getPlanetName(8));
        assertEquals("Pluto",SwitchPractice.getPlanetName(9));
    }

    @Test
    public void testOfTheSeason() {
        assertEquals("Winter",SwitchPractice.monthOfTheSeason(12));
        assertEquals("Spring",SwitchPractice.monthOfTheSeason(4));
        assertEquals("Summer",SwitchPractice.monthOfTheSeason(8));
        assertEquals("Autumn",SwitchPractice.monthOfTheSeason(10));
        assertEquals("Unknown",SwitchPractice.monthOfTheSeason(13));
    }
}
