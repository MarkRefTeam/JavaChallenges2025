package org.example;

public class Rhombus extends Shape {

    private double side;
    private double height;

    public Rhombus() {
        this.side = 1.0;
        this.height = 1.0;
    }

    public Rhombus(double side, double height) {
        this.side = side;
        this.height = height;
    }

    @Override
    public double getPerimeter() {
        return 4 * side;
    }

    @Override
    public double getArea() {
        return side * height;
    }

    @Override
    public String toString() {
        return "Rhombus with side: " + side + "and height: " + height;
    }
}
