package org.example.Task4.Animals;

import org.example.Task4.DietType;
import org.example.Task4.Habitat;

public non-sealed class Lion extends Mammal {
    private final double maneLengthCm;

    public Lion(String name, int age, Habitat habitat, double maneLengthCm) {
        super(name, age, habitat);
        this.maneLengthCm = maneLengthCm;
    }

    public double getManeLengthCm() { return maneLengthCm; }

    @Override
    public DietType getDietType() {
        return DietType.CARNIVORE;
    }

    @Override
    public boolean isEndangered() {
        return true;
    }
}