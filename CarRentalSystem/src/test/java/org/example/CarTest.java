package org.example;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    void testCalculateRentalCost() {
        Car car = new Car("ABC-123", 50.0, Brand.MERCEDES, "C-Class");
        double cost = car.calculateRentalCost(3);
        assertEquals(150.0, cost, 0.0001);
    }

    @Test
    void testDisplayInfo() {
        Car car = new Car("XYZ-789", 30.0, Brand.TRABANT, "601");


        PrintStream originalOut = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));

        car.displayInfo();

        System.setOut(originalOut);

        String output = baos.toString();

        assertTrue(output.contains("Brand: TRABANT"));
        assertTrue(output.contains("Model: 601"));
        assertTrue(output.contains("Plate Number: XYZ-789"));
        assertTrue(output.contains("Rent Price: 30.0"));
    }
}

