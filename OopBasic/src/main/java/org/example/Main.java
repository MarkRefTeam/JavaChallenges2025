package org.example;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Shape> shapes = new ArrayList<>();

        while (true) {
            System.out.println("Which one figure do you like?");
            System.out.println("1. Circle");
            System.out.println("2. Rectangle");
            System.out.println("3. Triangle");
            System.out.println("4. Hexagon");
            System.out.println("5. Rhombus");
            System.out.println("6. Parallelogram");
            System.out.println("7. Trapezoid");
            System.out.println("0. Quit");

            int choice = scanner.nextInt();

            if (choice == 0) {
                System.out.println("Quit from the program");
                break;
            } else {
                switch (choice) {
                    case 1: {
                        System.out.print("Give me the radius: ");
                        double radius = scanner.nextDouble();
                        Circle circle = new Circle(radius);
                        shapes.add(circle);
                        System.out.println("Circle taken");
                        break;
                    }
                    case 2: {
                        System.out.print("Give width: ");
                        double width = scanner.nextDouble();
                        System.out.println("Give height: ");
                        double height = scanner.nextDouble();
                        Rectangle rectangle = new Rectangle(width, height);
                        shapes.add(rectangle);
                        System.out.println("Rectangle taken");
                    }
                    case 3: {
                        System.out.println("Give a Side A");
                        double sideA = scanner.nextDouble();
                        System.out.println("Give a Side B");
                        double sideB = scanner.nextDouble();
                        System.out.println("Give a Side C");
                        double sideC = scanner.nextDouble();
                        Triangle triangle = new Triangle(sideA, sideB, sideC);
                        shapes.add(triangle);
                        System.out.println("Triangle taken");
                    }
                    case 4: {
                        System.out.print("Give the side length: ");
                        double side = scanner.nextDouble();
                        Hexagon hexagon = new Hexagon(side);
                        shapes.add(hexagon);
                        System.out.println("Hexagon taken");
                    }
                    case 5: {
                        System.out.println("Give a side and the height");
                        double side = scanner.nextDouble();
                        double height = scanner.nextDouble();
                        Rhombus rhombus = new Rhombus(side, height);
                        shapes.add(rhombus);
                        System.out.println("Rhombus taken with side = " + side + " and height = " + height);
                    }
                    case 6: {
                        System.out.println("Give a short side");
                        double shortSide = scanner.nextDouble();
                        System.out.println("Give a long side");
                        double longSide = scanner.nextDouble();
                        Paralelogramma paralelogramma = new Paralelogramma(shortSide, longSide);
                        shapes.add(paralelogramma);
                        System.out.println("Paralelogramma taken with short side = " + shortSide +
                                ", long side = " + longSide);
                    }
                    case 7: {
                        System.out.println("Give a first base");
                        double baseA = scanner.nextDouble();
                        System.out.println("Give a second Base");
                        double baseB = scanner.nextDouble();
                        System.out.println("Give a side A");
                        double sideA = scanner.nextDouble();
                        System.out.println("Give a side B");
                        double sideB = scanner.nextDouble();
                        System.out.println("Give a height");
                        double height = scanner.nextDouble();
                        Trapezoid trapezoid = new Trapezoid(baseA,baseB,sideA,sideB,height);
                        shapes.add(trapezoid);
                        System.out.println("Trapezoid taken with base 1: " + baseA + "base 2 " + baseB + "first side: " + sideA +
                                "second side: " + sideB +" and height" + height);
                    }
                    default:
                        System.out.println("Unknowing choice");
                }
            }
        }

        System.out.println("All figures:");
        for (Shape shape : shapes) {
            System.out.println(shape);
        }

        scanner.close();


        Circle circle1 = new Circle();
        Circle circle2 = new Circle(3.5);
        Rectangle rectangle1 = new Rectangle();
        Rectangle rectangle2 = new Rectangle(1.0, 2.0);
        Rectangle size1 = new Rectangle(4.0);
        Rectangle size2 = new Rectangle(7.5);
        Triangle sideA = new Triangle();
        Triangle sideB = new Triangle();
        Triangle sideC = new Triangle();
        Hexagon H = new Hexagon();
        Rhombus R = new Rhombus();
        Paralelogramma P = new Paralelogramma();
        Trapezoid T = new Trapezoid();

        shapes.add(new Circle(1.0));
        shapes.add(new Rectangle(1.0, 2.0));
        shapes.add(new Triangle(3, 4, 5));
        shapes.add(new Hexagon(1.0));
        shapes.add(new Rhombus(3.0, 2.0));
        shapes.add(new Paralelogramma(1.0, 3.0));
        shapes.add(new Trapezoid(5.0, 3.0, 4.0, 4.0, 2.0));


        for (Shape shape : shapes) {
            if (shape.getPerimeter() > 10) {
                System.out.println("Large shapes: ");
                System.out.println(shape);
                System.out.println("Area: " + shape.getArea());
                System.out.println("Perimeter: " + shape.getPerimeter());
                System.out.println();
            }

            System.out.println(circle1);
            System.out.println("Area: " + circle1.getArea());
            System.out.println("Perimeter: " + circle1.getPerimeter());

            System.out.println(circle2);
            System.out.println("Area: " + circle2.getArea());
            System.out.println("Perimeter: " + circle2.getPerimeter());

            System.out.println(rectangle1);
            System.out.println("Area: " + rectangle1.getArea());
            System.out.println("Perimeter: " + rectangle1.getPerimeter());

            System.out.println(rectangle2);
            System.out.println("Area: " + rectangle2.getArea());
            System.out.println("Perimeter: " + rectangle2.getPerimeter());

            System.out.println(size1);
            System.out.println("Area: " + size1.getArea());
            System.out.println("Perimeter: " + size1.getPerimeter());

            System.out.println(size2);
            System.out.println("Area: " + size2.getArea());
            System.out.println("Perimeter: " + size2.getPerimeter());

            System.out.println(sideA);
            System.out.println("Area: " + sideA.getArea());
            System.out.println("Perimeter: " + sideA.getPerimeter());

            System.out.println(sideB);
            System.out.println("Area: " + sideB.getArea());
            System.out.println("Perimeter: " + sideB.getPerimeter());

            System.out.println(sideC);
            System.out.println("Area: " + sideC.getArea());
            System.out.println("Perimeter: " + sideC.getPerimeter());

            System.out.println(H);
            System.out.println("Area: " + H.getArea());
            System.out.println("Perimeter: " + H.getPerimeter());

            System.out.println(R);
            System.out.println("Area: " + R.getArea());
            System.out.println("Perimeter: " + R.getPerimeter());

            System.out.println(P);
            System.out.println("Area: " + P.getArea());
            System.out.println("Perimeter: " + P.getPerimeter());

            System.out.println(T);
            System.out.println("Area: " + T.getArea());
            System.out.println("Perimeter: " + T.getPerimeter());


        }
    }
}
