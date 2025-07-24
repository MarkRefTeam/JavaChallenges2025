package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class RentalSystemTest {

    private RentalSystem rentalSystem;
    private Car car1, car2;

    @BeforeEach
    void setup() {
        rentalSystem = new RentalSystem();
        car1 = new Car("ABC-123", 50.0, Brand.MERCEDES, "C-Class");
        car2 = new Car("XYZ-789", 30.0, Brand.TRABANT, "601");
        rentalSystem.addCar(car1);
        rentalSystem.addCar(car2);
    }

    @Test
    void testAddCarAndDisplay() {

        PrintStream originalOut = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));

        rentalSystem.displayAvailableCars();

        System.setOut(originalOut);

        String output = baos.toString();
        assertTrue(output.contains("Brand: MERCEDES"));
        assertTrue(output.contains("Brand: TRABANT"));
    }

    @Test
    void testFindCarByPlateNumber() {
        Car found = rentalSystem.findCarByPlateNumber("ABC-123");
        assertNotNull(found);
        assertEquals(car1, found);

        Car notFound = rentalSystem.findCarByPlateNumber("NON-EXISTENT");
        assertNull(notFound);
    }

    @Test
    void testRentCar() {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));

        rentalSystem.rentCar(car1, 3);

        System.setOut(originalOut);

        String output = baos.toString();

        assertTrue(output.contains("Renting Car: ABC-123"));
        assertTrue(output.contains("Brand: MERCEDES"));
        assertTrue(output.contains("Days: 3"));
        assertFalse(output.contains("Total cost: $150.00"));
    }
}

