package org.example.Task4.Animals;

import org.example.Task4.DietType;
import org.example.Task4.Habitat;

public non-sealed class Bat extends Mammal {
    private final double wingspanMeters;

    public Bat(String name, int age, Habitat habitat, double wingspanMeters) {
        super(name, age, habitat);
        this.wingspanMeters = wingspanMeters;
    }

    public double getWingspanMeters() { return wingspanMeters; }

    @Override
    public DietType getDietType() {
        return DietType.OMNIVORE;
    }
}
