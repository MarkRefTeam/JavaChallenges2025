package org.example;

public class Trapezoid extends Shape {

    private double baseA;
    private double baseB;
    private double sideA;
    private double sideB;
    private double height;

    public Trapezoid() {
        this.baseA = 5.0;
        this.baseB = 3.0;
        this.sideA = 4.0;
        this.sideB = 4.0;
        this.height = 2.0;
    }

    public Trapezoid(double baseA,double baseB,double sideA,double sideB,double height) {
        this.baseA = baseA;
        this.baseB = baseB;
        this.sideA = sideA;
        this.sideB = sideB;
        this.height = height;
    }

    @Override
    public double getPerimeter() {
        return baseA + baseB + sideA + sideB;
    }

    @Override
    public double getArea() {
        return ((baseA + baseB) * height) / 2;
    }

    @Override
    public String toString() {
        return "Trapezoid with baseA: " + baseA + "baseB: " + baseB + "sideA" + sideA + "sideB" + sideB + "height" + height;
    }
}
