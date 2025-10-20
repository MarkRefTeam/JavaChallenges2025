package org.example;

import org.example.Task4.Animal;
import org.example.Task4.Animals.BaseAnimal;
import org.example.Task4.Animals.Bat;
import org.example.Task4.Animals.Elephant;
import org.example.Task4.Animals.Lion;
import org.example.Task4.Habitat;
import org.example.Task4.HabitatType;

import java.util.ArrayList;
import java.util.List;

public class ZooMain {
    public static void main(String[] args) {
        Habitat savannah  = new Habitat("Pride Lands", HabitatType.SAVANNAH);
        Habitat grassland = new Habitat("Great Plains", HabitatType.GRASSLAND);
        Habitat cave      = new Habitat("Echo Cavern", HabitatType.CAVE);

        List<Animal> animals = new ArrayList<>();
        animals.add(new Lion("Simba", 5, savannah, 25.0));
        animals.add(new Elephant("Dumbo", 12, grassland, 2.1));
        animals.add(new Bat("Bruce", 3, cave, 1.4));

        animals.forEach(a -> {
            BaseAnimal ba = (BaseAnimal) a;
            System.out.printf(
                    "Name: %s | Age: %d | Diet: %s | Endangered: %b | Habitat: %s%n",
                    ba.getName(),
                    ba.getAge(),
                    a.getDietType(),
                    a.isEndangered(),
                    ba.getHabitat().getHabitatType()
            );
        });
    }
}
