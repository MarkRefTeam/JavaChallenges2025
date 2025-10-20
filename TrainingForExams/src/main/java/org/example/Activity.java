package org.example;

public interface Activity {
    double caloriesBurned();

    default boolean isIntense() {
        return caloriesBurned() / (getDurationMinutes() / 60.0) > 600;
    }

    int getDurationMinutes();
}
