package org.example.Task4.Animals;

import org.example.Task4.Habitat;

public abstract sealed class Mammal extends BaseAnimal
        permits Lion, Elephant, Bat {

    public Mammal(String name, int age, Habitat habitat) {
        super(name, age, habitat);
    }
}