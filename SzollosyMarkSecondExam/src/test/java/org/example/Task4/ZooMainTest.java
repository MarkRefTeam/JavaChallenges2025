package org.example.Task4;

import org.example.Task4.Animals.BaseAnimal;
import org.example.Task4.Animals.Bat;
import org.example.Task4.Animals.Elephant;
import org.example.Task4.Animals.Lion;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ZooMainTest {

    @Test
    void testAnimalsHaveCorrectProperties() {
        Habitat savannah = new Habitat("Pride Lands", HabitatType.SAVANNAH);
        Habitat grassland = new Habitat("Great Plains", HabitatType.GRASSLAND);
        Habitat cave = new Habitat("Echo Cavern", HabitatType.CAVE);

        List<Animal> animals = List.of(
                new Lion("Simba", 5, savannah, 25.0),
                new Elephant("Dumbo", 12, grassland, 2.1),
                new Bat("Bruce", 3, cave, 1.4)
        );

        // Lion
        Animal simba = animals.get(0);
        assertEquals("Simba", ((BaseAnimal) simba).getName());
        assertEquals(DietType.CARNIVORE, simba.getDietType());
        assertTrue(simba.isEndangered());

        // Elephant
        Animal dumbo = animals.get(1);
        assertEquals("Dumbo", ((BaseAnimal) dumbo).getName());
        assertEquals(DietType.HERBIVORE, dumbo.getDietType());
        assertTrue(dumbo.isEndangered());

        // Bat
        Animal bruce = animals.get(2);
        assertEquals("Bruce", ((BaseAnimal) bruce).getName());
        assertEquals(DietType.OMNIVORE, bruce.getDietType());
        assertFalse(bruce.isEndangered());
    }
}