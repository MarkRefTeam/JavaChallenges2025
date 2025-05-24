package org.example;

public class Triangle extends Shape {

    private double  sideA;
    private double  sideB;
    private double  sideC;

    public Triangle() {
        this.sideA = 1.0;
        this.sideB = 1.0;
        this.sideC = 1.0;
    }

    public Triangle(double sideA,double sideB,double sideC) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    @Override
    public double getPerimeter() {
        return sideA + sideB + sideC;
    }

    @Override
    public double getArea() {
        double s = (sideA + sideB + sideC) / 2;
        return Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));
    }

    @Override
    public String toString() {
        return "Triangle with sides: " + sideA + ", " + sideB + ", " + sideC;
    }
}
