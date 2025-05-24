package org.example;

public class Hexagon extends Shape {

    private double side;

    public Hexagon() {
        this.side = 1.0;
    }

    public Hexagon(double side) {
        this.side = side;
    }

    @Override
    public double getPerimeter() {
        return 6 * side;
    }

    @Override
    public double getArea() {
        return (3 * Math.sqrt(3) / 2) * side * side;
    }

    @Override
    public String toString() {
        return "Hexagon with side: " + side;
    }


}
