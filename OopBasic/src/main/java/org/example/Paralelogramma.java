package org.example;

public class Paralelogramma extends Shape {

    private double shortSide;
    private double longSide;
    private double height;

    public Paralelogramma() {
        this.shortSide = 1.0;
        this.longSide = 3.0;
        this.height = 2.0;
    }

    public Paralelogramma(double shortSide,double longSide) {
        this.shortSide = shortSide;
        this.longSide = longSide;
    }

    @Override
    public double getPerimeter() {
        return 2 * (shortSide + longSide);
    }

    @Override
    public double getArea() {
        return longSide * height;
    }

    @Override
    public String toString() {
        return "Paralelogramma with shortSide: " + shortSide + "and longSide: " + longSide;
    }
}
