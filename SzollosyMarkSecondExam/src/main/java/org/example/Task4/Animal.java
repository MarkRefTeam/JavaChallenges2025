package org.example.Task4;

public interface Animal {
    DietType getDietType();

    default boolean isEndangered() {
        return false;
    }
}
