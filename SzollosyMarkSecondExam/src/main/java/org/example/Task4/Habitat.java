package org.example.Task4;

public class Habitat {

    private final String name;
    private final HabitatType habitatType;

    public Habitat(String name, HabitatType habitatType) {
        this.name = name;
        this.habitatType = habitatType;
    }

    public String getName() {
        return name;
    }

    public HabitatType getHabitatType() {
        return habitatType;
    }
}