package org.example.Task4.Animals;

import org.example.Task4.DietType;
import org.example.Task4.Habitat;

public final class Elephant extends Mammal {
    private final double trunkLengthMeters;

    public Elephant(String name, int age, Habitat habitat, double trunkLengthMeters) {
        super(name, age, habitat);
        this.trunkLengthMeters = trunkLengthMeters;
    }

    public double getTrunkLengthMeters() { return trunkLengthMeters; }

    @Override
    public DietType getDietType() {
        return DietType.HERBIVORE;
    }

    @Override
    public boolean isEndangered() {
        return true;
    }
}