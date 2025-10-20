package org.example.Task4.Animals;

import org.example.Task4.Animal;
import org.example.Task4.Habitat;

public abstract class BaseAnimal implements Animal {
    private final String name;
    private final int age;
    private final Habitat habitat;

    public BaseAnimal(String name, int age, Habitat habitat) {
        this.name = name;
        this.age = age;
        this.habitat = habitat;
    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public Habitat getHabitat() { return habitat; }
}
