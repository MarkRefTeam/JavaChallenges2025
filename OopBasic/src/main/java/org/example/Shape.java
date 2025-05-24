package org.example;

public abstract class Shape {

    public abstract double getPerimeter();

    public abstract double getArea();

    @Override
    public String toString() {
        return "This is a shape.";
    }
}


